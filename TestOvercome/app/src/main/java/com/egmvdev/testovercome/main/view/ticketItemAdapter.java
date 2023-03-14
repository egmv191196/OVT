package com.egmvdev.testovercome.main.view;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.egmvdev.testovercome.database.entities.Ticket;
import com.egmvdev.testovercome.databinding.TicketItemBinding;
import com.egmvdev.testovercome.detailticket.view.detailTicket;
import com.egmvdev.testovercome.main.interfaces.OnItemClickListener;

import java.util.List;

public class ticketItemAdapter extends RecyclerView.Adapter<ticketItemViewHolder> {
    private List<Ticket> datos;

    public ticketItemAdapter(List<Ticket> datos) {
        this.datos = datos;
    }

    @NonNull
    @Override
    public ticketItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ticketItemViewHolder(parent.getContext(), TicketItemBinding.inflate(LayoutInflater.from(parent.getContext()),parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull ticketItemViewHolder holder, int position) {
        holder.setDatos(datos.get(position));
    }

    @Override
    public int getItemCount() {
        return datos.size();
    }
}

class ticketItemViewHolder extends RecyclerView.ViewHolder {

    private TicketItemBinding binding;
    Context con;

    public ticketItemViewHolder(Context c, TicketItemBinding binding) {
        super(binding.getRoot());
        this.binding = binding;
        con = c;
    }

    void setDatos(Ticket c) {
        binding.numTicket.setText("# de ticket: " + c.idTicket);
        binding.titulo.setText(c.titulo);
        binding.tipoIncidencia.setText(c.tipoIncidencia == 0 ? "Incidencia: Bug": "Incidencia: Feature");
        String gravedad = "";
        switch (c.gravedad){
            case 0:
                gravedad = "Gravedad: Low";
            break;
            case 1:
                gravedad = "Gravedad: Medium";
                break;
            case 2:
                gravedad = "Gravedad: High";
                break;
            default:
        }
        binding.gravedad.setText(gravedad);
        binding.contenedor.setOnClickListener(v -> {
            Log.i("Adapter", c.titulo);
        });
        binding.contenedor.setOnClickListener(v -> {
            Intent intent = new Intent(con, detailTicket.class);
            intent.putExtra("Ticket", c);
            con.startActivity(intent);
        });
    }

//    public int porcentajeRestante(Ticket c) {
//        return 100 - (int) Math.round(100 * c.saldoActual / c.saldoLimite);
//    }

}
