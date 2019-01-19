package com.jtcoding.audiolog.dao;

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

    int addCompany(Company company);

    int updateCompany(Company company);

    int deleteCompany(int companyNum);
}
