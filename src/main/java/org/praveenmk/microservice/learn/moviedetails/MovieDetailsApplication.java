package org.praveenmk.microservice.learn.moviedetails;

import org.praveenmk.microservice.learn.moviedetails.model.MovieDetails;
import org.praveenmk.microservice.learn.moviedetails.repository.MovieRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class MovieDetailsApplication {

	public static void main(String[] args) {
		SpringApplication.run(MovieDetailsApplication.class, args);
	}

	@Bean
	public CommandLineRunner setup(MovieRepository movieRepository) {
		return (args) -> {
			movieRepository.save(new MovieDetails("Movie 1", "Movie Desciption 1"));
			movieRepository.save(new MovieDetails("Movie 2", "Movie Desciption 2"));
			movieRepository.save(new MovieDetails("Movie 3", "Movie Desciption 3"));
		};
	}
}
