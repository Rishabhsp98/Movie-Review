package com.example.Moviereview.controller;

import com.example.Moviereview.dtos.response.movieResponse;
import com.example.Moviereview.entity.Genre;
import com.example.Moviereview.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/movie")
public class movieController {

    @Autowired
    MovieService movieService;

// add movie (give movieRequest) -done in admin Controller
// search movie by title /:title
    @GetMapping("/id/{Id}")
    public movieResponse getMovie(@PathVariable Long Id) {
        return movieService.getMovieById(Id);
    }

    @GetMapping("/title")
    public movieResponse getMovie(@RequestParam String title) {
        return movieService.getMovieFromTitle(title);
    }

    public List<movieResponse> getMovieByGenre(@RequestParam Genre genre){
        return movieService.getMovieFromGenre(genre);
    }
// update movie by Id /:id
// delete movie by Id /:id
//search sorted movie by rating using /:genre
}
