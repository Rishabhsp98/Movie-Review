package com.example.Moviereview.controller;

import com.example.Moviereview.dtos.request.movieRequestDTO;
import com.example.Moviereview.dtos.response.movieResponse;
import com.example.Moviereview.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/admin")
public class adminController {

    // add movie
    @Autowired
    AdminService adminService;


    @PostMapping("/movie/add")
    public ResponseEntity<Object> addMovie(@RequestBody movieRequestDTO movieRequestDTO){
        return adminService.addMovie(movieRequestDTO.toMovieEntity());
    }

}
