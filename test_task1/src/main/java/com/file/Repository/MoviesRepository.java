package com.file.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.file.dto.TopRatedMovieResponse;
import com.file.entity.Movies;

@Repository
public interface MoviesRepository extends JpaRepository<Movies,String> {

	@Query("SELECT MAX(r.tconst) FROM Ratings r")
	String findMaxTconst();

	@Query(value = "SELECT tconst FROM movies ORDER BY tconst DESC LIMIT 1", nativeQuery = true)
	String getLastTconst();

	@Query("SELECT m.tconst, m.primaryTitle, m.runTimeMinutes, m.genres " + "FROM Movies m "
			+ "ORDER BY m.runTimeMinutes DESC")
	List<Object[]> findTop10ByOrderByRunTimeMinutesDesc();

	// @Query(value="SELECT FROM Movies m m.tconst, m.primary_title, m.genres,
	// r.average_rating JOIN m.ratings r WHERE r.average_rating > 6.0 ORDER BY
	// r.average_rating DESC", nativeQuery=true)

	@Query("SELECT new com.file.dto.TopRatedMovieResponse(m.tconst, m.primaryTitle, m.genres, AVG(r.averageRating)) "
			+ "FROM Movies m " + "JOIN m.ratings r " + "GROUP BY m.tconst, m.primaryTitle, m.genres "
			+ "HAVING AVG(r.averageRating) > 6.0 " + "ORDER BY AVG(r.averageRating) DESC")
	List<TopRatedMovieResponse> findTopRatedMovies();

	@Query("SELECT m.primaryTitle, m.titleType, m.runTimeMinutes, m.genres, r.numVotes, r.averageRating FROM Movies m JOIN m.ratings r WHERE m.tconst = r.movies.tconst")
	List<Object[]> findAllMovies();

	@Query( value="SELECT \r\n"
			+ "IFNULL(genres,' ') AS genres,\r\n"
			+ "IFNULL(primary_title, 'TOTAL') AS primary_title,\r\n"
			+ "  IFNULL(num_votes, 0) AS num_votes\r\n"
			+ "FROM (\r\n"
			+ "  SELECT \r\n"
			+ "    genres,\r\n"
			+ "    primary_title,\r\n"
			+ "    SUM(num_votes) AS num_votes\r\n"
			+ "  FROM movies\r\n"
			+ "  JOIN ratings ON movies.tconst = ratings.tconst\r\n"
			+ "  GROUP BY genres, primary_title\r\n"
			+ "  WITH ROLLUP\r\n"
			+ ") AS subtotals", nativeQuery=true)
	List<Object[]> getMovieVoteTotals();

	

	

	

	

}
