package com.uni.bookstore.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.uni.bookstore.model.Author;
import com.uni.bookstore.service.AuthorService;

@Controller
public class AuthorController {

	private final AuthorService authorService;
	
	
	public AuthorController(AuthorService authorService) {
		this.authorService=authorService;
	}
	
	@GetMapping(value = "/authors")
	public String main(Model model) {
		model.addAttribute("authors", authorService.findAll());
		
		return "author/main";
	}
	
	@PostMapping(value = "/authors/{id}")
	public String update(@PathVariable("id") Long id, Model model, @ModelAttribute Author author) {
		model.addAttribute("author", authorService.save(author));
		
		return "author/edit";
		
	}
	
	@GetMapping(value="/authors/{id}")
	public String find(@PathVariable("id") Long id, Model model) {
		model.addAttribute("author", authorService.findById(id));
		
		return "author/edit";
		
	}
	
	@GetMapping(value = "/authors/{id}/delete")
	public String deleteById(@PathVariable("id") Long id) {
		authorService.deleteById(id);
		
		return "redirect:/authors";
		
	}
	
	
}
