package com.company.M4Summative.controller;

import com.company.M4Summative.model.SalesTaxRate;
import com.company.M4Summative.repository.SalesTaxRateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.List;

@RestController
@RequestMapping(value = "/salesTaxRate")
@CrossOrigin(origins = {"https://localhost:3000"})
public class SalesTaxRateController {
    @Autowired
private SalesTaxRateRepository salesTaxRateRepository;
    @GetMapping(value = "/{state}")
    @ResponseStatus(HttpStatus.OK)
    public List<SalesTaxRate> getSalesTaxByState(@PathVariable("state") String state) {
        return salesTaxRateRepository.findSalesTaxByState(state);
    }}
