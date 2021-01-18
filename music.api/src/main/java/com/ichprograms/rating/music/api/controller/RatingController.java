package com.ichprograms.rating.music.api.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ichprograms.rating.music.api.model.Rating;
import com.ichprograms.rating.music.api.repository.RatingRepository;

@RestController
public class RatingController {
		
	@Autowired
	private RatingRepository ratingRepository;
		
	//POST Methods
	@PostMapping("/ratings/add") //Adds a new rating document
	public String saveRating(@RequestBody Rating rating) {
		ratingRepository.save(rating);
		return "Added rating under user : " + rating.getUser();
	}
		
	//GET Methods
	@GetMapping("/findAll/ratings") //Gets every single rating
	public List<Rating> getAll() { 
		List<Rating> ratings = this.ratingRepository.findAll();
			
	return ratings;
	}
		
	@GetMapping("/findAll/ratings/id/{id}") //Gets a rating by UID 
	public Optional<Rating> getRatingById(@PathVariable String id) {
		return ratingRepository.findById(id);	
	}

	@GetMapping("/findAll/ratings/user/{user}") //Gets specified user's ratings
	public List<Rating> getAllByUserId(@PathVariable String userId) {
		List<Rating> userRatings = this.ratingRepository.findAllByUserId(userId);
			
		return userRatings;
	}
		
	@GetMapping("/findAll/ratings/songId/{tuneId}") //Gets all ratings for a specific song
	public List<Rating> getAllBySongId(@PathVariable String songId) {
		List<Rating> songRatings = this.ratingRepository.findAllBySongId(songId);
			
		return songRatings;
	}
		
	//PATCH Methods
	//TODO Put a JSON Patch here to make updating ratings easier
		
	//PUT Methods
	//TODO Put methods for inserting. Remove update-PUT's if patch method is in
		
	//DELETE Methods
	@DeleteMapping("/ratings/delete/id/{id}") //Delete rating by UID
	public String deleteRating(@PathVariable String id) {
		ratingRepository.deleteById(id);
		
		return "Rating deleted with id : " + id;
	}
}
