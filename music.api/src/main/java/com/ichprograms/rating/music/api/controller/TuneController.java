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

import com.ichprograms.rating.music.api.model.Tune;
import com.ichprograms.rating.music.api.repository.TuneRepository;

@RestController
public class TuneController {
	
	@Autowired
	private TuneRepository tuneRepository;
	  
	//POST Methods
	@PostMapping("/songs/add") //Adds a new song
	public String saveTune(@RequestBody Tune tune) {
		tuneRepository.save(tune);
		
		return "Added song with id : " + tune.getId();
	}
	 
	//GET Methods
	@GetMapping("/findAll/tunes/") //Get all songs in the collection
	public List<Tune> getTunes() {
		List<Tune> tunes = this.tuneRepository.findAll();
		
	   return tunes;
	}
	   
	@GetMapping("/findAll/tunes/id/{id}") //Get all songs with UID
	public Optional<Tune> getTune(@PathVariable int id) {
	    return tuneRepository.findById(id);
	}
	  
	//PATCH Methods
	//TODO Put a JSON Patch here eventually to make updating ratings easier
			
	//PUT Methods
	//TODO Put methods for inserting. Remove update-PUT's if patch method is in
	
	//DELETE Methods
	@DeleteMapping("/tunes/delete/id/{id}") //Delete song by its UID
	public String deleteTune(@PathVariable int id) {
	    tuneRepository.deleteById(id);
	    
	    return "Song deleted with id : " + id;
	}
}