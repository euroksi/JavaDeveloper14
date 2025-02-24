package com.example.demo.todolist.model.service;

import com.example.todolist.model.Note;

import java.util.List;
import java.util.Optional;

public interface NoteService {

    List<Note> getAllNotes();
    Optional<Note> getNoteById(Long id);
    Note createNote(Note note);
    Note updateNote(Long id, Note noteDetails);
    void deleteNote(Long id);
    void deleteAllNotes();
}