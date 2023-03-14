package com.egmvdev.testovercome.main.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Adapter;

import com.egmvdev.testovercome.database.entities.Ticket;
import com.egmvdev.testovercome.databinding.ActivityMainBinding;
import com.egmvdev.testovercome.main.interfaces.OnItemClickListener;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity{
    private static final String TAG = MainActivity.class.getSimpleName();
    private ActivityMainBinding binding;

    private List<Ticket> lista = new ArrayList<>();
    private ticketItemAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        cargarVista();
    }

    public void cargarVista(){
        Ticket t1 = new Ticket();
        t1.idTicket = 001;
        t1.titulo = "Tarea 1";
        t1.gravedad = 1;
        t1.tipoIncidencia = 2;
        lista.add(t1);

        Ticket t2 = new Ticket();
        t2.idTicket = 002;
        t2.titulo = "Tarea 2";
        t2.gravedad = 1;
        t2.tipoIncidencia = 2;
        lista.add(t2);

        Ticket t3 = new Ticket();
        t3.idTicket = 003;
        t3.titulo = "Tarea 3";
        t3.gravedad = 1;
        t3.tipoIncidencia = 2;
        lista.add(t3);
        LinearLayoutManager verticalManager1 = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        binding.rvDoing.setLayoutManager(verticalManager1);
        binding.rvDoing.setHasFixedSize(true);
        adapter = new ticketItemAdapter(lista);
        binding.rvDoing.setAdapter(adapter);


        LinearLayoutManager verticalManager2 = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        binding.rvToDo.setLayoutManager(verticalManager2);
        binding.rvToDo.setHasFixedSize(true);
        adapter = new ticketItemAdapter(lista);
        binding.rvToDo.setAdapter(adapter);


        LinearLayoutManager verticalManager3 = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        binding.rvDone.setLayoutManager(verticalManager3);
        binding.rvDone.setHasFixedSize(true);
        adapter = new ticketItemAdapter(lista);
        binding.rvDone.setAdapter(adapter);
        adapter.notifyDataSetChanged();
    }

}