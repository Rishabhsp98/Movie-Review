package com.example.Moviereview.controller;

import com.example.Moviereview.dtos.response.movieResponse;
import com.example.Moviereview.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("/movie")
public class movieController {

    @Autowired
    MovieService movieService;

// add movie (give movieRequest) -done in admin Controller
// search movie by title /:title
    @GetMapping("/Id")
    public movieResponse getMovie(@PathVariable Long Id) {
        return movieService.getMovieById(Id);
    }

//    @GetMapping("/title/{title}")
//    public movieResponse getMovie(@PathVariable(name = "title") String title) {
//        return movieService.getMovieFromTitle(title);
//    }
// update movie by Id /:id
// delete movie by Id /:id
//search sorted movie by rating using /:genre
}
