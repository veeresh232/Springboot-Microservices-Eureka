package com.veer.moviecatalogservice.models;

import java.util.Arrays;
import java.util.List;

import lombok.Builder;
import lombok.Builder.Default;

public class UserRating {

    private String userId;
    
    
    private List<Rating> ratings;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public List<Rating> getRatings() {
        return ratings;
    }

    public void setRatings(List<Rating> ratings) {
        this.ratings = ratings;
    }

}