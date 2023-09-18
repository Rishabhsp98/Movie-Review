package com.example.Moviereview.entity;


import com.example.Moviereview.dtos.response.movieResponse;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name="movie_table")
@ToString
public class Movie implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    @Enumerated(EnumType.STRING)
    private genre genre;

    private Double rating; // single entity , average rating of all reviews

    @Temporal(TemporalType.DATE)
    @Column(name = "releaseDate")
    @DateTimeFormat(pattern = "dd-mm-yyyy")
    private Date releaseDate;

    @OneToMany(mappedBy = "movie")
    private List<Review> reviews;

    public movieResponse toMovieResponse(){
        return movieResponse.builder()
                .genre(genre)
                .title(this.title)
                .rating(this.rating)
                .releaseDate(String.valueOf(this.releaseDate))
                .build();
    }

}
