package com.company.M4Summative.repository;

import com.company.M4Summative.model.ProcessingFee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProcessingFeeRepository extends JpaRepository<ProcessingFee, String> {
  // List<ProcessingFee> findProcessingFee(String productType);
   ProcessingFee findByProductType(String productType);
}

