package com.bookm.BookManagement.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.bookm.BookManagement.model.Genre;
import com.bookm.BookManagement.repository.GenreRepository;

@Service
public class GenreService {

	@Autowired
	GenreRepository genreRepository;
	
    public Genre createGenre(Genre genre) {
        return genreRepository.save(genre);
    }

    public List<Genre> getAllGenres() {
        return genreRepository.findAll();
    }

   
}

