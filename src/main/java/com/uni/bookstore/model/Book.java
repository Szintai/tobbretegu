package com.uni.bookstore.model;

//import lombok.Getter;
//import lombok.Setter;

import javax.persistence.*;

//@Getter
//@Setter
@Entity
@SequenceGenerator(name = "default_gen", sequenceName = "book_seq", allocationSize = 1)
@Table(name = "books", schema = "public")
public class Book extends BaseEntity {

	@Column(nullable = false, length = 13)
	private String isbn;

	@Column(nullable = false)
	private String title;

	@OneToOne
	@JoinColumn(name = "author_id", referencedColumnName = "id")
	private Author author;

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Author getAuthor() {
		return author;
	}

	public void setAuthor(Author author) {
		this.author = author;
	}

	
}
