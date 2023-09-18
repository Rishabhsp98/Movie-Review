package com.example.Moviereview.controller;

import com.example.Moviereview.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping("/movie")
public class movieController {

    @Autowired
    MovieService movieService;

// add movie (give movieRequest)
// search movie by title /:title
// update movie by Id /:id
// delete movie by Id /:id
//search sorted movie by rating using /:genre
}
