package com.egmvdev.testovercome.addticket.viewmodel;

import android.content.Context;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.egmvdev.testovercome.addticket.repository.addTicketRepository;
import com.egmvdev.testovercome.database.entities.Ticket;

import java.util.List;

public class addTicketViewModel extends ViewModel {
    private addTicketRepository repository;

    private MutableLiveData<Boolean> saveExitoso;

    public addTicketViewModel(Context context){
        repository = new addTicketRepository(context);
        this.saveExitoso = new MutableLiveData<>();
    }

    public void addTicket(Ticket ticket){
        saveExitoso.setValue(repository.saveTicket(ticket));
    }

    public LiveData<Boolean> getSave(){
        return saveExitoso;
    }

}
