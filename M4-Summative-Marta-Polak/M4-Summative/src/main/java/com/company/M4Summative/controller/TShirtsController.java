package com.company.M4Summative.controller;

import com.company.M4Summative.model.TShirts;
import com.company.M4Summative.repository.TShirtsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/tShirts")
@CrossOrigin(origins = {"https://localhost:3000"})
public class TShirtsController {
    @Autowired
    private TShirtsRepository tShirtsRepository;

    // all the standard gets

    @GetMapping()
    @ResponseStatus(HttpStatus.OK)
    public List<TShirts> gettinAllTShirts() {
        return tShirtsRepository.findAll();
    }

    @GetMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public TShirts getShirtsByID(@PathVariable("id") int id) {
        Optional<TShirts> tShirts = tShirtsRepository.findById(id);
        if (!tShirts.isPresent()) {
            return null;
        }
        return tShirts.get();
    }

    //    all the interface gets

    @GetMapping(value = "/color/{color}")
    @ResponseStatus(HttpStatus.OK)
    public List<TShirts> findByColor(@PathVariable String color) {
        return tShirtsRepository.findByColor(color);
    }

    @GetMapping(value = "/size/{size}")
    @ResponseStatus(HttpStatus.OK)
    public List<TShirts> findBySize(@PathVariable String size) {
        return tShirtsRepository.findBySize(size);
    }

//    all the post and puts

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public TShirts createShirts(@RequestBody TShirts tShirts) {
        tShirtsRepository.save(tShirts);
        return tShirts;
    }

    @PutMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void updateShirts(@RequestBody TShirts tShirts, @PathVariable int id) {
        if (tShirts.getId() == null) {
            tShirts.setId(id);
        }
        if (tShirts.getId() != id) {
            throw new IllegalArgumentException("Game ID must mach Parameter");
        }
        tShirtsRepository.save(tShirts);
    }

//    the deleted routes

    @DeleteMapping(value = "/{id}")
    public void deleteShirts(@PathVariable int id) {
        tShirtsRepository.deleteById(id);
    }
}