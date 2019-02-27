package org.praveenmk.microservice.learn.moviedetails.service;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.praveenmk.microservice.learn.moviedetails.model.MovieDetails;
import org.praveenmk.microservice.learn.moviedetails.repository.MovieRepository;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;

@RunWith(SpringJUnit4ClassRunner.class)
public class MovieServiceImplTest {

    @Mock
    private MovieRepository movieRepository;

    @InjectMocks
    private MovieServiceImpl movieService;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void getAllMovieDetails() {

        List<MovieDetails> movies = new ArrayList<>();
        for (long i = 1; i < 6 ; i++) {
            MovieDetails m = new MovieDetails(i, "Movie - " + i, "Movie Description - " + i);
            movies.add(m);
        }
        when(movieRepository.findAll()).thenReturn(movies);

        List<MovieDetails> result = movieService.getAllMovieDetails();
        Assert.assertEquals(5, result.size());
    }

    @Test
    public void getMovieDetailsById() {
        when(movieRepository.findById(1L)).thenReturn(
                java.util.Optional.of(new MovieDetails(1L, "Movie - 1", "Movie Description - 1")));

        MovieDetails result = movieService.getMovieDetailsById(1L);
        Assert.assertEquals(result.getMovieId(), 1L);
    }

    @Test
    public void saveMovieDetails() {
    }

    @Test
    public void removeMovieDetails() {
    }
}