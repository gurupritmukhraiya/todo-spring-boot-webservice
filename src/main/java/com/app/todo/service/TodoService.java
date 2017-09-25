package com.app.todo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;import com.app.todo.entity.Task;
import com.app.todo.entity.Todo;
import com.app.todo.repository.TodoRepository;

@Service
public class TodoService {

	@Autowired
	private TodoRepository todoRepository;
	
	public void createTodo(Todo todo) {
		todoRepository.save(todo);
	}
	
	private Todo getTodo(String id) {
		return todoRepository.findOne(id);
	}
	
	public List<Todo> getTodos() {
		return todoRepository.findAll();
	}
	
	public void deleteTodo(String id) {
		todoRepository.delete(id);
	}

	public void addTask(String todoId, Task note) {
		Todo todo = getTodo(todoId);
		todo.getTasks().add(Task.getNewTask(note));
		todoRepository.save(todo);
	}

	public void deleteTask(String todoId, String taskId) {
		Todo todo = getTodo(todoId);
		todo.getTasks().removeIf(task -> task.getId().toString().equals(taskId));	
		todoRepository.save(todo);
	}

	public void updateTask(String todoId, String taskId, Task task) {
		Todo todo = getTodo(todoId);
		todo.getTasks().forEach(taskIn -> {
			if(taskIn.equals(task)) {
				taskIn.setStatus(task.getStatus());
				taskIn.setNote(task.getNote());
			}
		});
		
		todoRepository.save(todo);
	}
}
