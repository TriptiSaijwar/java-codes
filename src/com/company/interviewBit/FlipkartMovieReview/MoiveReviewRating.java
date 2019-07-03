package com.company.interviewBit.FlipkartMovieReview;

import java.util.*;

public class MoiveReviewRating {

    List<User> viewer;
    List<User> critics;
    List<Movie> movieList;
    Map<Movie,ArrayList<Integer>> movieReviewMap;
    Map<User,ArrayList<Movie>> userMovieMap;
    Map<Movie,ArrayList<Integer>> moviesAsCritic;

    public MoiveReviewRating() {
        movieList = new ArrayList<>();
        viewer = new ArrayList<>();
        critics = new ArrayList<>();
        movieReviewMap = new HashMap<>();
        userMovieMap = new HashMap<>();
        moviesAsCritic = new HashMap<>();
    }

    public void addMovie(Movie movie) {
        movieList.add(movie);
    }

    public void addUser(User user) {
        viewer.add(user);
    }

    public void addReview(User user, Movie movie, int rating) {
        if (movie.releasedyear <= 2018) {
            if (checkIfUserCanRate(user,movie)) {
                if (movieReviewMap.containsKey(movie)) {
                    ArrayList<Integer> ratings = movieReviewMap.get(movie);
                    if (viewer.contains(user)) {
                        ratings.add(rating);
                    }
                    else {
                        ratings.add(rating);
                        ratings.add(rating);
                        addToMovieAsCritic(movie,rating);
                    }
                    movieReviewMap.put(movie, ratings);
                } else {
//                    ArrayList<Integer> ratingMovie = new ArrayList<>();
//                    movieReviewMap.put(movie,ratingMovie);
                    ArrayList<Integer> ratings = new ArrayList<>();
                    if (viewer.contains(user)) {
                        ratings.add(rating);
                    }
                    else {
                        ratings.add(rating);
                        ratings.add(rating);
                        addToMovieAsCritic(movie,rating);
                    }
                    movieReviewMap.put(movie, ratings);
                }
            }
            updateMovieRevieScore(movie);
        }
        else {
            System.out.println("Movie yet to be released");
        }
    }

    private void addToMovieAsCritic(Movie movie, int rating) {
        if (moviesAsCritic.containsKey(movie)) {
            moviesAsCritic.get(movie).add(rating);
        }
        else {
            ArrayList<Integer> list = new ArrayList<>();
            list.add(rating);
            moviesAsCritic.put(movie,list);
        }
    }

    private void updateMovieRevieScore(Movie movie) {
        ArrayList<Integer> ratings = movieReviewMap.get(movie);
        int sum = 0;
        for (int i = 0; i < ratings.size();i++) {
            sum = sum + ratings.get(i);
        }
        movie.setReviewScore(sum);
        double score = (double) sum/ratings.size();
        movie.setAverageReviewScore(score);
    }

    private Boolean checkIfUserCanRate(User user, Movie movie) {
        if (userMovieMap.containsKey(user)) {
            ArrayList<Movie> moviesRatedByUser  = userMovieMap.get(user);
            if (moviesRatedByUser.contains(movie)) {
                System.out.println("Exception multiple reviews not allowed");
                return false;
            }
            else {
                moviesRatedByUser.add(movie);
                userMovieMap.put(user, moviesRatedByUser);
                checkIfUserCanBePromotedToCritic(user);
            }
        }
        else {
            ArrayList<Movie> moviesRatedByUser = new ArrayList<>();
            moviesRatedByUser.add(movie);
            userMovieMap.put(user, moviesRatedByUser);
        }
        return true;
    }

    private void checkIfUserCanBePromotedToCritic(User user) {
        if (userMovieMap.containsKey(user)) {
            ArrayList<Movie> moviesRatedByUser  = userMovieMap.get(user);
            if (moviesRatedByUser.size() > 3 && !critics.contains(user)) {
                viewer.remove(user);
                critics.add(user);
                System.out.println(user.userName + "has published 3 reviews, he is promoted to critic now");
            }
        }
    }

    public Movie getTopMovieByYear(int year, boolean ratedByCritic) {
        movieList.sort(new Comparator<Movie>() {
            @Override
            public int compare(Movie o1, Movie o2) {
                return o2.reviewScore.compareTo(o1.reviewScore);
            }
        });
        if (!ratedByCritic) {
            for (int i = 0; i < movieList.size();i++) {
                if (movieList.get(i).releasedyear.equals(year) && movieList.get(i).reviewScore > 0) {
                    return movieList.get(i);
                }
            }
        }
        else {
            for (int i = 0; i < movieList.size();i++) {
                if (movieList.get(i).releasedyear.equals(year) && ratedByCriticUser(movieList.get(i)) && movieList.get(i).reviewScore > 0 && moviesAsCritic.containsKey(movieList.get(i))) {
                    return movieList.get(i);
                }
            }
        }
        System.out.print("No such Movie till now");
        return null;
    }

    public boolean ratedByCriticUser(Movie movie) {
        for (int i = 0; i < critics.size(); i++) {
            if (userMovieMap.containsKey(critics.get(i))) {
                ArrayList<Movie> moviesRatedByUser = userMovieMap.get(critics.get(i));
                if (moviesRatedByUser.contains(movie)) {
                    return true;
                }
            }
        }
        return false;
    }

    public Movie getTopMovieByGenre(String genre) {
        movieList.sort(new Comparator<Movie>() {
            @Override
            public int compare(Movie o1, Movie o2) {
                return o2.reviewScore.compareTo(o1.reviewScore);
            }
        });
        for (int i = 0; i < movieList.size();i++) {
            List<String> gen = movieList.get(i).genere;
            if (gen.contains(genre) && movieList.get(i).reviewScore > 0) {
                return movieList.get(i);
            }
        }
        System.out.print("No such Movie till now");
        return null;
    }

    public Movie getTopMovieByAverageReviewScore(int year) {
        if (movieList != null) {
            movieList.sort(new Comparator<Movie>() {
                @Override
                public int compare(Movie o1, Movie o2) {
                    return o1.averageReviewScore.compareTo(o2.averageReviewScore);
                }
            });
            for (int i = 0; i < movieList.size();i++) {
                if (movieList.get(i).releasedyear.equals(year) && movieList.get(i).reviewScore > 0 ) {
                    return movieList.get(i);
                }
            }
            return null;
        }
        System.out.print("Movie List Empty");
        return null;
    }

}
