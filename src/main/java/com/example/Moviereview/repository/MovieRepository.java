package com.example.Moviereview.repository;

import com.example.Moviereview.entity.Genre;
import com.example.Moviereview.entity.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MovieRepository extends JpaRepository<Movie,Long> {


    public Movie findByTitle(String title);

    List<Movie> findByGenre(Genre genre);
}
