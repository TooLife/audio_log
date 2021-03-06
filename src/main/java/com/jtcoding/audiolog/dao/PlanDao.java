package com.jtcoding.audiolog.dao;

import com.jtcoding.audiolog.annotation.AudioAction;
import com.jtcoding.audiolog.common.enums.Action;
import com.jtcoding.audiolog.model.Plan;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author jason.tang
 * @create 2019-01-16 10:24
 * @description
 */
@Mapper
public interface PlanDao {

    @AudioAction(action = Action.ADD)
    int addPlan(Plan plan);

    @AudioAction(action = Action.UPDATE, targetTable = "plan")
    int updatePlan(Plan plan);

    @AudioAction(action = Action.DELETE, targetTable = "plan")
    int deletePlan(int planNum);

    Plan getPlanByNum(int planNum);
}
