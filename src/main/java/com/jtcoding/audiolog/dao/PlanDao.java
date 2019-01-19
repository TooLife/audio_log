package com.jtcoding.audiolog.dao;

import com.jtcoding.audiolog.model.Company;
import com.jtcoding.audiolog.model.Plan;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author jason.tang
 * @create 2019-01-16 10:24
 * @description
 */
@Mapper
public interface PlanDao {

    int addPlan(Plan plan);

    int updatePlan(Plan plan);

    int deletePlan(int planNum);

    Plan getPlanByNum(int planNum);
}
