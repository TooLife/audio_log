package com.jtcoding.audiolog.dao;


import com.jtcoding.audiolog.annotation.AudioAction;
import com.jtcoding.audiolog.enums.Action;
import com.jtcoding.audiolog.model.Company;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * @author jason.tang
 * @create 2019-01-16 10:24
 * @description
 */
@Mapper
public interface CompanyDao {

    @AudioAction(action = Action.GET)
    Company getCompanyByNum(@Param("companyNum") int companyNum);

    @AudioAction(action = Action.ADD)
    int addCompany(Company company);

    @AudioAction(action = Action.UPDATE)
    int updateCompany(Company company);

    @AudioAction(action = Action.DELETE)
    int deleteCompany(int companyNum);
}
