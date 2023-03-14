package com.bookm.BookManagement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bookm.BookManagement.model.Publisher;
import com.bookm.BookManagement.service.PublisherService;

@RestController
@CrossOrigin("*")
@RequestMapping("/api")
public class PublisherController {

	@Autowired
	PublisherService publisherService;

	  @GetMapping("/publisher")
	  public List<Publisher> getAllPublishers() {
	      return publisherService.getAllPublishers();
	  }
	  @PostMapping("/publisher")
	  public Publisher savePublisher(@RequestBody Publisher publisher) {
	      return publisherService.savePublisher(publisher);
	  }
	 
}
