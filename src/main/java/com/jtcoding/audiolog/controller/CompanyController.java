package com.jtcoding.audiolog.controller;

import com.jtcoding.audiolog.model.Company;
import com.jtcoding.audiolog.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @RequestMapping(value = "", method = RequestMethod.POST)
    public Company addCompany(@RequestBody Company company) {
        companyService.addCompany(company);
        return company;
    }

    @RequestMapping(value = "", method = RequestMethod.PUT)
    public Company modifyCompany(@RequestBody Company company) {
        int i = companyService.updateCompany(company);
        return company;
    }
}