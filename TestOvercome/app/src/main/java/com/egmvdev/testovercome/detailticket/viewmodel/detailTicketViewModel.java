package com.egmvdev.testovercome.detailticket.viewmodel;

import android.content.Context;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.egmvdev.testovercome.database.entities.Ticket;
import com.egmvdev.testovercome.detailticket.repository.detailTicketRepository;

import java.util.List;

public class detailTicketViewModel extends ViewModel {
    private detailTicketRepository repository;

    private MutableLiveData<Boolean> respuesta;

    public detailTicketViewModel(Context context){
        repository = new detailTicketRepository(context);
        this.respuesta = new MutableLiveData<>();
    }

    public LiveData<Boolean> getRespuesta(){
        return respuesta;
    }

    public void actualizarTicket(Ticket ticket){
        respuesta.setValue(repository.updateTicket(ticket));
    }

}
