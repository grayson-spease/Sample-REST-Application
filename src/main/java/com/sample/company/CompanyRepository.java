package com.sample.company;

import com.sample.company.CompanyDao;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CompanyRepository extends JpaRepository<CompanyDao, Integer> {
    Optional<CompanyDao> findByCompanyId(Integer companyId);
}
