package com.uni.bookstore.config;

import com.thedeanda.lorem.LoremIpsum;
import com.uni.bookstore.model.Author;
import com.uni.bookstore.model.Book;
import com.uni.bookstore.service.AuthorService;
import com.uni.bookstore.service.BookService;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Component
@Transactional
public class Bootstrap implements ApplicationListener<ContextRefreshedEvent> {

	private final BookService bookService;
	private final AuthorService authorService;


	public Bootstrap(BookService bookService, AuthorService authorService) {
		this.bookService = bookService;
		this.authorService=authorService;
	}

	@Override
	public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
		initBooksIfNotExist();
	}

	public void initBooksIfNotExist() {
		if(CollectionUtils.isEmpty(bookService.findAll())) {
			List<Book> books = new ArrayList<>();

			for(int i = 0; i < 10; ++i) {
				Book book = new Book();
				book.setIsbn(UUID.randomUUID().toString().substring(0, 13));
				book.setTitle(LoremIpsum.getInstance().getTitle(2, 6));
				books.add(book);
				Author author=new Author();
				author.setName(LoremIpsum.getInstance().getName());
				book.setAuthor(author);
				authorService.save(author);
			}

			bookService.saveAll(books);
		}
	}
}
