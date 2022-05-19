package com.example.recognitiontext;

import androidx.room.ColumnInfo;

public class ItemNote{
    @ColumnInfo(name = "text")
    final String name;

    public String getName() {
        if (name != null) return name;
        else return "no text on this picture";
    }

    public ItemNote(String name) {
        this.name = name;
    }

    public TextDb toTextdb(){
        return new TextDb(name);
    }
}
