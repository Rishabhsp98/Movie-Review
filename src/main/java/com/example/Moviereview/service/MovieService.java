package com.example.Moviereview.service;


import com.example.Moviereview.dtos.response.movieResponse;
import com.example.Moviereview.entity.Movie;
import com.example.Moviereview.repository.MovieRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieService {


    public static final Logger logger = LoggerFactory.getLogger(MovieService.class);

    @Autowired
    MovieRepository movieRepository;


//    public movieResponse getMovieFromTitle(String title) {
//        logger.info("REST Request to Get Movie by title");
//        Movie movie = movieRepository.getMovieTitle(title);
//        return movie.toMovieResponse();
//    }

    public movieResponse getMovieById(Long id) {
        logger.info("REST request to get Movie by Id");
        return movieRepository.findById(id).get().toMovieResponse();
    }

}
