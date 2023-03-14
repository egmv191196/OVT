package com.egmvdev.testovercome.database.db;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.egmvdev.testovercome.database.dao.ticketDAO;
import com.egmvdev.testovercome.database.entities.Ticket;

@Database(entities = {Ticket.class}, version = 1)
public abstract class database extends RoomDatabase {
    public abstract ticketDAO ticketDAO();
}
