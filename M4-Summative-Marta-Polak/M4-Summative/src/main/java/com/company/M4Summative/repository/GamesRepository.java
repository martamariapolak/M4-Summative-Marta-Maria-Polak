package com.company.M4Summative.repository;

import com.company.M4Summative.model.Games;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GamesRepository extends JpaRepository<Games, Integer> {
    List<Games> findByStudio(String studio);

    List<Games> findByESRBRating(int esrbrating);

    List<Games> findByTitle(String title);
}
