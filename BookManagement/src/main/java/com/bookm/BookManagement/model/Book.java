package com.bookm.BookManagement.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
@Entity
@Table(name = "Book")
public class Book {
	
@Id
@GeneratedValue(strategy = GenerationType.AUTO)
//@Column(name="book_id", unique = true)
private int book_id;
private String book_name;
private String book_author;

@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
@JoinColumn(name = "genre_id")
private Genre genre;

@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
@JoinColumn(name = "publisher_id")
private Publisher publisher;

public int getBook_id() {
	return book_id;
}

public void setBook_id(int book_id) {
	this.book_id = book_id;
}

public String getBook_name() {
	return book_name;
}

public void setBook_name(String book_name) {
	this.book_name = book_name;
}

public String getBook_author() {
	return book_author;
}

public void setBook_author(String book_author) {
	this.book_author = book_author;
}

public Genre getGenre() {
	return genre;
}

public void setGenre(Genre genre) {
	this.genre = genre;
}

public Publisher getPublisher() {
	return publisher;
}

public void setPublisher(Publisher publisher) {
	this.publisher = publisher;
}

public Book(int book_id, String book_name, String book_author, Genre genre, Publisher publisher) {
	super();
	this.book_id = book_id;
	this.book_name = book_name;
	this.book_author = book_author;
	this.genre = genre;
	this.publisher = publisher;
}

public Book() {
	super();
	// TODO Auto-generated constructor stub
}
@Override
public String toString() {
	return "Book [book_id=" + book_id + ", book_name=" + book_name + ", book_author=" + book_author + ", genre=" + genre
			+ ", publisher=" + publisher + "]";
}

//@ManyToOne(cascade = {CascadeType.MERGE},fetch = FetchType.LAZY)
// @JoinColumn(name= "genre_id")
//private Genre genres;
//
//@ManyToOne(cascade = {CascadeType.MERGE},fetch = FetchType.LAZY)
// @JoinColumn(name="publisher_id")
//private Publisher publishers;






}