package com.example.demo.todolist.model.service;

import com.example.demo.todolist.exception.NoteNotFoundException;
import com.example.todolist.model.Note;
import com.example.demo.todolist.model.repository.NoteRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NoteServiceImpl implements NoteService {

    private final NoteRepository noteRepository;

    public NoteServiceImpl(NoteRepository noteRepository) {
        this.noteRepository = noteRepository;
    }

    @Override
    public List<Note> getAllNotes() {
        return noteRepository.findAll();
    }

    @Override
    public Optional<Note> getNoteById(Long id) {
        return noteRepository.findById(id);
    }

    @Override
    public Note createNote(Note note) {
        return noteRepository.save(note);
    }

    @Override
    public Note updateNote(Long id, Note noteDetails) {
        Note note = noteRepository.findById(id)
                .orElseThrow(() -> new NoteNotFoundException(id));

        note.setTitle(noteDetails.getTitle());
        note.setContent(noteDetails.getContent());

        return noteRepository.save(note);
    }

    @Override
    public void deleteNote(Long id) {
        if (!noteRepository.existsById(id)) {
            throw new NoteNotFoundException(id);
        }
        noteRepository.deleteById(id);
    }

    @Override
    public void deleteAllNotes() {
        noteRepository.deleteAll();
    }
}