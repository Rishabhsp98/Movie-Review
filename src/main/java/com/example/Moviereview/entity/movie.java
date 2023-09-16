package com.example.Moviereview.entity;


import com.example.Moviereview.dtos.response.movieResponse;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Locale;

@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class movie implements Serializable {

    @Id
    @Column(name = "id",nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    private String title;

    @Enumerated(EnumType.STRING)
    private genre genre;

    private Double rating;

    @Temporal(TemporalType.DATE)
    @Column(name = "releaseDate")
    @DateTimeFormat(pattern = "dd-mm-yyyy")
    private Date releaseDate;

    @OneToMany(mappedBy = "movie")
    private List<review> reviews;

    public movieResponse toMovieResponse(){
        return movieResponse.builder()
                .genre(genre)
                .title(this.title)
                .rating(this.rating)
                .releaseDate(String.valueOf(this.releaseDate))
                .build();
    }

}
