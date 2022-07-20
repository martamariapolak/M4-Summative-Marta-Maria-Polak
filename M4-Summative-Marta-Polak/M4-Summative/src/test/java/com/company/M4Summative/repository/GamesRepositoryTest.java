package com.company.M4Summative.repository;

import com.company.M4Summative.model.Games;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.Assert.*;
import static org.junit.Assert.*;
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class GamesRepositoryTest {
    @Autowired
    GamesRepository gamesRepository;
    @Before
    public void setUp() throws Exception {
        gamesRepository.deleteAll();

        gamesRepository.save(new Games(1, "FIFA 22", 5, "Play soccer online", BigDecimal.valueOf(70.00), "EASports", 4));
        gamesRepository.save(new Games(2, "NBA 2K Playgrounds", 4, "Play Street basketball", BigDecimal.valueOf(4.00), "2K", 40));
        gamesRepository.save(new Games(3, "MLB The Show 22", 3, "Play baseball online", BigDecimal.valueOf(1.00), "EASports", 4));
        gamesRepository.save(new Games(4, "Everybody Golf", 3, "Play Golf online", BigDecimal.valueOf(10.00), "GOLFS", 15));

    }

    @Test
    public void findGamesByStudio() {
        List<Games> EASportsGames = gamesRepository.findByStudio("EASports");
        assertEquals(EASportsGames.size(), 2);

    }

    @Test
    public void findGamesByEsrbRating() {
        List<Games> findByRating = gamesRepository.findByESRBRating(3);
        assertEquals(findByRating.size(), 2);
    }

    @Test
    public void findGamesByTitle() {
        List<Games> findByTitle = gamesRepository.findByTitle("FIFA 22");
        assertEquals(findByTitle.size(), 1);
    }
}