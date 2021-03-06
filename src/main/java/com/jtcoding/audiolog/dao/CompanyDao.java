package com.jtcoding.audiolog.dao;


import com.jtcoding.audiolog.annotation.AudioAction;
import com.jtcoding.audiolog.common.enums.Action;
import com.jtcoding.audiolog.model.Company;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author jason.tang
 * @create 2019-01-16 10:24
 * @description
 */

@Mapper
public interface CompanyDao {

    Company getCompanyByNum(int companyNum);

    @AudioAction(action = Action.ADD)
    int addCompany(Company company);

    @AudioAction(action = Action.UPDATE, targetTable = "company")
    int updateCompany(Company company);

    @AudioAction(action = Action.DELETE, targetTable = "company")
    int deleteCompany(int companyNum);
}
