package com.ichprograms.rating.music.api.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
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
	@CrossOrigin(origins = "http://localhost:4500") //CORS
	@GetMapping("/all") //Get all songs in the collection
	public List<Song> getAll() {	
	   return songService.getAll();
	}
	   
	@GetMapping("/page") //Get all songs in page format
	public Map<String, Object> getAllInPage(@RequestParam(name = "pageno", defaultValue = "0") int pageNo,
			@RequestParam (name = "pagesize", defaultValue = "2") int pageSize,
			@RequestParam (name = "sortby", defaultValue = "id") String sortBy) {
		
	    return songService.getAllInPage(pageNo, pageSize, sortBy);
	}
	
	@GetMapping("/example") //Get all songs by example
	public List<Song> getAllByExample(@RequestBody Song song) {	 
		return songService.getAllByExample(song);
	}
	
	@GetMapping("/title") //TODO Explanation of method
	public List<Song> getAllByTitle(@RequestParam(name = "title") String title) {
		return songService.getAllByTitle(title);	
	}
	
	@GetMapping("/genre")
	public List<Song> getAllByGenre(@RequestParam(name = "genre") String genre) {
		return songService.getAllByGenre(genre);	
	}
	
	@GetMapping("/rating/greaterthan")
	public List<Song> getAllByRatingGreaterThan(@RequestParam(name = "avgRating") double avgRating) {
		return songService.getAllByRatingGreaterThan(avgRating);	
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