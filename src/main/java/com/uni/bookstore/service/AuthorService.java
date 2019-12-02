package com.uni.bookstore.service;

import java.util.List;

import com.uni.bookstore.model.Author;

public interface AuthorService {
	
	Author save(Author author);
	
	List<Author> saveAll(List<Author> authors);
	
	Author findById(Long id);
	
	List<Author> findAll();
	
	void deleteById(Long id);
	

}
