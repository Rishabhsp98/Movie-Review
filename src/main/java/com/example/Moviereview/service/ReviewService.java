package com.example.Moviereview.service;


import com.example.Moviereview.dtos.response.ReviewResponse;
import com.example.Moviereview.entity.Movie;
import com.example.Moviereview.entity.Review;
import com.example.Moviereview.repository.MovieRepository;
import com.example.Moviereview.repository.ReviewRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ReviewService {

    public static final Logger logger = LoggerFactory.getLogger(ReviewService.class);
    @Autowired
    private ReviewRepository reviewRepository;

    @Autowired
    private MovieRepository movieRepository;
    public ReviewResponse getReviewById(Long reviewId) {
        logger.info("REST request for retrieving Review using Id");
        Optional<Review> review = reviewRepository.findById(reviewId);
        return review.map(Review::toReviewResponse).orElse(null);
    }

    public void addReview(Review review) {
        Movie movie=movieRepository.findById(review.getMovie().getId()).orElse(null);
        reviewRepository.save(review);
        //need to optimized
        //exception handling.
        if(movie!=null) {
            Double average = reviewRepository.getReviewAverage(movie.getId());
            movie.setRating(average);
            movieRepository.save(movie);
        }
    }

}
