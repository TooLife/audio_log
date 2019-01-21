package com.jtcoding.audiolog.service.impl;

import com.jtcoding.audiolog.dao.CompanyDao;
import com.jtcoding.audiolog.model.Company;
import com.jtcoding.audiolog.service.CompanyService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author jason.tang
 * @create 2019-01-16 10:25
 * @description
 */
@Slf4j
@Service("companyService")
public class CompanyServiceImpl implements CompanyService {

    @Autowired
    private CompanyDao companyDao;

    @Transactional
    @Override
    public int addCompany(Company company) {
        return companyDao.addCompany(company);
    }

    @Transactional
    @Override
    public int updateCompany(Company company) {
        return companyDao.updateCompany(company);
    }

    @Transactional
    @Override
    public int deleteCompany(int companyNum) {
        return companyDao.deleteCompany(companyNum);
    }

    @Override
    public Company getCompanyByNum(int companyNum) {
        return companyDao.getCompanyByNum(companyNum);
    }
}