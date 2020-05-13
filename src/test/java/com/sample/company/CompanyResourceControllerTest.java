package com.sample.company;

import org.apache.commons.lang.RandomStringUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Optional;
import java.util.Random;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

public class CompanyResourceControllerTest {
    private CompanyRepository companyRepository;
    private CompanyPresenter companyPresenter;
    private CompanyController underTest;

    @BeforeEach
    public void setup() {
        companyPresenter = mock(CompanyPresenter.class);
        companyRepository = mock(CompanyRepository.class);
        underTest = new CompanyController(companyPresenter, companyRepository);
    }

    @Nested
    class GetCompanyResource {
        private int companyId;
        private CompanyDao companyDao;
        private String companyName;

        @BeforeEach
        public void setup() {
            companyDao = mock(CompanyDao.class);
            companyName = RandomStringUtils.randomAlphabetic(10);
            companyId = getRandomInteger();
            when(companyDao.getName()).thenReturn(companyName);
            when(companyRepository.findByCompanyId(anyInt())).thenReturn(Optional.of(companyDao));
            CompanyResource mockCompanyResource = mock(CompanyResource.class);
            when(companyPresenter.getCompanyData(anyObject())).thenReturn(mockCompanyResource);
        }

        @Test
        public void getCompany_Called_CallsCompanyRepositoryWithExpectedCompanyId() {
            underTest.getCompanyData(companyId);

            verify(companyRepository).findByCompanyId(companyId);
        }


        @Test
        public void getSelectionCriteria_Called_ReturnsResultFromSelectionCriteriaConverter() {
            CompanyResource expectedCompanyResource = mock(CompanyResource.class);
            when(companyPresenter.getCompanyData(anyObject())).thenReturn(expectedCompanyResource);

            ResponseEntity<CompanyResource> company = underTest.getCompanyData(companyId);

            assertThat(company.getBody()).isEqualTo(expectedCompanyResource);
        }

        @Test
        public void getSelectionCriteria_SelectionCriteriaIsEmpty_Returns404() {
            CompanyResource expectedCompanyResource = mock(CompanyResource.class);
            when(expectedCompanyResource == null).thenReturn(true);
            when(companyPresenter.getCompanyData(anyObject())).thenReturn(expectedCompanyResource);

            ResponseEntity<CompanyResource> result = underTest.getCompanyData(companyId);

            assertThat(result.getStatusCode()).isEqualTo(HttpStatus.NOT_FOUND);
        }
    }

    private int getRandomInteger() {
        Random r = new Random();
        return r.nextInt((10 - 0) + 1) + 0;
    }
}
