package com.jtcoding.audiolog.controller;

import com.jtcoding.audiolog.model.Company;
import com.jtcoding.audiolog.service.CompanyService;
import org.aspectj.lang.annotation.Around;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author jason.tang
 * @create 2019-01-18 16:00
 * @description
 */

@RestController
@RequestMapping("/companies")
public class CompanyController {

    @Autowired
    private CompanyService companyService;

    @RequestMapping(value = "/{companyNum}", method = RequestMethod.GET)
    public Company getCompanyByNum(@PathVariable int companyNum) {
        return companyService.getCompanyByNum(companyNum);
    }

    @RequestMapping(value = "/{companyNum}", method = RequestMethod.DELETE)
    public int deleteCompanyByNum(@PathVariable int companyNum) {
        return companyService.deleteCompany(companyNum);
    }
}