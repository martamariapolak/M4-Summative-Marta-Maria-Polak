
package com.company.M4Summative.repository;

import com.company.M4Summative.model.Consoles;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class ConsolesRepositoryTest {

    @Autowired
    ConsolesRepository consolesRepository;

    @Before
    public void setUp() throws Exception {
        consolesRepository.deleteAll();

        consolesRepository.save(
                new Consoles(1, "PS5", "Sony", "124g", "NewestOne",  BigDecimal.valueOf(999.99), 1));
        consolesRepository.save(
                new Consoles(2, "XBox-Series X", "Microsoft", "128g", "Garbage",  BigDecimal.valueOf(0.99), 100000));
        consolesRepository.save(
                new Consoles(3, "PS4", "Sony", "64g", "OldOne",  BigDecimal.valueOf(499.99), 10));
    }
    @Test
    public void findByManufacturer() {
        List<Consoles> sonyConsoles = consolesRepository.findByManufacturer("Sony");
        assertEquals(2, sonyConsoles.size());

        List<Consoles> microsoftConsoles = consolesRepository.findByManufacturer("Microsoft");
        assertEquals(1, microsoftConsoles.size());
    }

}