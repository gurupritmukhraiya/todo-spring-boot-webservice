package com.app.todo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.app.todo.entity.Note;

@Repository
public interface NoteRepository extends MongoRepository<Note, String>{

}
