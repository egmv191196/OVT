package com.egmvdev.testovercome.ticketarchivados.repository;

import android.content.Context;

import com.egmvdev.testovercome.database.conexionDB;
import com.egmvdev.testovercome.database.entities.Ticket;

import java.util.List;

public class ticketArchivadosRepository extends conexionDB {

    public ticketArchivadosRepository(Context context){
        this.context = context;
        cargarBD();
    }
    public List<Ticket> obtenerTicketsArchivados(){
        return db.ticketDAO().obtenerTicketsArchivados();
    }
}
