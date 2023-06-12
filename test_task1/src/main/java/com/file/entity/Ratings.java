package com.file.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import com.file.entity.Movies;

import org.hibernate.HibernateException;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;

@Entity
@Table(name = "ratings")
public class Ratings {
	  @Id
	   // @GeneratedValue(generator = "tconst-generator")
	    //@GenericGenerator(name = "tconst-generator", strategy = "com.file.Entity.TconstIdentifierGenerator")
	    @Column(name ="tconst")
	    private String tconst;

    @Column(name ="average_rating")
    private double averageRating;

    @Column(name ="num_votes")
    private int numVotes;
    
    @OneToOne(fetch=FetchType.LAZY)
    @MapsId
    @JoinColumn(name="tconst")
    private Movies movies;
    
    
    

//	  public static class TconstIdentifierGenerator implements IdentifierGenerator {
//
//	        private static final String PREFIX = "tt";
//	        private static final int SEQUENCE_LENGTH = 7;
//	        private static final int MAX_SEQUENCE_NUMBER = 9999999;
//
//	        private int sequenceNumber = 1;
//
//	        @Override
//	        public Serializable generate(SharedSessionContractImplementor session, Object object) throws HibernateException {
//	            if (sequenceNumber > MAX_SEQUENCE_NUMBER) {
//	                throw new HibernateException("Maximum tconst sequence number exceeded");
//	            }
//	            
//	            String formattedSequence = String.format("%0" + SEQUENCE_LENGTH + "d", sequenceNumber);
//	            String generatedTconst = PREFIX + formattedSequence;
//	            sequenceNumber++;
//
//	            return generatedTconst;
//	        }
//	    }
    
    

	public Ratings() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Ratings(String tconst, double averageRating, int numVotes, Movies movies) {
		super();
		this.tconst = tconst;
		this.averageRating = averageRating;
		this.numVotes = numVotes;
		this.movies = movies;
	}

	public String getTconst() {
		return tconst;
	}

	public void setTconst(String tconst) {
		System.out.println("this is in rating "+tconst);
		this.tconst = tconst;
	}

	public double getAverageRating() {
		return averageRating;
	}

	public void setAverageRating(double averageRating) {
		this.averageRating = averageRating;
	}

	public int getNumVotes() {
		return numVotes;
	}

	public void setNumVotes(int numVotes) {
		this.numVotes = numVotes;
	}

	public Movies getMovies() {
		return movies;
	}

	
	 public void setMovies(Movies movies) {
	        this.movies = movies;
	    }

	@Override
	public String toString() {
		return "Ratings [tconst=" + tconst + ", averageRating=" + averageRating + ", numVotes=" + numVotes + ", movie="
				+ movies + "]";
	}


	

	
	
	

 
}
