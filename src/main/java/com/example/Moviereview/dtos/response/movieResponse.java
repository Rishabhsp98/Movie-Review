package com.example.Moviereview.dtos.response;

import com.example.Moviereview.entity.genre;
import lombok.*;

import java.util.List;

@Data
@Builder
public class movieResponse {

    private String title;
    private genre genre;
    private Double rating;
    private String releaseDate;
    private List<ReviewResponse> reviews;


}
