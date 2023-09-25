package com.example.Moviereview.controller;


import com.example.Moviereview.dtos.request.ReviewRequestDTO;
import com.example.Moviereview.dtos.response.ReviewResponse;
import com.example.Moviereview.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/review")
public class reviewController {


    @Autowired
    ReviewService reviewService;

    @PostMapping("/add")
    public void addReview(@RequestBody ReviewRequestDTO reviewRequest){
        reviewService.addReview(reviewRequest.toReview());
    }

    @GetMapping("/find")
    public ReviewResponse getReview(@RequestParam Long reviewId){
        return reviewService.getReviewById(reviewId);
    }
    //Add review (give reviewRequest)
    //Search review using Date range (sql query)

}
