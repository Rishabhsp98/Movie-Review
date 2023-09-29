package com.example.Moviereview.service;


import com.example.Moviereview.dtos.response.movieResponse;
import com.example.Moviereview.entity.Genre;
import com.example.Moviereview.entity.Movie;
import com.example.Moviereview.repository.MovieRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class MovieService {


    public static final Logger logger = LoggerFactory.getLogger(MovieService.class);

    @Autowired
    MovieRepository movieRepository;


    public static boolean isGenreValid(String genre){
        try{
            Genre.valueOf(genre);
            return true;
        }catch (IllegalArgumentException e)
        {
            return false;
        }
    }

    public ResponseEntity<Object> getMovieFromTitle(String title) {
        logger.info("REST Request to Get Movie by title");
        try{
            Movie movie = movieRepository.findByTitle(title);
            return ResponseEntity.ok().body(movie.toMovieResponse());
        }
        catch (Exception e) {
            e.printStackTrace();
            logger.error("No Movie Exist as a Title {} given",title);
        }
        return ResponseEntity.badRequest().body("No Movie Exist as a Title : " + title);
    }

    public ResponseEntity<Object> getMovieById(Long id) {
        logger.info("REST request to get Movie by Id");
        try{
            Optional<Movie> movie = movieRepository.findById(id);
            return ResponseEntity.ok().body(movie.get().toMovieResponse());
        }
        catch (Exception e){
            e.printStackTrace();
            logger.error("No such Movie Exist by Id {}",id);
        }
        return ResponseEntity.badRequest().body("No Such Movie exist of Id : " + id);
    }

    public ResponseEntity<List<movieResponse>> getMovieFromGenre(String genre) {
        logger.info("REST request to get Movie by genre : {} ",genre);

        // check first if genre exist in enum
        if(!isGenreValid(genre))
        {
            logger.info("No Genre Exist of type {}",genre);
            return ResponseEntity.badRequest().body(new ArrayList<>());
        }

        List<Movie> movies = movieRepository.findByGenre(Genre.valueOf(genre));
        if(movies.size() == 0)
            return ResponseEntity.ok().body(new ArrayList<>());
        List<movieResponse> ans = new ArrayList<>();

        for (Movie movie : movies) {
            ans.add(movie.toMovieResponse());
        }
        return ResponseEntity.ok().body(ans);
    }
}
