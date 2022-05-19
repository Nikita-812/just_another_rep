package com.example.recognitiontext;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

@Entity
public class TextDb {
    @PrimaryKey(autoGenerate = true)
    public long id;
    public final String text;

    public TextDb(long id, String text) {
        this.id = id;
        this.text = text;
    }
    @Ignore
    public TextDb(String text) {
        this(0,text);
    }
}
