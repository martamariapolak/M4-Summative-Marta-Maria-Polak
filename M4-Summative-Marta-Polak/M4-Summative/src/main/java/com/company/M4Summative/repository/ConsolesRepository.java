package com.company.M4Summative.repository;

import com.company.M4Summative.model.Consoles;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ConsolesRepository extends JpaRepository<Consoles, Integer> {
    List<Consoles> findByManufacturer(String manufacturer);
}
