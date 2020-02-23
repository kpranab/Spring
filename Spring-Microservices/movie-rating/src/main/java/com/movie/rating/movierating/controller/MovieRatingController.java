package com.movie.rating.movierating.controller;

import com.movie.rating.movierating.models.Rating;
import com.movie.rating.movierating.models.UserRating;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/rating")
public class MovieRatingController {

    @RequestMapping("/{movieId}")
    public Rating getRating(@PathVariable("movieId") String movieId) {
        return new Rating(movieId, 4);
    }

    @RequestMapping("/user/{userId}")
    public UserRating getUserRating(@PathVariable("userId") String userId) {
        List<Rating> ratings = Arrays.asList(new Rating("100", 4), new Rating("500", 5));
        UserRating userRating = new UserRating();
        userRating.initData(userId);
        return userRating;
    }
}
