package org.praveenmk.microservice.learn.moviedetails.resources;


import org.praveenmk.microservice.learn.moviedetails.model.MovieDetails;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/movies")
public class MovieDetailsResource {

    @RequestMapping("/{movieId}")
    public List<MovieDetails> getMovieDetails(@PathVariable("movieId") String movieId) {
        if(movieId.equalsIgnoreCase("*")) {
            return movieList();
        }
        else {
            return movieList().stream().filter(movie -> movie.getMovieId() == Long.parseLong(movieId)).collect(Collectors.toList());
        }
    }

    /**
     * this is test data generator method
     *
     * @return
     */
    private List<MovieDetails> movieList() {
        List<MovieDetails> movieDetailsList = new ArrayList<>();
        movieDetailsList.add(new MovieDetails(1, "Movie One", "Movie One Description"));
        movieDetailsList.add(new MovieDetails(2, "Movie Two", "Movie Two Description"));

        return movieDetailsList;
    }
}
