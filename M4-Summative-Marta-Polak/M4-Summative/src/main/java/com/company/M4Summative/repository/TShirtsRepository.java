package com.company.M4Summative.repository;

import com.company.M4Summative.model.TShirts;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TShirtsRepository extends JpaRepository<TShirts, Integer> {
    List<TShirts> findByColor(String color);

    List<TShirts> findBySize(String size);
}
