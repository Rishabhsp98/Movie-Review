package com.example.Moviereview.dtos.response;

import lombok.*;

@Data
@Builder
public class ReviewResponse {

    private String movieTitle;
    private Double rating;
    private String review;

}
