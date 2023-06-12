package com.file.Controller;

import java.util.List;
import java.util.Map;

import org.apache.catalina.Contained;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.file.Repository.MoviesRepository;
import com.file.Repository.Ratingrepository;
import com.file.Services.MoviesService;
import com.file.dto.TopRatedMovieResponse;
import com.file.entity.MovieRatingRequest;
import com.file.entity.Movies;
import com.file.entity.Ratings;

@RestController
public class MoviesController {
	@Autowired
	private MoviesService moviesService;
	@Autowired
	private Ratingrepository ratingRepository;
	
	

	@GetMapping("/getMoviesList")
	public List<Object[]> getMovies() {
		return moviesService.getMovies();
	}

	

	  @GetMapping("/api/v1/longest-duration-movies")
	    public List<Object[]> getLongestDurationMovies() {
	        return moviesService.getLongestDurationMovies();
	    }
	
	
	// code to generate default primary key
	private String generateTconst() {
		

		String lastTconst = moviesService.getLastTconst();
		if (lastTconst == null) {
            lastTconst="tt000000";
		}
		int lastNumber = Integer.parseInt(lastTconst.substring(2));

		int newNumber = lastNumber + 1;
		String newTconst = String.format("tt%07d", newNumber);
		return newTconst;
	}
	

    @PostMapping("/api/v1/new-movie")
    public String createNewMovie(@RequestBody MovieRatingRequest request) {
        Movies movies = new Movies();
        String tco=generateTconst();
        movies.setTconst(tco);
        movies.setTitleType(request.getTitleType());
        movies.setPrimaryTitle(request.getPrimaryTitle());
        movies.setRunTimeMinutes(request.getRuntimeMinutes());
        movies.setGenres(request.getGenres());

        Ratings ratings = new Ratings();
        ratings.setAverageRating(request.getRatings().getAverageRating());
        ratings.setNumVotes(request.getRatings().getNumVotes());
        ratings.setMovies(movies);

        movies.setRatings(ratings);

        moviesService.save(movies);

        return "Success";
    }


    @GetMapping("/api/v1/top-rated-movies")
    public List<TopRatedMovieResponse> getTopRatedMovies() {
        return moviesService.getTopRatedMovies();
    	
    }
    
    
    @DeleteMapping("/movies/{tconst}")
	public ResponseEntity<String> deleteMovie(@PathVariable String tconst) {

		moviesService.deleteMovieByTconst(tconst);

		return ResponseEntity.ok("Movie deleted successfully");
	}
    
   @GetMapping("/api/v1/genre-movies-with-subtotal")
   public List<Object[]> getMoviesSubtotal() {
		return moviesService.getMoviesSubtotal(); 
		}
   
   @PostMapping("/api/v1/update-runtime-minutes")
   public String incrementRuntimeMinutes() {
	   moviesService.incrementRuntimeMinutes();
	   return"Updated";
       
   }
  
}
