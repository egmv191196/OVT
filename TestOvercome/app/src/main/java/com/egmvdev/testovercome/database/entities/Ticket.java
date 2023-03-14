package com.egmvdev.testovercome.database.entities;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Ticket {
    @PrimaryKey(autoGenerate = true)
    public int idTicket;
    public String titulo;
    public String fecha;
    public String nombre;
    public String equipoResponsable;
    public int tipoIncidencia;
    public int gravedad;
    public double version;
    public String descripcionProblema;
}
