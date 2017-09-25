package com.app.todo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.app.todo.entity.Note;
import com.app.todo.service.NoteService;

@RestController
public class NoteController {

	@Autowired
	private NoteService noteService;	
	
	@GetMapping("/notes")
	public List<Note> getNotes() {
		return noteService.getNotes();
	}
	
	@PostMapping("/notes")
	public void createNote(@RequestBody Note note) {
		noteService.createNote(note);
	}
	
	@PutMapping("/notes")
	public void updateNote(@RequestBody Note note) {
		noteService.updateNote(note);
	}
	
	@DeleteMapping("/notes/{id}")
	public void deleteNote(@PathVariable String id) {
		noteService.deleteNote(id);
	}	
}
