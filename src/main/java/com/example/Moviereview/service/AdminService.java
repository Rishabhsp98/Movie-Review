package com.example.Moviereview.service;


import com.example.Moviereview.entity.Movie;
import com.example.Moviereview.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminService {

    @Autowired
    MovieRepository movieRepository;


    public Movie addMovie(Movie movie){
        return movieRepository.save(movie);
    }

}
