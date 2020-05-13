package com.sample.company;

import org.springframework.stereotype.Component;

@Component
public class CompanyPresenter {
    public CompanyResource getCompanyData(CompanyDao companyDao) {
        CompanyResource companyResource = new CompanyResource();
        companyResource.setCompanyCity(companyDao.getCity());
        companyResource.setCompanyAddress(companyDao.getAddr());
        companyResource.setCompanyName(companyDao.getName());
        companyResource.setCompanyState(companyDao.getState());
        companyResource.setCompanyZip(companyDao.getZip());
        return companyResource;
    }
}
