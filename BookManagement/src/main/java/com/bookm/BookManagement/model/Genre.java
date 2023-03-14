package com.bookm.BookManagement.model;


import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
//import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
//import javax.persistence.ManyToMany;
//import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="book_genre")
public class Genre {

	

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	private int genre_id;
    private String book_genre;
    
	  @OneToMany(mappedBy = "genre", fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
  	 @JsonIgnore
	  private List<Book> book;

	public int getGenre_id() {
		return genre_id;
	}

	public void setGenre_id(int genre_id) {
		this.genre_id = genre_id;
	}

	public String getBook_genre() {
		return book_genre;
	}

	public void setBook_genre(String book_genre) {
		this.book_genre = book_genre;
	}

	public List<Book> getBook() {
		return book;
	}

	public void setBook(List<Book> book) {
		this.book = book;
	}

	public Genre() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Genre(int genre_id, String book_genre, List<Book> book) {
		super();
		this.genre_id = genre_id;
		this.book_genre = book_genre;
		this.book = book;
	}
	@Override
	public String toString() {
		return "Genre [genre_id=" + genre_id + ", book_genre=" + book_genre + ", book=" + book + "]";
	}

//    
//    @OneToMany(mappedBy="genres")
//  	private List<Book> books = new ArrayList<>();

	
	
    
}