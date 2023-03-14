package com.egmvdev.testovercome.detailticket.repository;

import android.content.Context;

import com.egmvdev.testovercome.database.conexionDB;
import com.egmvdev.testovercome.database.entities.Ticket;

public class detailTicketRepository extends conexionDB {
    public detailTicketRepository(Context context){
        this.context = context;
        cargarBD();
    }

    public boolean updateTicket(Ticket ticket){
        db.ticketDAO().updateTicket(ticket);
        return true;
    }

}
