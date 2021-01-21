package com.ichprograms.rating.music.api.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Pageable;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Sort;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
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

	public Map<String, Object> getAllSongsInPage(int pageNo, int pageSize, String sortBy) {
		Map<String, Object>  response = new HashMap<String, Object>();
		
		Sort sort = Sort.by(sortBy);
		Pageable page = PageRequest.of(pageNo, pageSize, sortBy);
		Page<Song> songPage =songRepository.findAll(page);
		response.put("data", value);
	}
	
	
}
