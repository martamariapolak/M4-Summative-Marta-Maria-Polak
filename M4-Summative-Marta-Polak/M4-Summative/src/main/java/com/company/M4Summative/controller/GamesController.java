package com.company.M4Summative.controller;

import com.company.M4Summative.model.Games;
import com.company.M4Summative.repository.GamesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = {"http://localhost:3000/"})
@RequestMapping(value = "/games")
public class GamesController {
    @Autowired
    private GamesRepository gamesRepository;

    // all the standard gets

    @GetMapping()
    @ResponseStatus(HttpStatus.OK)
    public List<Games> gettingAllGames() {
        return gamesRepository.findAll();
    }

    @GetMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Games getGameByID(@PathVariable("id") int id) {
        Optional<Games> game = gamesRepository.findById(id);
        if (!game.isPresent()) {
            return null;
        }
        return game.get();
    }

    //    all the interface gets

    @GetMapping(value = "/studio/{studio}")
    @ResponseStatus(HttpStatus.OK)
    public List<Games> getGameByStudio(@PathVariable String studio) {
        return gamesRepository.findByStudio(studio);
    }

    @GetMapping(value = "/esrbrating/{esrbrating}")
    @ResponseStatus(HttpStatus.OK)
    public List<Games> findGamesByESRBRating(@PathVariable int esrbrating) {
        return gamesRepository.findByESRBRating(esrbrating);
    }

    @GetMapping(value = "/title/{title}")
    @ResponseStatus(HttpStatus.OK)
    public List<Games> findGamesByTitle(@PathVariable String title) {
        return gamesRepository.findByTitle(title);
    }

//    all the post and puts

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Games createGame(@RequestBody Games game) {
        gamesRepository.save(game);
        return game;
    }

    @PutMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void updateGame(@RequestBody Games game, @PathVariable int id) {
        if (game.getId() == null) {
            game.setId(id);
        }
        if (game.getId() != id) {
            throw new IllegalArgumentException("Game ID must mach Parameter");
        }
        gamesRepository.save(game);
    }

//    the deleted routes

    @DeleteMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public String deleteGame(@PathVariable int id) {
        gamesRepository.deleteById(id);
    return "Game with the id "+id+" was deleted";
    }
}