package com.egmvdev.testovercome.detailticket.view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import com.egmvdev.testovercome.database.entities.Ticket;
import com.egmvdev.testovercome.databinding.ActivityDetailTicketBinding;
import com.egmvdev.testovercome.detailticket.viewmodel.detailTicketViewModel;

public class detailTicket extends AppCompatActivity {
    private ActivityDetailTicketBinding binding;
    Ticket ticket;

    private detailTicketViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityDetailTicketBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        viewModel = new detailTicketViewModel(this);
        cargarDatos();
        addActions();
        createObservers();
    }

    public void createObservers(){
        viewModel.getRespuesta().observe(this, this::respuestaActualizar);
    }

    public void respuestaActualizar(boolean ban){
        if (ban){
            super.finish();
        } else {

        }
    }

    public void addActions(){
        binding.btnDoing.setOnClickListener(v->{
            if (ticket != null){
                ticket.estado = 2;
                viewModel.actualizarTicket(ticket);
            }
        });

        binding.btnDone.setOnClickListener(v->{
            if (ticket != null){
                ticket.estado = 3;
                viewModel.actualizarTicket(ticket);
            }
        });

        binding.btnArchivar.setOnClickListener(v->{
            if (ticket != null){
                ticket.estado = 0;
                viewModel.actualizarTicket(ticket);
            }
        });
    }

    public void cargarDatos(){
        Bundle extras = getIntent().getExtras();
        if(extras != null) {
            ticket = (Ticket) extras.get("Ticket");

            binding.tvTitulo.setText(ticket.titulo);

            String estado = "";
            switch (ticket.estado){
                case 0:
                    estado = "Archivado";
                    binding.btnArchivar.setVisibility(View.GONE);
                    binding.btnDoing.setVisibility(View.GONE);
                    binding.btnDone.setVisibility(View.GONE);
                    break;
                case 1:
                    estado = "ToDo";
                    binding.btnDone.setVisibility(View.GONE);
                    break;
                case 2:
                    estado = "Doing";
                    binding.btnDoing.setVisibility(View.GONE);
                    break;
                case 3:
                    estado = "Done";
                    binding.btnDoing.setVisibility(View.GONE);
                    binding.btnDone.setVisibility(View.GONE);
                    break;
                default:
            }
            binding.tvEstado.setText("Estado: "+ estado);

            binding.tvFolio.setText("Folio: "+ticket.idTicket);
            binding.tvFecha.setText("Fecha: "+ticket.fecha);
            binding.tvNombreLevanta.setText("Responsable: "+ticket.nombre);
            String equipoResponsable = "";
            switch (ticket.equipoResponsable){
                case 0:
                    equipoResponsable = "Soporte";
                break;
                case 1:
                    equipoResponsable = "Desarrollo";
                    break;
                case 2:
                    equipoResponsable = "Atencion al cliente";
                    break;
                default:
            }
            binding.tvNombreEquipoResponsable.setText("Equipo responsable: "+ equipoResponsable);

            binding.tvTipoIncidencia.setText("Tipo de incidencia: " + (ticket.tipoIncidencia == 0 ? "Bug": "Feature"));

            String gravedad = "";
            switch (ticket.gravedad){
                case 0:
                    gravedad = "Low";
                    break;
                case 1:
                    gravedad = "Medium";
                    break;
                case 2:
                    gravedad = "High";
                    break;
                default:
            }
            binding.tvGravedadIncidencia.setText("Gravedad de la incidencia: "+gravedad);

            binding.tvVersionFalla.setText("Version que presenta la incidencia: "+ ticket.version);

            binding.tvDescripcionFal.setText("Descripcion de la falla: "+ ticket.descripcionProblema);

        }
    }
}