package com.example.mynotes.controller;

import com.example.mynotes.model.Note;
import com.example.mynotes.model.NoteRequest;
import com.example.mynotes.repository.NotesRepository;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class CreateNoteController {

    private final NotesRepository notesRepository;

    public CreateNoteController(NotesRepository notesRepository) {
        this.notesRepository = notesRepository;
    }


    @PostMapping("/create-new-note")
    public void createNewNote(@RequestBody NoteRequest note, Authentication authentication) {
        String username = authentication.getName();
        notesRepository.createNote(username, note.getNote());
    }
}
