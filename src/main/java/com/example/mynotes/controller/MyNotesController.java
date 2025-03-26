package com.example.mynotes.controller;

import com.example.mynotes.exception.UnauthorizedAccessException;
import com.example.mynotes.model.AppUser;
import com.example.mynotes.model.ErrorDetails;
import com.example.mynotes.model.Note;
import com.example.mynotes.repository.AccountsRepository;
import com.example.mynotes.repository.NotesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
public class MyNotesController {

    private final NotesRepository notesRepository;

    public MyNotesController(NotesRepository notesRepository) {
        this.notesRepository = notesRepository;
    }

    @GetMapping("/mynotes")
    public Iterable<Note> findAll(Authentication authentication) {
        return notesRepository.findAll(authentication.getName());
    }

    @GetMapping("/mynotes/{noteId}")
    public Note findNote(@PathVariable int noteId, Authentication authentication) {
        // Check if the current user is allowed to view this note.
        // If not respond with HTTP code 401 Unauthorized.
        if (authentication.getName().equals(notesRepository.findNoteById(noteId).getUsername())) {
            return notesRepository.findNoteById(noteId);
        } else {
            throw new UnauthorizedAccessException();
        }
    }

    @DeleteMapping("/mynotes/{noteId}")
    public void deleteNote(@PathVariable int noteId, Authentication authentication) {
        // Check if the current user is allowed to delete this note.
        // If not respond with HTTP code 401 Unauthorized.
        if (authentication.getName().equals(notesRepository.findNoteById(noteId).getUsername())) {
            notesRepository.delete(noteId, authentication.getName());
        } else {
            throw new UnauthorizedAccessException();
        }
    }

}
