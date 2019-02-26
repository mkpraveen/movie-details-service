package org.praveenmk.microservice.learn.moviedetails.service;

import org.praveenmk.microservice.learn.moviedetails.model.MovieDetails;
import org.praveenmk.microservice.learn.moviedetails.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("movieServiceImpl")
public class MovieServiceImpl implements MovieService {

    @Autowired
    private MovieRepository movieRepository;

    @Override
    public List<MovieDetails> getAllMovieDetails() {
        return movieRepository.findAll();
    }

    @Override
    public MovieDetails getMovieDetailsById(long id) {
        return movieRepository.findById(new Long(id)).orElse(null);
    }

    @Override
    public MovieDetails saveMovieDetails(MovieDetails movie) {
        return movieRepository.save(movie);
    }

    @Override
    public void removeMovieDetails(MovieDetails movie) {
        movieRepository.delete(movie);

    }
}
