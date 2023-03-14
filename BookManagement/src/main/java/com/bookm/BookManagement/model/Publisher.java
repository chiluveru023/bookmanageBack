package com.bookm.BookManagement.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="book_publisher")
public class Publisher {
	
   @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int publisher_id;
	private String book_publisher;
	
    @OneToMany(mappedBy = "publisher",fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
	@JsonIgnore
    private List<Book> book;
    
	public int getPublisher_id() {
		return publisher_id;
	}
	public void setPublisher_id(int publisher_id) {
		this.publisher_id = publisher_id;
	}
	public String getBook_publisher() {
		return book_publisher;
	}
	public void setBook_publisher(String book_publisher) {
		this.book_publisher = book_publisher;
	}
	public List<Book> getBook() {
		return book;
	}
	public void setBook(List<Book> book) {
		this.book = book;
	}
	public Publisher(int publisher_id, String book_publisher, List<Book> book) {
		super();
		this.publisher_id = publisher_id;
		this.book_publisher = book_publisher;
		this.book = book;
	}
	
	  public Publisher() {
			super();
			// TODO Auto-generated constructor stub
		}
	@Override
	public String toString() {
		return "Publisher [publisher_id=" + publisher_id + ", book_publisher=" + book_publisher + ", book=" + book
				+ "]";
	}

//
// @OneToMany(mappedBy="publishers")
////	private List<Book> books;


    
}