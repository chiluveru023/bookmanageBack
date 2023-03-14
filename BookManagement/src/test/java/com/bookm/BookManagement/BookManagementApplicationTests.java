package com.bookm.BookManagement;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;

import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.bookm.BookManagement.model.Book;

import com.bookm.BookManagement.repository.BookRepository;


@SpringBootTest
@TestMethodOrder(OrderAnnotation.class)
class BookManagementApplicationTests {
	@Autowired
	BookRepository bookRepository;
@Test
@Order(1)
public void addBook() {
//	Book book = new Book();
//	book.setBook_id(1);
//	book.setBook_name("Charles");
////	book.setBook_genre("comic");
//	book.setBook_author("Robin");
//	book.setBook_publishers("M.sweecy's");
//	bookRepository.save(book);
	assertNotNull(bookRepository.findById(9).get());
}
@Test
@Order(2)
public void getAll() {
	List list = bookRepository.findAll();
	assertThat(list).size().isGreaterThan(0);
	
}
@Test
@Order(3)
public void getById() {
	Book book = bookRepository.findById(9).get();
//	assertEquals("Penguin Books", book.getBook_publishers());
}

@Test
@Order(4)
public void addUpdate() {
	Book book = bookRepository.findById(9).get();
	book.setBook_author("Raji");
	bookRepository.save(book);
	assertNotEquals("Peter Straub",bookRepository.findById(9).get().getBook_author());
}

@Test
@Order(5)

public void testDelete() {
	bookRepository.deleteById(9);
	assertThat(bookRepository.existsById(9)).isFalse();
}
}

