package com.example.Moviereview.entity;

import com.example.Moviereview.dtos.response.ReviewResponse;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.io.Serializable;
import java.util.Date;


@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name="review_table")
public class Review implements Serializable {

   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;

   @ManyToOne
   @JoinColumn(name = "movie_id",nullable = false)
   @JsonIgnore
   private Movie movie;

   private String movieTitle;

   private Double rating;

   private String movieReview;

   @CreationTimestamp
   private Date createdAt;

   @UpdateTimestamp
   private Date updatedOn;

   public static ReviewResponse toReviewResponse(Review review){
      return ReviewResponse.builder().review(review.movieReview).rating(review.rating).build();
   }

}
