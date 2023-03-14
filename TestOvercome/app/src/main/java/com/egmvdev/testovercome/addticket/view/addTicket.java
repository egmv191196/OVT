package com.egmvdev.testovercome.addticket.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.res.Resources;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import com.egmvdev.testovercome.R;
import com.egmvdev.testovercome.addticket.viewmodel.addTicketViewModel;
import com.egmvdev.testovercome.database.entities.Ticket;
import com.egmvdev.testovercome.databinding.ActivityAddTicketBinding;

public class addTicket extends AppCompatActivity {
    private ActivityAddTicketBinding binding;
    private addTicketViewModel viewModel;
    private int equipoID = -1;
    private int incidenciaID = -1;
    private int gravedadID = -1;
    private String[] tipoIncidencia;
    String[] equipoResponsable;
    String[] gravedadArray;
    Ticket ticket = new Ticket();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityAddTicketBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        viewModel = new addTicketViewModel(this);
        addActions();
        cargarDatos();
        addObservers();
        ticket.idTicket = 0;
        ticket.estado = 1;

    }

    public void addActions(){
        binding.btnAddTicket.setOnClickListener(v->{
            if (validarDatosObligatorios()){
                obtenerDatosSecundarios();
                viewModel.addTicket(ticket);
            } else {
                Toast.makeText(this, "Por favor llena todos los datos obligatorios", Toast.LENGTH_LONG).show();
            }

        });

        binding.aCTEquipoResponsable.setOnItemClickListener((parent, view, position, id) -> {
            equipoID = position;
        });

        binding.aCTTipoIncidencia.setOnItemClickListener((parent, view, position, id) -> {
            incidenciaID = position;
        });

        binding.aCTTipoGravedad.setOnItemClickListener((parent, view, position, id) -> {
            gravedadID = position;
        });

    }
    public void addObservers(){
        viewModel.getSave().observe(this, this::resultadoSave);
    }

    public void cargarDatos(){
        Resources res = getResources();
        tipoIncidencia = res.getStringArray(R.array.tipoIncidencia);
        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, tipoIncidencia);
        binding.aCTTipoIncidencia.setAdapter(adapter);

        equipoResponsable = res.getStringArray(R.array.equipoResponsable);
        ArrayAdapter adapter1 = new ArrayAdapter(this, android.R.layout.simple_list_item_1, equipoResponsable);
        binding.aCTEquipoResponsable.setAdapter(adapter1);

        gravedadArray = res.getStringArray(R.array.gravedadArray);
        ArrayAdapter adapter2 = new ArrayAdapter(this, android.R.layout.simple_list_item_1, gravedadArray);
        binding.aCTTipoGravedad.setAdapter(adapter2);
    }

    public boolean validarDatosObligatorios(){
        if (binding.tiTituloTicket.getEditText().getText().length() > 0){
            ticket.titulo = binding.tiTituloTicket.getEditText().getText().toString();
            if (binding.tiNombreResponsable.getEditText().getText().length() > 0) {
                ticket.nombre = binding.tiNombreResponsable.getEditText().getText().toString();
                if (binding.tiDescripcion.getEditText().getText().length() > 0) {
                    ticket.descripcionProblema = binding.tiDescripcion.getEditText().getText().toString();
                    if (incidenciaID != -1 && gravedadID != -1) {
                        ticket.gravedad = gravedadID;
                        ticket.tipoIncidencia = incidenciaID;
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public void obtenerDatosSecundarios(){
        if (binding.tiVersion.getEditText().getText().length() > 0) {
            ticket.version = Double.parseDouble(binding.tiVersion.getEditText().getText().toString());
        }
        if (equipoID != -1){
            ticket.equipoResponsable = equipoID;
        }
    }

    public void resultadoSave(boolean ban){
        if (ban){
            super.finish();
        } else{
            Toast.makeText(this, "Error al guardar el ticket", Toast.LENGTH_LONG).show();
        }
    }
}