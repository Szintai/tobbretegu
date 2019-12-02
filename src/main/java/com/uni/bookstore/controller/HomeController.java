package com.uni.bookstore.controller;

import com.thedeanda.lorem.LoremIpsum;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

	@GetMapping(value = "/")
	public String main(Model model) {
		model.addAttribute("title", LoremIpsum.getInstance().getTitle(1, 6));
		model.addAttribute("msg", LoremIpsum.getInstance().getParagraphs(2, 9));

		return "home/main";
	}
}
