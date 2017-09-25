package com.app.todo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.app.todo.entity.Task;
import com.app.todo.entity.Todo;
import com.app.todo.service.TodoService;

@RestController
public class TodoController {

	@Autowired
	private TodoService todoService;
	
	@PostMapping("/todos")
	public void createTodo(@RequestBody Todo todo) {
		todoService.createTodo(todo);
	}
	
	@GetMapping("/todos")
	public List<Todo> getTodos() {
		return todoService.getTodos();
	}
	
	@DeleteMapping("/todos/{id}")
	public void deleteTodo(@PathVariable String id) {
		todoService.deleteTodo(id);
	}
	
	@PostMapping("/todos/{todoId}/tasks")
	public void createTask(@PathVariable String todoId, @RequestBody Task task) {
		todoService.addTask(todoId, task);
	}
	
	@DeleteMapping("/todos/{todoId}/tasks/{taskId}")
	public void deleteTask(@PathVariable String todoId, @PathVariable String taskId) {
		todoService.deleteTask(todoId, taskId);
	}
	
	@PatchMapping("/todos/{todoId}/tasks/{taskId}")
	public void updateTask(@PathVariable String todoId, @PathVariable String taskId, @RequestBody Task task) {
		todoService.updateTask(todoId, taskId, task);
	}
}
