package com.jtcoding.audiolog.controller;

import com.jtcoding.audiolog.service.PlanService;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author jason.tang
 * @create 2019-01-18 17:21
 * @description
 */

@RestController
@RequestMapping("/plan")
public class PlanController {

    @Autowired
    private PlanService planService;

    @RequestMapping(value = "/{planNum}", method = RequestMethod.DELETE)
    public int deletePlanByNum(@PathVariable int planNum) {
        return planService.deletePlan(planNum);
    }
}