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
	private TuneRepository repository;
	  
	//POST Tune request
	@PostMapping("/addTune")
	public String saveTune(@RequestBody Tune tune) {
		repository.save(tune);
		return "Added tune with id : " + tune.getId();
	}
	 
	//GET all Tunes request
	@GetMapping("/findAllTunes")
	public List<Tune> getTunes() {
	   return repository.findAll();
	}
	   
	//GET Tune by id request
	@GetMapping("/findAllTunes/{id}")
	public Optional<Tune> getTune(@PathVariable int id) {
	    return repository.findById(id);
	}
	  
	//DELETE Tune by id request
	@DeleteMapping("/delete/{id}")
	public String deleteTune(@PathVariable int id) {
	    repository.deleteById(id);
	    return "Tune deleted with id : " + id;
	}
}