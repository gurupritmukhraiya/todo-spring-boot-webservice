package com.app.todo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.todo.entity.Note;
import com.app.todo.repository.NoteRepository;

@Service
public class NoteService {

	@Autowired
	private NoteRepository noteRepository;
	
	public List<Note> getNotes(){
		return noteRepository.findAll();
	}
	
	public void createNote(Note note) {		
		noteRepository.save(note);
	}
	
	public void updateNote(Note note) {
		noteRepository.save(note);
	}
	
	public void deleteNote(String id) {
		noteRepository.delete(id);
	}	
}
