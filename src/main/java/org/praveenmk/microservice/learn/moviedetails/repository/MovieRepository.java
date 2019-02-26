package org.praveenmk.microservice.learn.moviedetails.repository;

import org.praveenmk.microservice.learn.moviedetails.model.MovieDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("movieRepository")
public interface MovieRepository extends JpaRepository<MovieDetails, Long> {

}
