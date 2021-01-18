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

import com.ichprograms.rating.music.api.model.Song;
import com.ichprograms.rating.music.api.repository.SongRepository;

@RestController
public class SongController {
	
	@Autowired
	private SongRepository tuneRepository;
	  
	//POST Methods
	@PostMapping("/songs/add") //Adds a new song
	public String saveTune(@RequestBody Song tune) {
		tuneRepository.save(tune);
		
		return "Added song with id : " + tune.getId();
	}
	 
	//GET Methods
	@GetMapping("/findAll/songs/") //Get all songs in the collection
	public List<Song> getTunes() {
		List<Song> tunes = this.tuneRepository.findAll();
		
	   return tunes;
	}
	   
	@GetMapping("/findAll/songs/id/{id}") //Get all songs with UID
	public Optional<Song> getTune(@PathVariable String id) {
	    return tuneRepository.findById(id);
	}
	  
	//PATCH Methods
	//TODO Put a JSON Patch here eventually to make updating ratings easier
			
	//PUT Methods
	//TODO Put methods for inserting. Remove update-PUT's if patch method is in
	
	//DELETE Methods
	@DeleteMapping("/tunes/delete/id/{id}") //Delete song by its UID
	public String deleteTune(@PathVariable String id) {
	    tuneRepository.deleteById(id);
	    
	    return "Song deleted with id : " + id;
	}
}