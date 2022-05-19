package com.example.recognitiontext;

import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = {TextDb.class},version = 1)
public abstract class AppDatabase extends RoomDatabase {
    public abstract TextDao textDao();
}
