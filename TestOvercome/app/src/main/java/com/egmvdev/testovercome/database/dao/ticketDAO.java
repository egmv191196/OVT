package com.egmvdev.testovercome.database.dao;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.egmvdev.testovercome.database.entities.Ticket;

import java.util.List;

@Dao
public interface ticketDAO {
    @Insert
    void insertTicket(Ticket ticket);

    @Update
    void updateTicket(Ticket ticket);

    @Query("SELECT * FROM Ticket WHERE estado = 1")
    List<Ticket> obtenerTicketsToDo();

    @Query("SELECT * FROM Ticket WHERE estado = 2")
    List<Ticket> obtenerTicketsDoing();

    @Query("SELECT * FROM Ticket WHERE estado = 3")
    List<Ticket> obtenerTicketsDone();

    @Query("SELECT * FROM Ticket WHERE estado = 0")
    List<Ticket> obtenerTicketsArchivados();
}
