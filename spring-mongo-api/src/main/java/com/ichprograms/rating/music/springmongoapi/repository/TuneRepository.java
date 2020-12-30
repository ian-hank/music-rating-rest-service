package com.ichprograms.rating.music.springmongoapi.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.ichprograms.rating.music.springmongoapi.model.Tune;

public interface TuneRepository extends MongoRepository<Tune, Integer>{

}
