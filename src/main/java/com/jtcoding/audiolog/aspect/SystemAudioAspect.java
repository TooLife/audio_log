package com.jtcoding.audiolog.aspect;

import com.jtcoding.audiolog.annotation.AudioAction;
import com.jtcoding.audiolog.common.JacksonSerializer;
import com.jtcoding.audiolog.dao.AudioLogDao;
import com.jtcoding.audiolog.common.enums.Action;
import com.jtcoding.audiolog.model.AudioLog;
import com.jtcoding.audiolog.model.Company;
import com.jtcoding.audiolog.model.Plan;
import com.jtcoding.audiolog.service.CompanyService;
import com.jtcoding.audiolog.service.PlanService;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Objects;
import java.util.UUID;

/**
 * @author jason.tang
 * @create 2019-01-21 14:01
 * @description 系统监控
 */

@Slf4j
@Aspect
@Component
public class SystemAudioAspect {

    @Autowired
    private CompanyService companyService;

    @Autowired
    private PlanService planService;

    @Autowired
    private AudioLogDao audioLogDao;

    /**
     * 拦截DELETE操作，记录被删除的数据
     * @param joinPoint
     */
    @Before(value = "execution(public * com.jtcoding.audiolog.dao..*.delete*(..))")
    public void doBefore(JoinPoint joinPoint) {
        Object[] args = joinPoint.getArgs();
        AudioAction audioAction = this.getAudioActionByJoinPoint(joinPoint);

        if (audioAction != null && audioAction.action() == Action.DELETE) {
            Object obj = null;
            switch (audioAction.targetTable()) {
                case "company":
                    int companyNum = (int) args[0];
                    obj = companyService.getCompanyByNum(companyNum);
                    break;
                case "plan":
                    int planNum = (int) args[0];
                    obj = planService.getPlanByNum(planNum);
                    break;
            }
            if (obj != null) {
                this.addAudioLog(obj, AudioLogDao.DELETE, UUID.randomUUID().toString());
            }
        }
    }

    /**
     * 拦截ADD操作，记录新增的数据
     * @param joinPoint
     */
    @After(value = "execution(public * com.jtcoding.audiolog.dao..*.add*(..))")
    public void doAfter(JoinPoint joinPoint) {
        AudioAction audioAction = this.getAudioActionByJoinPoint(joinPoint);
        if (audioAction != null && audioAction.action() == Action.ADD) {
            Object obj = joinPoint.getArgs()[0];
            this.addAudioLog(obj, AudioLogDao.ADD, UUID.randomUUID().toString());
        }
    }

    /**
     * 拦截UPDATE操作，记录更新前后的数据
     * @param pjp
     * @return
     * @throws Throwable
     */
    @Around(value = "execution(public * com.jtcoding.audiolog.dao..*.update*(..))")
    public Object doAround(ProceedingJoinPoint pjp) throws Throwable {
        AudioAction audioAction = this.getAudioActionByJoinPoint(pjp);
        Object proceed = null;
        if (audioAction != null && audioAction.action() == Action.UPDATE) {
            String uuid = UUID.randomUUID().toString();
            Object originalObj = null;
            Object arg = pjp.getArgs()[0];
            switch (audioAction.targetTable()) {
                case "company":
                    Company company = (Company) arg;
                    originalObj = companyService.getCompanyByNum(company.getCompanyNum());
                    break;
                case "plan":
                    Plan plan = (Plan) arg;
                    originalObj = planService.getPlanByNum(plan.getPlanNum());
                    break;
            }
            if (originalObj != null) {
                // 在执行原方法之前，记录旧数据
                this.addAudioLog(originalObj, AudioLogDao.UPDATE_NEW, uuid);
            }
            // 执行原方法
            proceed = pjp.proceed();
            // 在执行原方法之后，记录新数据
            this.addAudioLog(arg, AudioLogDao.UPDATE_ORIGINAL, uuid);
        }
        return proceed;
    }

    private void addAudioLog(Object obj, String type, String uuid) {
        String jsonString = JacksonSerializer.toJSONString(obj);
        AudioLog audioLog = AudioLog.builder().logID(uuid).logData(jsonString)
                .createDatetime(LocalDateTime.now()).type(type).build();
        audioLogDao.addAudioLog(audioLog);
    }

    /**
     * 根据JoinPoint对象获取目标方法上的注解
     * @param joinPoint
     * @return AudioAction
     */
    private AudioAction getAudioActionByJoinPoint(JoinPoint joinPoint) {
        String methodName = joinPoint.getSignature().getName();
        Method[] methods = joinPoint.getSignature().getDeclaringType().getMethods();

        Method tempMethod = Arrays.stream(methods)
                .filter(m -> m.getName().equals(methodName))
                .filter(m -> Objects.equals(m.getParameterTypes().length, joinPoint.getArgs().length))
                .findFirst()
                .orElse(null);
        if (tempMethod != null) {
            AudioAction audioAction = (AudioAction) Arrays.stream(tempMethod.getDeclaredAnnotations())
                    .filter(a -> a instanceof AudioAction)
                    .findFirst()
                    .orElse(null);
            if (audioAction != null ) {
                return audioAction;
            }
        }
        return null;
    }
}