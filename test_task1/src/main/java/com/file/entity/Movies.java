package com.file.entity;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.HibernateException;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;

import com.file.entity.Ratings;

@Entity
public class Movies implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Column(name ="tconst")
    private String tconst;

@Column(name ="title_type")
private String titleType;

@Column(name ="primary_title")
private String primaryTitle;

@Column(name ="run_time_minutes")
private int runTimeMinutes;

@Column(name = "genres")
private String genres;

@OneToOne(mappedBy ="movies",cascade=CascadeType.ALL, fetch=FetchType.LAZY)
@PrimaryKeyJoinColumn
private Ratings ratings;

	    
	    public Movies() {}
	

	public Movies(String tconst, String titleType, String primaryTitle, int runTimeMinutes, String genres,
			Ratings ratings) {
		super();
		this.tconst = tconst;
		this.titleType = titleType;
		this.primaryTitle = primaryTitle;
		this.runTimeMinutes = runTimeMinutes;
		this.genres = genres;
		this.ratings = ratings;
	}

	public String getTconst() {
		return tconst;}


	 public void setTconst(String tconst) {
	        this.tconst = tconst;
	        // Also set tconst in Ratings entity
	        if (ratings != null) {
	            ratings.setTconst(tconst);}
	        }

	public String getTitleType() {
		return titleType;
	}

	public void setTitleType(String titleType) {
		this.titleType = titleType;
	}

	public String getPrimaryTitle() {
		return primaryTitle;
	}

	public void setPrimaryTitle(String primaryTitle) {
		this.primaryTitle = primaryTitle;
	}

	public int getRunTimeMinutes() {
		return runTimeMinutes;
	}

	public void setRunTimeMinutes(int runTimeMinutes) {
		this.runTimeMinutes = runTimeMinutes;
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
	    ratings.setMovies(this); // Set the movies property in the Ratings entity
	}

	@Override
	public String toString() {
		return "Movies [tconst=" + tconst + ", titleType=" + titleType + ", primaryTitle=" + primaryTitle
				+ ", runTimeMinutes=" + runTimeMinutes + ", genres=" + genres + ", ratings=" + ratings + "]";
	}

    // Constructors, getters, and setters
    
    
}
