package com.jtcoding.audiolog.annotation;

import com.jtcoding.audiolog.enums.Action;

import java.lang.annotation.*;

/**
 * @author jason.tang
 * @create 2019-01-21 15:08
 * @description
 */
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface AudioAction {
    Action action() default Action.GET;
}
