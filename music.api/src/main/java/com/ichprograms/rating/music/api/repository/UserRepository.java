package com.ichprograms.rating.music.api.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.ichprograms.rating.music.api.model.User;

public interface UserRepository extends MongoRepository<User, String>{

}
