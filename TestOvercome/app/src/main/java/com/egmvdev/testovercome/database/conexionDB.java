package com.egmvdev.testovercome.database;

import android.content.Context;

import androidx.room.Room;

import com.egmvdev.testovercome.database.db.database;

public class conexionDB {
    private static final String TAG = conexionDB.class.getSimpleName();

    public database db = null;
    public Context context = null;

    public void cargarBD() {
        if (db == null) {
            db = Room.databaseBuilder(context, database.class, "TicketDB").allowMainThreadQueries().build();
        }
    }

}
