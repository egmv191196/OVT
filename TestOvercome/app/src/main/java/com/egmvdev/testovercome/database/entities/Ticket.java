package com.egmvdev.testovercome.database.entities;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.io.Serializable;

@Entity
public class Ticket implements Serializable {
    @PrimaryKey(autoGenerate = true)
    public int idTicket;
    public int estado;
    public String titulo;
    public String fecha;
    public String nombre;
    public int equipoResponsable;
    public int tipoIncidencia;
    public int gravedad;
    public double version;
    public String descripcionProblema;
}
