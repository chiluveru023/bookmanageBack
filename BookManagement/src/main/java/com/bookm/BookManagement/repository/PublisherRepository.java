package com.bookm.BookManagement.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

//import com.bookm.BookManagement.model.Book;
import com.bookm.BookManagement.model.Publisher;


public interface PublisherRepository extends JpaRepository<Publisher,Integer> {

//	List<Book> findByName(String book_publisher);
}
