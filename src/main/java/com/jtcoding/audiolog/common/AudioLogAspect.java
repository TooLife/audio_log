package com.jtcoding.audiolog.common;

import com.jtcoding.audiolog.dao.AudioLogDao;
import com.jtcoding.audiolog.dao.CompanyDao;
import com.jtcoding.audiolog.dao.PlanDao;
import com.jtcoding.audiolog.model.AudioLog;
import com.jtcoding.audiolog.model.Company;
import com.jtcoding.audiolog.model.Plan;
import com.jtcoding.audiolog.service.CompanyService;
import com.jtcoding.audiolog.service.PlanService;
import com.jtcoding.audiolog.service.impl.CompanyServiceImpl;
import jdk.nashorn.internal.ir.annotations.Ignore;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.Objects;

/**
 * Web层的日志切面类
 * 
 * @author Rick
 * @created Jun 25, 2018
 * @version 1.0
 */
@Slf4j
@Aspect
@Component
public class AudioLogAspect {

//    @Lazy
//    @Autowired
//    private CompanyService companyService;
//
//    @Autowired
//    private PlanService planService;
//
//    @Lazy
//    @Autowired
//    private AudioLogDao audioLogDao;
//
//	@Pointcut("execution(public * com.jtcoding.audiolog.controller..*.get*(..))  || execution(public * com.jtcoding.audiolog.service..*.get*(..))") // 所有子目和所有参数
//	public void log() {
//	}
//
//	@Pointcut("execution(public * com.jtcoding.audiolog.dao..*.delete*(..))")
//	public void deleteLog() {
//
//	}
//
//	@Before("deleteLog()")
//	public void doBefore(JoinPoint joinPoint) throws Exception {
//        String methodName = joinPoint.getSignature().getName();
//        log.info(methodName);
//        Class declaringType = joinPoint.getSignature().getDeclaringType();
//
//        Object[] args = joinPoint.getArgs();
//        Method[] methods = declaringType.getMethods();
//        Method method = Arrays.stream(methods)
//                .filter(m -> Objects.equals(m.getName(), methodName))
//                .filter(m -> Objects.equals(m.getParameterTypes().length, args.length))
//                .findFirst()
//                .orElse(null);
//        if (method != null) {
//            Object obj = null;
//            switch (declaringType.getSimpleName()) {
//                case "CompanyDao":
//                    int companyNum = (int) args[0];
//                    obj = companyService.getCompanyByNum(companyNum);
//                    break;
//                case "PlanDao":
//                    int planNum = (int) args[0];
//                    obj = planService.getPlanByNum(planNum);
//                    break;
//            }
//            if (obj != null) {
//                this.addAudioLog(obj);
//            }
//        }
//	}
//
//	private void addAudioLog(Object obj) {
//        String jsonString = JacksonSerializer.toJSONString(obj);
//        AudioLog audioLog = AudioLog.builder().logData(jsonString).createDatetime(LocalDate.now()).build();
//        audioLogDao.addAudioLog(audioLog);
//    }
//
//	@AfterReturning(returning = "result", pointcut = "log()")
//	public void doAfterReturning(Object result) throws Exception {
//		System.out.println("after returning");
//	}
//
//	@Around("log()")
//	public Object doAround(ProceedingJoinPoint joinPoint) throws Throwable {
//		long startTime = System.currentTimeMillis();
//		Object result = null;
//		try {
//			result = joinPoint.proceed();
//			long endTime = System.currentTimeMillis();
//			String tragetClassName = joinPoint.getSignature().getDeclaringTypeName();
//			String methodName = joinPoint.getSignature().getName();
//			log.info("CLASS_METHOD [{}.{}] cost : {} ms.", tragetClassName, methodName, endTime - startTime);
//		} catch (Throwable e) {
//			long endTime = System.currentTimeMillis();
//			log.info("{} Use time : {} ms with exception : ", joinPoint, endTime - startTime, e.getMessage());
//			throw e;
//		}
//		return result;
//	}
//
//	@AfterThrowing(throwing = "ex", pointcut = "execution(public * com.jtcoding.audiolog.controller..*.*(..))")
//	public void doAfterThrowing(Exception ex) {
//		log.error("[EXCEPTION] : {}", ex);
//	}
}
