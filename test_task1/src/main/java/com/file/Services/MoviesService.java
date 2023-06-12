package com.file.Services;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.file.dto.TopRatedMovieResponse;
import com.file.entity.Movies;

public interface MoviesService {

	List<Object[]> getMovies();

	String getLastTconst();

	ResponseEntity<String> saveMovie(Movies movie);


	    void deleteMovieByTconst(String tconst);

		List<Object[]> getLongestDurationMovies();

		List<TopRatedMovieResponse> getTopRatedMovies();

		void save(Movies movies);

		List<Object[]> getMoviesSubtotal();

		void incrementRuntimeMinutes();

	

		

		

		
	

}
