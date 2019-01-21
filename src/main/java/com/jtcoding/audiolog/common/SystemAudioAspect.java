package com.jtcoding.audiolog.common;

import com.jtcoding.audiolog.annotation.AudioAction;
import com.jtcoding.audiolog.dao.AudioLogDao;
import com.jtcoding.audiolog.enums.Action;
import com.jtcoding.audiolog.model.AudioLog;
import com.jtcoding.audiolog.service.CompanyService;
import com.jtcoding.audiolog.service.PlanService;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.Objects;

/**
 * @author jason.tang
 * @create 2019-01-21 14:01
 * @description 系统监控
 */

@Slf4j
@Aspect
@Component
public class SystemAudioAspect {

    @Lazy
    @Autowired
    private CompanyService companyService;

    @Autowired
    private PlanService planService;

    @Lazy
    @Autowired
    private AudioLogDao audioLogDao;

    @Pointcut(value = "execution(public * com.jtcoding.audiolog.dao..*.add*(..)) || execution(public * com.jtcoding.audiolog.dao..*.update*(..)) || execution(public * com.jtcoding.audiolog.dao..*.delete*(..))")
    public void audio() {
    }

    @Before(value = "audio()")
    public void doBefore(JoinPoint joinPoint) {
        String methodName = joinPoint.getSignature().getName();
        Class declaringType = joinPoint.getSignature().getDeclaringType();
        Method[] methods = declaringType.getMethods();
        Object[] args = joinPoint.getArgs();

        AudioAction audioAction = this.getAudioActionByJoinPoint(methodName, methods, args);
        if (audioAction != null && audioAction.action() == Action.DELETE) {
            Object obj = null;
            switch (declaringType.getSimpleName()) {
                case "CompanyDao":
                    int companyNum = (int) args[0];
                    obj = companyService.getCompanyByNum(companyNum);
                    break;
                case "PlanDao":
                    int planNum = (int) args[0];
                    obj = planService.getPlanByNum(planNum);
                    break;
            }
            if (obj != null) {
                this.addAudioLog(obj);
            }
        }
    }

    @After(value = "audio()")
    public void doAfter(JoinPoint joinPoint) {
        String methodName = joinPoint.getSignature().getName();
        Class declaringType = joinPoint.getSignature().getDeclaringType();
        Method[] methods = declaringType.getMethods();
        Object[] args = joinPoint.getArgs();

        AudioAction audioAction = this.getAudioActionByJoinPoint(methodName, methods, args);
        if (audioAction != null && audioAction.action() == Action.ADD) {
            log.info("add action");
        }
    }

    @Around(value = "audio()")
    public Object doAround(ProceedingJoinPoint pjp) {
        String methodName = pjp.getSignature().getName();
        Class declaringType = pjp.getSignature().getDeclaringType();
        Method[] methods = declaringType.getMethods();
        Object[] args = pjp.getArgs();

        AudioAction audioAction = this.getAudioActionByJoinPoint(methodName, methods, args);
        if (audioAction != null && audioAction.action() == Action.UPDATE) {
            log.info("update action");
        }
        return null;
    }

    private void addAudioLog(Object obj) {
        String jsonString = JacksonSerializer.toJSONString(obj);
        AudioLog audioLog = AudioLog.builder().logData(jsonString).createDatetime(LocalDate.now()).build();
        audioLogDao.addAudioLog(audioLog);
    }

    private AudioAction getAudioActionByJoinPoint(String methodName, Method[] methods, Object[] args) {
        Method tempMethod = Arrays.stream(methods)
                .filter(m -> m.getName().equals(methodName))
                .filter(m -> Objects.equals(m.getParameterTypes().length, args.length))
                .findFirst()
                .orElse(null);
        if (tempMethod != null) {
            Annotation[] annotations = tempMethod.getDeclaredAnnotations();
            AudioAction audioAction = (AudioAction) Arrays.stream(annotations).filter(a -> a instanceof AudioAction).findFirst().orElse(null);
            if (audioAction != null ) {
                return audioAction;
            }
        }
        return null;
    }
}