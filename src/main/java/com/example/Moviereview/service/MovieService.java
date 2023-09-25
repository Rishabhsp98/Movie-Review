package com.example.Moviereview.service;


import com.example.Moviereview.dtos.response.movieResponse;
import com.example.Moviereview.entity.Genre;
import com.example.Moviereview.entity.Movie;
import com.example.Moviereview.repository.MovieRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class MovieService {


    public static final Logger logger = LoggerFactory.getLogger(MovieService.class);

    @Autowired
    MovieRepository movieRepository;


    public movieResponse getMovieFromTitle(String title) {
        logger.info("REST Request to Get Movie by title");
        try{
            Movie movie = movieRepository.findByTitle(title);
            return movie.toMovieResponse();
        }
        catch (Exception e) {
            logger.error("No Movie Exist as a Title {} given",title);
        }
        return null;
    }

    public movieResponse getMovieById(Long id) {
        logger.info("REST request to get Movie by Id");
        try{
            Optional<Movie> movie = movieRepository.findById(id);
            return movie.get().toMovieResponse();
        }
        catch (Exception e){
            logger.error("No such Movie Exist by Id {}",id);
        }
        return null;
    }

    public List<movieResponse> getMovieFromGenre(Genre genre) {
        logger.info("REST request to get Movie by genre!");

        List<Movie> movies = movieRepository.findByGenre(genre);
        if(movies.size() == 0)
            return new ArrayList<>();
        List<movieResponse> ans = new ArrayList<>();

        for (Movie movie : movies) {
            ans.add(movie.toMovieResponse());
        }
        return ans;
    }
}
