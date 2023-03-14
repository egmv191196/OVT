package com.egmvdev.testovercome.ticketarchivados.viewmodel;

import android.content.Context;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.egmvdev.testovercome.database.entities.Ticket;
import com.egmvdev.testovercome.ticketarchivados.repository.ticketArchivadosRepository;

import java.util.List;

public class ticketArchivadosViewModel extends ViewModel {
    private ticketArchivadosRepository repository;

    private MutableLiveData<List<Ticket>> listaTicketArchivados;

    public ticketArchivadosViewModel(Context context){
        repository = new ticketArchivadosRepository(context);
        this.listaTicketArchivados = new MutableLiveData<>();
    }

    public LiveData<List<Ticket>> getTicketsArchivados(){
        return listaTicketArchivados;
    }

    public void obtenerTicketsArchivados(){
        listaTicketArchivados.setValue(repository.obtenerTicketsArchivados());
    }
}
