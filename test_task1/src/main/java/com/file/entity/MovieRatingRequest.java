package com.file.entity;

public class MovieRatingRequest {
    private String primaryTitle;
    private String titleType;
    private String tconst;
    private int runtimeMinutes;
    private String genres;
    private Ratings ratings;
    
    
    
    

    public MovieRatingRequest() {
		super();
		// TODO Auto-generated constructor stub
	}
    




	
	
	public MovieRatingRequest(String primaryTitle, String titleType, String tconst, int runtimeMinutes, String genres,
			Ratings ratings) {
		super();
		this.primaryTitle = primaryTitle;
		this.titleType = titleType;
		this.tconst = tconst;
		this.runtimeMinutes = runtimeMinutes;
		this.genres = genres;
		this.ratings = ratings;
	}







	public String getPrimaryTitle() {
		return primaryTitle;
	}







	public void setPrimaryTitle(String primaryTitle) {
		this.primaryTitle = primaryTitle;
	}







	public String getTitleType() {
		return titleType;
	}







	public void setTitleType(String titleType) {
		this.titleType = titleType;
	}







	public String getTconst() {
		return tconst;
	}







	public void setTconst(String tconst) {
		this.tconst = tconst;
	}







	public int getRuntimeMinutes() {
		return runtimeMinutes;
	}







	public void setRuntimeMinutes(int runtimeMinutes) {
		this.runtimeMinutes = runtimeMinutes;
	}







	public String getGenres() {
		return genres;
	}







	public void setGenres(String genres) {
		this.genres = genres;
	}







	public Ratings getRatings() {
		return ratings;
	}







	public void setRatings(Ratings ratings) {
		this.ratings = ratings;
	}







	



	
}
