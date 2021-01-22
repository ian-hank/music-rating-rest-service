package com.ichprograms.rating.music.api.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.ExampleMatcher.GenericPropertyMatcher;
import org.springframework.data.domain.ExampleMatcher.StringMatcher;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.ichprograms.rating.music.api.model.Song;
import com.ichprograms.rating.music.api.repository.SongRepository;

@Service
public class SongService {
	
	@Autowired
	SongRepository songRepository;
	
	public List<Song> getAll() {
		return songRepository.findAll();
	}

	public Song addSong(Song song) {
		return songRepository.insert(song);
	}

	public Song updateSong(Song song) {
		return songRepository.save(song);
	}

	public void delete(String id) {
		songRepository.deleteById(id);
	}

	public Map<String, Object> getAllInPage(int pageNo, int pageSize, String sortBy) {
		Map<String, Object>  response = new HashMap<String, Object>();
		
		Sort sort = Sort.by(sortBy);
		Pageable page = PageRequest.of(pageNo, pageSize, sort);
		Page<Song> songPage = songRepository.findAll(page);
		
		response.put("data", songPage.getContent());
		response.put("No. Of Pages", songPage.getTotalPages());
		response.put("No. Of Elements", songPage.getTotalElements());
		response.put("Current Page No.", songPage.getNumber());
		
		return response;
	}

	public List<Song> getAllByExample(Song song) {
		ExampleMatcher matcher = ExampleMatcher.matchingAny().withIgnoreCase().withMatcher("song", GenericPropertyMatcher.of(StringMatcher.ENDING));
		Example<Song> songExample = Example.of(song, matcher);
		
		return songRepository.findAll(songExample);
	}

	public List<Song> getAllByTitle(String title) {
		return songRepository.findByTitleStartingWith(title);
	}

	public List<Song> getAllByGenre(String genre) {
		return songRepository.findByGenreMainGenre(genre);
	}

	public List<Song> getAllByRatingGreaterThan(double avgRating) {
		return songRepository.ratingGreaterThan(avgRating);
	}
}
