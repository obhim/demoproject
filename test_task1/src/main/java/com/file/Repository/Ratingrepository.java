package com.file.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.file.entity.Ratings;

@Repository
public interface Ratingrepository extends JpaRepository<Ratings, String>{
	@Query("SELECT MAX(r.tconst) FROM Ratings r")
    String findMaxTconst();
}
