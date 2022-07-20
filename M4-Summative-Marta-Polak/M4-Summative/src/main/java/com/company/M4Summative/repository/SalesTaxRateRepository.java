package com.company.M4Summative.repository;

import com.company.M4Summative.model.SalesTaxRate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SalesTaxRateRepository extends JpaRepository<SalesTaxRate, Integer> {
    List<SalesTaxRate> findSalesTaxByState(String state);
}
