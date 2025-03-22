package com.example.mynotes.repository;

import com.example.mynotes.model.Note;
import org.springframework.data.jdbc.repository.query.Modifying;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.relational.core.mapping.Table;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface NotesRepository extends CrudRepository<Note, Integer> {

    @Modifying
    @Query("INSERT INTO notes VALUES (DEFAULT, :username, :note);")
    int createNote(@Param("username") String username, @Param("note") String note);

    @Query("SELECT * FROM notes WHERE username = :username")
    Iterable<Note> findAll(@Param("username") String username);

    @Query("SELECT * FROM notes WHERE note_id = :noteId")
    Note findNoteById(@Param("noteId") int noteId);

    @Modifying
    @Query("DELETE FROM notes WHERE note_id = :noteId AND username = :username")
    void delete(@Param("noteId") int noteId, @Param("username") String username);


}
