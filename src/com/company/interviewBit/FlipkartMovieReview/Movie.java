package com.company.interviewBit.FlipkartMovieReview;

import java.util.ArrayList;
import java.util.List;

public class Movie {
    public String movieName;
    public Integer releasedyear;
    public List<String> genere;
    public Double averageReviewScore;
    public Integer reviewScore;

    public Movie(String movieName, Integer releasedyear, ArrayList<String> genere) {
        this.movieName = movieName;
        this.releasedyear = releasedyear;
        this.genere = genere;
        this.averageReviewScore = 0.00;
        this.reviewScore = 0;
    }

    public void setAverageReviewScore(Double averageReviewScore) {
        this.averageReviewScore = averageReviewScore;
    }

    public void setReviewScore(Integer reviewScore ) {
        this.reviewScore = reviewScore;
    }

    @Override
    public String toString() {
        String movie = this.movieName + "-" + "rating = " + this.reviewScore.toString() + " ," + "averageScore = " + this.averageReviewScore;
        return movie;
    }
}
