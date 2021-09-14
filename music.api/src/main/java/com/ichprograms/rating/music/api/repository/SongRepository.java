package com.ichprograms.rating.music.api.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.ichprograms.rating.music.api.model.Song;

@Repository
public interface SongRepository extends MongoRepository<Song, String> {
	
	List<Song> findByTitleStartingWith(String title);

	List<Song> findByGenreMainGenre(String genre);
	
	@Query(value = "{'avgRating': {$gte:?0}}", fields = "{'title':1, 'authors':1, 'id':0}")
	List<Song> ratingGreaterThan(double avgRating);	
}