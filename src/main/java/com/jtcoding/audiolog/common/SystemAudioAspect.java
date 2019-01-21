package com.jtcoding.audiolog.common;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;

/**
 * @author jason.tang
 * @create 2019-01-21 14:01
 * @description 系统监控
 */

@Slf4j
@Aspect
public class SystemAudioAspect {

    @Pointcut(value = "execution(public * com.jtcoding.audiolog.dao..*.*(..))")
    public void audio() {}

    @Before(value = "audio()")
    public void doBefore(JoinPoint joinPoint) {
        log.info("delete action");
    }

    @After(value = "audio()")
    public void doAround(JoinPoint joinPoint) {
        log.info("after, get action");
    }
}