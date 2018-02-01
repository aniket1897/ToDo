package com.example.aniket.todo;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import com.example.aniket.todo.Notes;

import java.util.List;

/**
 * Created by aniket on 01/02/18.
 */
@Dao
public interface NotesDAO {
    @Query("SELECT * FROM notes")
    List<Notes> getAllNotes();

    @Insert
    void insertAll(Notes... notes);


}
