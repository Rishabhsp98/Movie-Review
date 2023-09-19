package com.example.Moviereview.dtos.request;

import com.example.Moviereview.entity.Genre;
import com.example.Moviereview.entity.Movie;
import lombok.*;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class movieRequestDTO {

    private Genre genre;
    private String title;
    private Date releaseDate;

    public Movie toMovieEntity(){
        return Movie.builder().title(this.title)
                .genre(this.genre)
                .rating(0.0)
                .releaseDate(this.releaseDate)
                .build();
    }
}
