package com.egmvdev.testovercome.main.viewmodel;

import android.content.Context;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.egmvdev.testovercome.database.entities.Ticket;
import com.egmvdev.testovercome.main.repository.mainRepository;

import java.util.List;

public class mainViewModel extends ViewModel {

    private mainRepository repository;

    private MutableLiveData<List<Ticket>> listaTicketToDo;
    private MutableLiveData<List<Ticket>> listaTicketDoing;
    private MutableLiveData<List<Ticket>> listaTicketDone;
    private MutableLiveData<List<Ticket>> listaTicketArchivados;

    public mainViewModel(Context context){
        repository = new mainRepository(context);
        this.listaTicketToDo = new MutableLiveData<>();
        this.listaTicketDoing = new MutableLiveData<>();
        this.listaTicketDone = new MutableLiveData<>();
        this.listaTicketArchivados = new MutableLiveData<>();
    }

    public LiveData<List<Ticket>> getTicketsToDo(){
        return listaTicketToDo;
    }

    public void obtenerTicketsToDo(){
        listaTicketToDo.setValue(repository.obtenerTicketsToDo());
    }

    public LiveData<List<Ticket>> getTicketsDoing(){
        return listaTicketDoing;
    }

    public void obtenerTicketsDoing(){
        listaTicketDoing.setValue(repository.obtenerTicketsDoing());
    }

    public LiveData<List<Ticket>> getTicketsDone(){
        return listaTicketDone;
    }

    public void obtenerTicketsDone(){
        listaTicketDone.setValue(repository.obtenerTicketsDone());
    }

    public LiveData<List<Ticket>> getTicketsArchivados(){
        return listaTicketArchivados;
    }

    public void obtenerTicketsArchivados(){
        listaTicketArchivados.setValue(repository.obtenerTicketsArchivados());
    }
}
