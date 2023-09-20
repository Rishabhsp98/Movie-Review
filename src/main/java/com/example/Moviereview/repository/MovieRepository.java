package com.example.Moviereview.repository;

import com.example.Moviereview.entity.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface MovieRepository extends JpaRepository<Movie,Long> {


//    @Query("Select * from movie_table where title = :title")
//    Movie getMovieTitle(String title);
}
