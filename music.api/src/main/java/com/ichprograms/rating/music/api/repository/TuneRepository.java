package com.ichprograms.rating.music.api.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.ichprograms.rating.music.api.model.Tune;

@Repository
public interface TuneRepository extends MongoRepository<Tune, Integer>{
	
}