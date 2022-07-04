package com.sandrone.todoapp.todoapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.sandrone.todoapp.todoapp.entities.Todo;
import com.sandrone.todoapp.todoapp.repositories.TodoRepository;


@RestController
public class TodoRestController {
	
	@Autowired
	private TodoRepository todoRepo;
	
	@GetMapping("/todos")
	public List<Todo> getAll(){
		return todoRepo.findAll();
	}

	@PostMapping(value = "/addTodo", consumes = "application/json")
	public Todo addOne(@RequestBody Todo todo) { return todoRepo.save(todo); };

	@DeleteMapping("/deleteTodo/{id}")
	public void remove(@PathVariable("id") long id) { todoRepo.deleteById(id); }
}
