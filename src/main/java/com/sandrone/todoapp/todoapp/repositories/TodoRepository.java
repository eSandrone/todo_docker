package com.sandrone.todoapp.todoapp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sandrone.todoapp.todoapp.entities.Todo;

@Repository
public interface TodoRepository extends JpaRepository<Todo, Long> {

}
