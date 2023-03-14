package com.egmvdev.testovercome.main.repository;

import android.content.Context;

import com.egmvdev.testovercome.database.conexionDB;
import com.egmvdev.testovercome.database.entities.Ticket;

import java.util.List;

public class mainRepository extends conexionDB {

    public mainRepository(Context context){
        this.context = context;
        cargarBD();
    }

    public List<Ticket> obtenerTicketsToDo(){
        return db.ticketDAO().obtenerTicketsToDo();
    }
    public List<Ticket> obtenerTicketsDoing(){
        return db.ticketDAO().obtenerTicketsDoing();
    }
    public List<Ticket> obtenerTicketsDone(){
        return db.ticketDAO().obtenerTicketsDone();
    }
    public List<Ticket> obtenerTicketsArchivados(){
        return db.ticketDAO().obtenerTicketsArchivados();
    }
}
