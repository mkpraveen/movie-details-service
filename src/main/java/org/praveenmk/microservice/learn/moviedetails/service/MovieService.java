package org.praveenmk.microservice.learn.moviedetails.service;

import org.praveenmk.microservice.learn.moviedetails.model.MovieDetails;

import java.util.List;

public interface MovieService {
    public List<MovieDetails> getAllMovieDetails();
    public MovieDetails getMovieDetailsById(long id);
    public MovieDetails saveMovieDetails(MovieDetails movie);
    public void removeMovieDetails(MovieDetails movie);
}
