package com.bookm.BookManagement.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bookm.BookManagement.model.Publisher;
import com.bookm.BookManagement.repository.PublisherRepository;
import java.util.List;
@Service
public class PublisherService {
	
	@Autowired
	PublisherRepository publisherRepository;
	
//	public Publisher savePublisher(Publisher publisher) {
//        return publisherRepository.save(publisher);
//    }

    public List<Publisher> getAllPublishers() {
        return publisherRepository.findAll();
    }

	public Publisher savePublisher(Publisher publisher) {
		// TODO Auto-generated method stub
		return publisherRepository.save(publisher);
	}

  
}
