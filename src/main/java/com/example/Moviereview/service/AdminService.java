package com.example.Moviereview.service;


import com.example.Moviereview.entity.Movie;
import com.example.Moviereview.repository.MovieRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminService {

    public static final Logger logger = LoggerFactory.getLogger(AdminService.class);
    @Autowired
    MovieRepository movieRepository;


    public Movie addMovie(Movie movie){
        logger.info("REST request to ADD movie to the DataBase!");
        return movieRepository.save(movie);
    }

}
