package com.egmvdev.testovercome.ticketarchivados.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.Bundle;

import com.egmvdev.testovercome.database.entities.Ticket;
import com.egmvdev.testovercome.databinding.ActivityTicketsArchivadosBinding;
import com.egmvdev.testovercome.main.view.ticketItemAdapter;
import com.egmvdev.testovercome.ticketarchivados.viewmodel.ticketArchivadosViewModel;

import java.util.List;

public class ticketsArchivados extends AppCompatActivity {
    private ActivityTicketsArchivadosBinding binding;

    private ticketArchivadosViewModel viewModel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityTicketsArchivadosBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        viewModel = new ticketArchivadosViewModel(this);
        createObserver();
    }

    @Override
    protected void onResume() {
        super.onResume();
        cargarVista();

    }
    public void cargarVista(){
        viewModel.obtenerTicketsArchivados();
    }

    public void createObserver() {
       viewModel.getTicketsArchivados().observe(this, this::cargarVistaArchivados);
    }

    public void cargarVistaArchivados(List<Ticket> lista) {
        LinearLayoutManager verticalManager1 = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        binding.rvTicketsArchivados.setLayoutManager(verticalManager1);
        binding.rvTicketsArchivados.setHasFixedSize(true);
        ticketItemAdapter adapter3;
        adapter3 = new ticketItemAdapter(lista);
        binding.rvTicketsArchivados.setAdapter(adapter3);
        adapter3.notifyDataSetChanged();
    }
}