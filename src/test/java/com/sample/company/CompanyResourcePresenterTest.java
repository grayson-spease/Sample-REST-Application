package com.sample.company;

import org.apache.commons.lang.RandomStringUtils;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

import java.util.Random;

import static org.assertj.core.api.Assertions.assertThat;

public class CompanyResourcePresenterTest {
    private CompanyPresenter underTest;

    @BeforeEach
    public void setup() {
        underTest = new CompanyPresenter();
    }

    @Test
    public void toSelectionCriteria_CalledWithPopulatedYearLists_PopulatesSelectionCriteriaWithExpectedYears() {
        CompanyDao companyDao = new CompanyDao();
        companyDao.setAddr(RandomStringUtils.randomAlphabetic(10));
        companyDao.setCity(RandomStringUtils.randomAlphabetic(10));
        companyDao.setCompanyId(getRandomInteger());
        companyDao.setName(RandomStringUtils.randomAlphabetic(10));
        companyDao.setState(RandomStringUtils.randomAlphabetic(10));
        companyDao.setZip(getRandomInteger());

        CompanyResource result = underTest.getCompanyData(companyDao);

        assertThat(result.getCompanyName()).isEqualTo(companyDao.getName());
        assertThat(result.getCompanyAddress()).isEqualTo(companyDao.getAddr());
        assertThat(result.getCompanyCity()).isEqualTo(companyDao.getCity());
        assertThat(result.getCompanyState()).isEqualTo(companyDao.getState());
        assertThat(result.getCompanyZip()).isEqualTo(companyDao.getZip());
        assertThat(result.getCompanyZip()).isEqualTo(companyDao.getZip());
    }

    private int getRandomInteger() {
        Random r = new Random();
        return r.nextInt((10 - 0) + 1) + 0;
    }
}
