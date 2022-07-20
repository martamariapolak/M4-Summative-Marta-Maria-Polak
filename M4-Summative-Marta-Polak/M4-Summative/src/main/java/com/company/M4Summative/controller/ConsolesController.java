package com.company.M4Summative.controller;


import com.company.M4Summative.model.Consoles;
import com.company.M4Summative.repository.ConsolesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@CrossOrigin(origins = {"http://localhost:3000/"})
@RequestMapping(value = "/consoles")
public class ConsolesController {
    @Autowired
    private ConsolesRepository consolesRepository;

//    // all the standard gets

    @GetMapping()
    @ResponseStatus(HttpStatus.OK)
    public List<Consoles> getAllConsoles() {
        return consolesRepository.findAll();
    }

    @GetMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Consoles getConsoleByID(@PathVariable("id") int id) {
        Optional<Consoles> game = consolesRepository.findById(id);
        if (!game.isPresent()) {
            return null;
        }
        return game.get();
    }

    //    all the interface gets

    @GetMapping(value = "/manufacturer/{manufacturer}")
    @ResponseStatus(HttpStatus.OK)
    public List<Consoles> findConsoleByManufacturer(@PathVariable String manufacturer) {
        return consolesRepository.findByManufacturer(manufacturer);
    }

//    all the post and puts

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Consoles createConsoles(@RequestBody Consoles consoles) {
        consolesRepository.save(consoles);
        return consoles;
    }

    @PutMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void updateConsoles(@RequestBody Consoles consoles, @PathVariable int id) {
        if (consoles.getId() == null) {
            consoles.setId(id);
        }
        if (consoles.getId() != id) {
            throw new IllegalArgumentException("Game ID must mach Parameter");
        }
        consolesRepository.save(consoles);
    }

//    the deleted routes

    @DeleteMapping(value = "/{id}")
    public void deleteConsoles(@PathVariable int id) {
        consolesRepository.deleteById(id);
    }
}