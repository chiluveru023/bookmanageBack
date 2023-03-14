package com.bookm.BookManagement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bookm.BookManagement.model.Genre;
import com.bookm.BookManagement.service.GenreService;

@RestController
@CrossOrigin("*")
@RequestMapping("/api")
public class GenreController {

	@Autowired
	GenreService genreService;

	  @PostMapping("/genre")
	  public Genre saveGenre(@RequestBody Genre genre) {
	      return genreService.createGenre(genre);
	  }
	  @GetMapping("/genre")
	  public List<Genre> getAllGenres() {
	      return genreService.getAllGenres();
	  }

}
