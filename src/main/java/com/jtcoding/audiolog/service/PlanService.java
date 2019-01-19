package com.jtcoding.audiolog.service;

import com.jtcoding.audiolog.model.Plan;

/**
 * @author jason.tang
 * @create 2019-01-16 10:25
 * @description
 */
public interface PlanService {
    int addPlan(Plan plan);

    int updatePlan(Plan plan);

    int deletePlan(int planNum);

    Plan getPlanByNum(int planNum);
}
