package com.jtcoding.audiolog.service.impl;

import com.jtcoding.audiolog.dao.PlanDao;
import com.jtcoding.audiolog.model.Plan;
import com.jtcoding.audiolog.service.PlanService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author jason.tang
 * @create 2019-01-16 10:25
 * @description
 */
@Slf4j
@Service("planService")
public class PlanServiceImpl implements PlanService {

    @Autowired
    private PlanDao planDao;

    @Transactional
    @Override
    public int addPlan(Plan plan) {
        return planDao.addPlan(plan);
    }

    @Transactional
    @Override
    public int updatePlan(Plan plan) {
        return planDao.updatePlan(plan);
    }

    @Transactional
    @Override
    public int deletePlan(int planNum) {
        return planDao.deletePlan(planNum);
    }

    @Override
    public Plan getPlanByNum(int planNum) {
        return planDao.getPlanByNum(planNum);
    }
}