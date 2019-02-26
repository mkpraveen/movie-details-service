package org.praveenmk.microservice.learn.moviedetails.resources;

import org.praveenmk.microservice.learn.moviedetails.exception.MovieServiceException;
import org.praveenmk.microservice.learn.moviedetails.model.MovieDetails;
import org.praveenmk.microservice.learn.moviedetails.model.Response;
import org.praveenmk.microservice.learn.moviedetails.service.MovieService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MovieDetailsController {

    private static final Logger logger = LoggerFactory.getLogger(MovieDetailsController.class);

    @Autowired
    private MovieService movieServiceImpl;

    @RequestMapping(value = "/jpamovies", method = RequestMethod.GET)
    public ResponseEntity<List<MovieDetails>> getAllMovies() {
        logger.info("Returning all Moview Details object .... ");
        return new ResponseEntity<List<MovieDetails>>(movieServiceImpl.getAllMovieDetails(), HttpStatus.OK);
    }

    @RequestMapping(value = "/jpamovies/{id}", method = RequestMethod.GET)
    public ResponseEntity<MovieDetails> getMovieById(@PathVariable("id") long id) throws MovieServiceException {
        logger.info("Finding Movie Details using movieId : " + id);
        MovieDetails movie = movieServiceImpl.getMovieDetailsById(id);

        if(null != movie && movie.getMovieId() > 0) {
            return new ResponseEntity<MovieDetails>( movie, HttpStatus.OK);
        } else {
            throw new MovieServiceException("Movie Details not found");
        }
    }

    @RequestMapping(value = "/jpamovies/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Response> removeMovieById(@PathVariable("id") long id) throws MovieServiceException {
        logger.info("Attempting to delete Movie with Id :" + id);
        MovieDetails movie = movieServiceImpl.getMovieDetailsById(id);

        if(null != movie && movie.getMovieId() > 0) {
            movieServiceImpl.removeMovieDetails(movie);
            return new ResponseEntity<Response>(new Response(id, "Removed the movie with ID :" + id), HttpStatus.OK);
        } else {
            throw new MovieServiceException("Movie Details not found");
        }
    }

    @RequestMapping(value = "/jpamovies", method = RequestMethod.POST)
    public ResponseEntity<MovieDetails> saveMovieDetails(@RequestBody MovieDetails movie) {
        logger.info("Attempting to save movie :" + movie);
        return new ResponseEntity<MovieDetails>(movieServiceImpl.saveMovieDetails(movie), HttpStatus.OK);
    }

    @RequestMapping(value = "/jpamovies", method = RequestMethod.PATCH)
    public ResponseEntity<MovieDetails> updateMovieDetails(MovieDetails movie) throws MovieServiceException {
        logger.info("Attempting to update movie :" + movie);
        MovieDetails movieToUpdate = movieServiceImpl.getMovieDetailsById(movie.getMovieId());

        if(null != movie && movie.getMovieId() > 0) {
            return new ResponseEntity<MovieDetails>(movieServiceImpl.saveMovieDetails(movieToUpdate), HttpStatus.OK);
        } else {
            throw new MovieServiceException("Movie Details not found");
        }
    }

}
