package com.ichprograms.rating.music.api.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.ichprograms.rating.music.api.model.Rating;

@Repository
public interface RatingRepository extends MongoRepository<Rating, String>{

	List<Rating> findAllByUserId(String userId);

	List<Rating> findAllBySongId(String songId);

}
