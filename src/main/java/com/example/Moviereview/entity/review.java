package com.example.Moviereview.entity;

import com.example.Moviereview.dtos.response.ReviewResponse;
import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jdk.jfr.Timestamp;
import org.hibernate.annotations.CreationTimestamp;

import java.util.Date;

public class review {

   @Id
   @Column(name = "id",nullable = false)
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long Id;

   private String movieTitle;

   private Double rating;

   private String review;

   @CreationTimestamp
   private Date createdAt;

   public ReviewResponse toreviewResponse(){
       return ReviewResponse.builder()
               .movieTitle(this.movieTitle)
               .rating(this.rating)
               .review(this.review)
               .build();
   }

}
