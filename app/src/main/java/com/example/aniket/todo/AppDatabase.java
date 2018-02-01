package com.example.aniket.todo;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

/**
 * Created by aniket on 01/02/18.
 */

@Database(entities = {Notes.class},version = 1)
public abstract class AppDatabase extends RoomDatabase {
    public abstract NotesDAO notesDAO();

}
