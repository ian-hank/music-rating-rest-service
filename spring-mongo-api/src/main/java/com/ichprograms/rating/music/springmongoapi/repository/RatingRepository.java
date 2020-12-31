package com.ichprograms.rating.music.springmongoapi.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.ichprograms.rating.music.springmongoapi.model.Rating;

public interface RatingRepository extends MongoRepository<Rating, Integer>{

}
