package com.veer.movieinfoservice.models;

import lombok.Data;

@Data
public class Movie {

	
	public Movie(String movieId, String name) {
		
		this.movieId = movieId;
		this.name = name;
	}
	private String movieId;
	private String name;
}
