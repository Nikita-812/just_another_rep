package com.example.recognitiontext;

import android.app.Application;

import androidx.room.Room;

public class App extends Application {
    private static App instance;
    private AppDatabase instanceDatabase = null;

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
    }
    public static AppDatabase getAppDatabaseInstance(){
        if(instance.instanceDatabase == null){
            instance.instanceDatabase = Room.databaseBuilder(instance.getApplicationContext(),
                    AppDatabase.class,
                    "database.db")
                    .build();
        }
        return instance.instanceDatabase;
    }
}
