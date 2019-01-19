package com.jtcoding.audiolog.service;

import com.jtcoding.audiolog.model.Company;

/**
 * @author jason.tang
 * @create 2019-01-16 10:25
 * @description
 */
public interface CompanyService {
    int addCompany(Company company);

    int updateCompany(Company company);

    int deleteCompany(int companyNum);

    Company getCompanyByNum(int companyNum);
}
