package com.bookm.BookManagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bookm.BookManagement.model.Book;

public interface BookRepository extends JpaRepository<Book, Integer> {

}
