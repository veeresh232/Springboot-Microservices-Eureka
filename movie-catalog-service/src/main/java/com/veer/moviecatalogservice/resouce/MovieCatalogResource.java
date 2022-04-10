package com.veer.moviecatalogservice.resouce;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import javax.swing.plaf.basic.BasicInternalFrameTitlePane.MoveAction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.veer.moviecatalogservice.models.CatalogItem;
import com.veer.moviecatalogservice.models.Movie;
import com.veer.moviecatalogservice.models.UserRating;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/catalog")
@Slf4j
public class MovieCatalogResource {
	
	 @Autowired
	 private RestTemplate restTemplate;

	
	@GetMapping("/{userId}")
	public List<CatalogItem> getCatalog(@PathVariable("userId")String userId){
		log.info("calling ratings service");
		UserRating ratings = restTemplate.getForObject("http://ratings-data-service/ratingsdata/users/"+userId, UserRating.class);
		return ratings.getRatings().stream().map(rating->{
			Movie movie = restTemplate.getForObject("http://movie-info-service/movies/"+rating.getMovieId(), Movie.class);
			return new CatalogItem(movie.getName(), "Desc", rating.getRating());
		})
		.collect(Collectors.toList());
			
	}
}
