package com.bookm.BookManagement.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.bookm.BookManagement.model.Book;
import com.bookm.BookManagement.model.Genre;
import com.bookm.BookManagement.model.Publisher;
import com.bookm.BookManagement.service.BookService;
import com.bookm.BookManagement.service.GenreService;
import com.bookm.BookManagement.service.PublisherService;


@RestController
@CrossOrigin("*")
@RequestMapping("/api")
public class BookController {
	@Autowired
	BookService bookService;
	
	

	@PostMapping("/books/{genereId}/{publisherId}")
	public ResponseEntity<Book> addBook(@PathVariable Integer publisherId, @PathVariable Integer genereId,
			@RequestBody Book book) {
		Book savedBook = bookService.addBook(genereId, publisherId, book);
		return new ResponseEntity<>(savedBook, HttpStatus.CREATED);
	}

  @GetMapping("/books")
  public ResponseEntity<List<Book>> getAllBooks(){
	  List<Book> books = bookService.findAll();
	  return ResponseEntity.ok(books);
	  
  }
  @GetMapping("/books/{book_id}")
  public ResponseEntity<Book> getBookByid(@PathVariable Integer book_id){
	  Book book = bookService.getById(book_id);
	  if(book == null) {
		  return ResponseEntity.notFound().build();
	  }
	 return ResponseEntity.ok(book);
  }

//  @PutMapping("/books/{book_id}")
//  public ResponseEntity<Book> updateBook(@PathVariable Integer book_id,@RequestBody Book book){
//	 if(!bookService.existById(book_id)) {
//		 return ResponseEntity.notFound().build();
//	 }
//	 book.setBook_id(book_id);
//	 bookService.saveBook(book);
//	 return ResponseEntity.ok(book);
//  }
  @PutMapping("/books/{genreId}/{publisherId}/{book_id}")
	public ResponseEntity<Book> updateBook(@PathVariable Integer genreId, @PathVariable Integer publisherId,
			@PathVariable Integer book_id, @RequestBody Book updatedBook) {
		Book savedBook = bookService.updateBook(genreId, publisherId, book_id, updatedBook);
		return new ResponseEntity<>(savedBook, HttpStatus.OK);
	}

  @DeleteMapping("/books/{book_id}")
  public ResponseEntity<String> deleteBookById(@PathVariable Integer book_id){
	  String message = bookService.deleteBookById(book_id);
	  return ResponseEntity.ok(message);
  }

}