package com.example.demo.todolist.model.service;

public class NoteNotFoundException extends RuntimeException {
    public NoteNotFoundException(Long id) {
        super("Note with id " + id + " not found");
    }
}