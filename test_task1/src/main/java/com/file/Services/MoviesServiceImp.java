package com.file.Services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.Query;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.file.Repository.MoviesRepository;
import com.file.dto.TopRatedMovieResponse;
import com.file.entity.Movies;
import com.file.entity.Ratings;

@Service
public class MoviesServiceImp implements MoviesService {
	
	@Autowired
	private MoviesRepository moviesRepo;

	@Override
	public List<Object[]> getMovies() {
		
		return moviesRepo.findAllMovies();
	}


	 @Override
	    public String getLastTconst() {
	        return moviesRepo.getLastTconst();
	    }

	    

	 @Override
		public ResponseEntity<String> saveMovie(Movies movie) {
			// TODO Auto-generated method stub
			 moviesRepo.save(movie);
			 return ResponseEntity.ok("success");
		}
	 

		@Override
		public void deleteMovieByTconst(String tconst) {
			moviesRepo.deleteById(tconst);
			
		}


		 @Override
		    public List<Object[]> getLongestDurationMovies() {
		        return moviesRepo.findTop10ByOrderByRunTimeMinutesDesc();
		    }

		  public List<TopRatedMovieResponse> getTopRatedMovies() {
		        return moviesRepo.findTopRatedMovies();
		    }


		@Override
		public void save(Movies movies) {
			
			moviesRepo.save(movies);
			
		}


		
		  
	 


		


    
				
	

}
