package com.company.M4Summative.repository;

import com.company.M4Summative.model.TShirts;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import java.math.BigDecimal;
import java.util.List;
import static org.junit.Assert.*;


@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class TShirtsRepositoryTest {
    @Autowired
    TShirtsRepository tShirtsRepository;

    @Before
    public void setUp() throws Exception {
tShirtsRepository.deleteAll();


        tShirtsRepository.save(new TShirts( "XL", "black", "black T", BigDecimal.valueOf(1000.00), 1));
        tShirtsRepository.save(new TShirts( "M", "grey", "Grey T", BigDecimal.valueOf(1000.00), 1));
        tShirtsRepository.save(new TShirts( "L", "black", "Black T", BigDecimal.valueOf(1000.00), 1));
        tShirtsRepository.save(new TShirts( "XL", "green", "Green T", BigDecimal.valueOf(1000.00), 1));


    }

    @Test
    public void findAllShirtsByColor() {
        List<TShirts> blackTList = tShirtsRepository.findByColor("black");
        assertEquals(2, blackTList.size());
    }

    @Test
    public void findAllShirtsBySize() {
        List<TShirts> XLTList = tShirtsRepository.findBySize("XL");
        assertEquals(2, XLTList.size());

    }
}