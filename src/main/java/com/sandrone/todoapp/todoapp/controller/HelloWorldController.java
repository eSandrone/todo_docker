package com.sandrone.todoapp.todoapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HelloWorldController {
	
	
	@GetMapping("")
	public String index(Model model) {
		model.addAttribute("title", "TODO List");
		return "index";
	}
	
	@GetMapping("/hello")
	public String hello(Model model) {
		model.addAttribute("title", "toDo");
		return "hello";
	}
}
