package com.app.todo.entity;

import java.util.UUID;

import org.springframework.data.annotation.Id;

public class Task {

	@Id private UUID id;
	private String note;
	private STATUS status;	
	
	public UUID getId() {
		return id;
	}
	public void setId(UUID id) {
		this.id = id;
	}
	
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
	
	public STATUS getStatus() {
		return status;
	}
	public void setStatus(STATUS status) {
		this.status = status;
	}
	
	public static Task getNewTask(Task note) {
		Task task = new Task();
		task.setId(UUID.randomUUID());
		task.setStatus(STATUS.PENDING);
		task.setNote(note.getNote());
		return task;
	}
	
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Task && obj != null) {
			Task task = (Task)obj;
			return this.id.equals(task.getId());
		}
		return false;
	}
	
	@Override
	public String toString() {
		return id.toString() + " - " + status + " - " + note;
	}
}
