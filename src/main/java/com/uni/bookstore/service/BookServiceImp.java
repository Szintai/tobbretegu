package com.uni.bookstore.service;

import com.uni.bookstore.exception.NoResourceException;
import com.uni.bookstore.model.Book;
import com.uni.bookstore.repository.BookRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookServiceImp implements BookService {

	private final BookRepository bookRepository;

	public BookServiceImp(BookRepository bookRepository) {
		this.bookRepository = bookRepository;
	}

	@Override
	public Book save(Book book) {
		return bookRepository.save(book);
	}

	@Override
	public List<Book> saveAll(List<Book> books) {
		return bookRepository.saveAll(books);
	}

	@Override
	public Book findById(Long id) {
		Optional<Book> optionalBook = bookRepository.findById(id);

		return optionalBook.map(o -> optionalBook.get())
				.orElseThrow(NoResourceException::new);
	}

	@Override
	public List<Book> findAll() {
		return bookRepository.findAll();
	}

	@Override
	public void deleteById(Long id) {
		bookRepository.deleteById(id);
	}

	
}
