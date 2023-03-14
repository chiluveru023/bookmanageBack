package com.bookm.BookManagement.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.bookm.BookManagement.model.Book;
import com.bookm.BookManagement.model.Genre;
import com.bookm.BookManagement.model.Publisher;
import com.bookm.BookManagement.repository.BookRepository;
import com.bookm.BookManagement.repository.GenreRepository;
import com.bookm.BookManagement.repository.PublisherRepository;


@Service
public class BookService {
	
	@Autowired
	BookRepository bookRepository;
	
	@Autowired 
	GenreRepository genreRepository;
	
	@Autowired
	PublisherRepository publisherRepository;
	
	public Book addBook(Integer genereId, Integer publisherId, Book book)  {
			Publisher publisher = publisherRepository.findById(publisherId).get();
			Genre genre=genreRepository.findById(genereId).get();
			book.setPublisher(publisher);
			book.setGenre(genre);
			return bookRepository.save(book);
			}

	

		
		public List<Book> findAll(){
			return bookRepository.findAll();
		}
		public Book getById(Integer book_id){
			return bookRepository.findById(book_id).orElse(null);
		}
		public boolean existById(Integer book_id) {
			return bookRepository.existsById(book_id);
		}

		public String deleteBookById(Integer book_id) {
			bookRepository.deleteById(book_id);
			return  "Book With Id" +  book_id  +  "Has been deleted";
		}

		public Book updateBook(Integer genreId, Integer publisherId, Integer book_id, Book updatedBook) {
			// TODO Auto-generated method stub
			Book book = bookRepository.findById(book_id)
					.orElseThrow(() -> new ResourceNotFoundException("Book not found with ID " + book_id));
			Publisher publisher = publisherRepository.findById(publisherId).get();
			Genre genre = genreRepository.findById(genreId).get();
			book.setPublisher(publisher);
			book.setGenre(genre);
			book.setBook_name(updatedBook.getBook_name());
			book.setBook_author(updatedBook.getBook_author());
			
			return bookRepository.save(book);
		}
//		public Book updateBook(Book book) {
//			if (bookRepository.existsById(book.getBook_id())) {
//				Book updatedBook = bookRepository.save(book);
//				return updatedBook;
//			}
//			return book;
//		}
	}
	         

	    	
