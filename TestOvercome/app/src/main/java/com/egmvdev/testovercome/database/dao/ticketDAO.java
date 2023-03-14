package com.egmvdev.testovercome.database.dao;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Update;

import com.egmvdev.testovercome.database.entities.Ticket;

@Dao
public interface ticketDAO {
    @Insert
    void insertTicket(Ticket ticket);

    @Update
    void updateTicket(Ticket ticket);
}
