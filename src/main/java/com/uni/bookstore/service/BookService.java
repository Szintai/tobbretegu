package com.uni.bookstore.service;

import com.uni.bookstore.model.Book;

import java.util.List;

public interface BookService {

	Book save(Book book);

	List<Book> saveAll(List<Book> books);

	Book findById(Long id);

	List<Book> findAll();

	void deleteById(Long id);
	
	
}
