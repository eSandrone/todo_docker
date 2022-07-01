package com.sandrone.todoapp.todoapp.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;

@Getter
@Entity
@Table(name = "todos")
public class Todo {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(nullable = false, length = 150)
	private String description;
	
	@Column(nullable = false)
	private boolean isCompleted;
	
	public Todo() {
		// TODO Auto-generated constructor stub
	}
	
	public Todo(long id, String description) {
		this.id = id;
		this.description = description;
		this.isCompleted = false;
	}
	

}
