package com.app.todo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.app.todo.entity.Todo;

@Repository
public interface TodoRepository extends MongoRepository<Todo, String>{
	
}
