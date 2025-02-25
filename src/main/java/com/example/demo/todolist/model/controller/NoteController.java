package com.example.demo.todolist.model.controller;

import com.example.demo.model.Note;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@Controller
@RequestMapping("/note")
public class NoteController {

    private final List<Note> notes = new ArrayList<>();
    private final AtomicLong idCounter = new AtomicLong(1);

    @GetMapping("/list")
    public String listNotes(Model model) {
        model.addAttribute("notes", notes);
        return "note/list";
    }

    @PostMapping("/delete")
    public String deleteNote(@RequestParam Long id) {
        notes.removeIf(note -> note.getId().equals(id));
        return "redirect:/note/list";
    }

    @GetMapping("/edit")
    public String editNoteForm(@RequestParam Long id, Model model) {
        Note note = notes.stream()
                .filter(n -> n.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Note not found"));
        model.addAttribute("note", note);
        return "note/edit";
    }

    @PostMapping("/edit")
    public String editNote(@ModelAttribute Note updatedNote) {
        notes.replaceAll(note -> note.getId().equals(updatedNote.getId()) ? updatedNote : note);
        return "redirect:/note/list";
    }
}