package com.veer.moviecatalogservice.models;

import lombok.Data;

@Data
public class Rating {

	private String movieId;
	private int rating;
	
	public Rating() {
		
	}
	public Rating(String movieId, int rating) {

		this.movieId = movieId;
		this.rating = rating;
	}
	
}
