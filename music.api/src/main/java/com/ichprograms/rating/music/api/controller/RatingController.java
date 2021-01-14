package com.ichprograms.rating.music.api.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ichprograms.rating.music.api.model.Rating;
import com.ichprograms.rating.music.api.repository.RatingRepository;

//TODO Alot.

@RestController
public class RatingController {
		
		@Autowired
		private RatingRepository repository;
		
		//POST Methods
		@PostMapping("/addRating")
		public String saveRating(@RequestBody Rating rating) {
			repository.save(rating);
			return "Added rating under userID : " + rating.getId();
			
		}
		
		//GET Methods
		@GetMapping("/findAllRatings/{id}")
		public Optional<Rating> getRating(@PathVariable int id) {
			return repository.findById(id);
		}
		
		//PATCH Methods
		
		//DELETE Methods
		@DeleteMapping("/deleteRating/{id}")
		public String deleteRating(@PathVariable int id) {
			repository.deleteById(id);
			return "Rating deleted with id : " + id;
		}
		
}
