package com.example.Moviereview.controller;

import com.example.Moviereview.dtos.response.movieResponse;
import com.example.Moviereview.entity.Genre;
import com.example.Moviereview.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;


@RestController
@RequestMapping("/movie")
public class movieController {

    @Autowired
    MovieService movieService;


    @GetMapping("/id/{Id}")
    public ResponseEntity<Object> getMovie(@PathVariable(name = "Id",required = true) Long Id) {
        return movieService.getMovieById(Id);
    }

    @GetMapping("/title/{movie-title}")
    public ResponseEntity<Object> getMovie(@PathVariable(name = "movie-title",required = true) String title) {
        return movieService.getMovieFromTitle(title);
    }


    @GetMapping("/genre/{movie-genre}")
    public ResponseEntity<List<movieResponse>> getMovieByGenre(@PathVariable(name = "movie-genre") String genre){
        return movieService.getMovieFromGenre(genre);
    }
}
