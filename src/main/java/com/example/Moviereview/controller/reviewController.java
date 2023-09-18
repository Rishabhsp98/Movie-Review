package com.example.Moviereview.controller;


import com.example.Moviereview.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/review")
public class reviewController {


    @Autowired
    ReviewService reviewService;
    //Add review (give reviewRequest)
    //Search review using Date range (sql query)

}
