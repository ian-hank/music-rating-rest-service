package com.ichprograms.rating.music.api.controller;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ichprograms.rating.music.api.model.Song;
import com.ichprograms.rating.music.api.service.SongService;

@RestController
@RequestMapping("/songs")
public class SongController {
	
	@Autowired
	private SongService songService;
	
	//GET Methods
	@GetMapping("/all") //Get all songs in the collection
	public List<Song> getAll() {	
	   return songService.getAll();
	}
	   
	@GetMapping("/page") //Get all songs with UID
	public Map<String, Object> getAllSongsInPage(@RequestParam(name = "pageno", defaultValue = "0") int pageNo,
			@RequestParam (name = "pagesize", defaultValue = "2") int pageSize,
			@RequestParam (name = "sortby", defaultValue = "id") String sortBy){
	    return songService.getAllSongsInPage(pageNo, pageSize, sortBy);
	}
	
	//POST Methods
	@PostMapping("/add") //Adds a new song
	public Song addSong(@RequestBody Song song) {
		return songService.addSong(song);
	} 
	  
	//PATCH Methods
	//TODO Put a JSON Patch here eventually to make updating ratings easier
			
	//PUT Methods
	@PutMapping("/update")
	public Song updateSong(@RequestBody Song song) {
		return songService.updateSong(song);
	}
	
	//DELETE Methods
	@DeleteMapping("/delete/{id}") //Delete song by its UID
	public void deleteSong(@RequestParam("id") String id) {
	    songService.delete(id);    
	}
}