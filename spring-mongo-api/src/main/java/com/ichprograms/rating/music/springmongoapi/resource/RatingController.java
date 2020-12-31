package com.ichprograms.rating.music.springmongoapi.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.ichprograms.rating.music.springmongoapi.repository.RatingRepository;

@RestController
public class RatingController {
	@Autowired
	private RatingRepository repository;
	
	
}
