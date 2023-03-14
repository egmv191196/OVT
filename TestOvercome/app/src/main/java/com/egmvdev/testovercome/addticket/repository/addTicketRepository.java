package com.egmvdev.testovercome.addticket.repository;

import android.content.Context;
import android.util.Log;

import com.egmvdev.testovercome.database.conexionDB;
import com.egmvdev.testovercome.database.entities.Ticket;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class addTicketRepository extends conexionDB {
    public addTicketRepository(Context context){
        this.context = context;
        cargarBD();
    }

    public boolean saveTicket(Ticket ticket){
        Date fecha = new Date(Calendar.getInstance().getTimeInMillis());
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
        ticket.fecha = formatter.format(fecha);
        Log.e("addTicketRepository", "Fecha en formato "+ ticket.fecha);
        db.ticketDAO().insertTicket(ticket);
        return true;
    }
}
