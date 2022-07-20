package com.company.M4Summative.controller;

import com.company.M4Summative.model.ProcessingFee;
import com.company.M4Summative.repository.ProcessingFeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/processingFee")
@CrossOrigin(origins = {"https://localhost:3000"})
public class ProcessingFeeController {
    @Autowired
    private ProcessingFeeRepository processingFeeRepository;
    @GetMapping("/productType")
    @ResponseStatus(HttpStatus.OK)
    public ProcessingFee getProcessingFee(@PathVariable("productType") String productType) {
        return processingFeeRepository.findById(productType).get();
    }
}
