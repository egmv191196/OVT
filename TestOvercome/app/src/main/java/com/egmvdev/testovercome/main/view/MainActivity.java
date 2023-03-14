package com.egmvdev.testovercome.main.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.content.Intent;
import android.os.Bundle;

import com.egmvdev.testovercome.addticket.view.addTicket;
import com.egmvdev.testovercome.database.entities.Ticket;
import com.egmvdev.testovercome.databinding.ActivityMainBinding;
import com.egmvdev.testovercome.main.viewmodel.mainViewModel;
import com.egmvdev.testovercome.ticketarchivados.view.ticketsArchivados;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity{
    private static final String TAG = MainActivity.class.getSimpleName();
    private ActivityMainBinding binding;

    private mainViewModel viewModel;

    private List<Ticket> lista = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        viewModel = new mainViewModel(this);
        addActions();
        createObserver();
    }

    @Override
    protected void onResume() {
        super.onResume();
        cargarVista();
    }

    public void cargarVista(){
        viewModel.obtenerTicketsToDo();
        viewModel.obtenerTicketsDoing();
        viewModel.obtenerTicketsDone();
    }

    public void addActions(){
        binding.btnAdd.setOnClickListener(v->{
            startActivity(new Intent(this, addTicket.class));
        });
        binding.btnMostrarArchivdos.setOnClickListener(v->{
            startActivity(new Intent(this, ticketsArchivados.class));
        });
    }

    public void createObserver() {
        viewModel.getTicketsToDo().observe(this, this::cargarVistaToDo);
        viewModel.getTicketsDoing().observe(this, this::cargarVistaDoing);
        viewModel.getTicketsDone().observe(this, this::cargarVistaDone);
//        viewModel.getTicketsArchivados().observe(this, this::mostrarCuentas);
    }


    public void cargarVistaToDo(List<Ticket> lista){
        LinearLayoutManager verticalManager2 = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        binding.rvToDo.setLayoutManager(verticalManager2);
        binding.rvToDo.setHasFixedSize(true);
        ticketItemAdapter adapter1;
        adapter1 = new ticketItemAdapter(lista);
        binding.rvToDo.setAdapter(adapter1);
        adapter1.notifyDataSetChanged();
    }

    public void cargarVistaDoing(List<Ticket> lista) {
        LinearLayoutManager verticalManager1 = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        binding.rvDoing.setLayoutManager(verticalManager1);
        binding.rvDoing.setHasFixedSize(true);
        ticketItemAdapter adapter2;
        adapter2 = new ticketItemAdapter(lista);
        binding.rvDoing.setAdapter(adapter2);
        adapter2.notifyDataSetChanged();
    }

    public void cargarVistaDone(List<Ticket> lista) {
        LinearLayoutManager verticalManager1 = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        binding.rvDone.setLayoutManager(verticalManager1);
        binding.rvDone.setHasFixedSize(true);
        ticketItemAdapter adapter3;
        adapter3 = new ticketItemAdapter(lista);
        binding.rvDone.setAdapter(adapter3);
        adapter3.notifyDataSetChanged();
    }
}