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
        binding.tipoIncidencia.setText(c.idTicket + "");
        binding.titulo.setText(c.titulo);
        binding.tipoIncidencia.setText(c.tipoIncidencia + "");
        binding.gravedad.setText(c.gravedad + "");
        binding.contenedor.setOnClickListener(v -> {
            Log.i("Adapter", c.titulo);
        });
//        if (c.esTDC == 0) {
//            binding.montoCuenta.setTextColor(ContextCompat.getColor(con, R.color.green_60));
//            binding.montoCuenta.setText(UTMoneyUtil.cantidadFormateadaFromDouble(c.saldoActual));
//            binding.consInfoCuentaTDC.setVisibility(View.GONE);
//        } else {
//            binding.consInfoCuentaTDC.setVisibility(View.VISIBLE);
//            binding.tvMontoRestanteTDC.setText(UTMoneyUtil.cantidadFormateadaFromDouble(c.saldoLimite - c.saldoActual));
//            binding.tvMontoLimiteTDC.setText(UTMoneyUtil.cantidadFormateadaFromDouble(c.saldoLimite));
//            binding.indicadorMonto.setProgress(porcentajeRestante(c));
//            if (c.saldoActual < 0) {
//                binding.montoCuenta.setText(UTMoneyUtil.cantidadFormateadaFromDouble(c.saldoActual * -1));
//                binding.montoCuenta.setTextColor(ContextCompat.getColor(con, R.color.green_60));
//            } else {
//                binding.montoCuenta.setText(UTMoneyUtil.cantidadFormateadaFromDouble(c.saldoActual));
//                binding.montoCuenta.setTextColor(ContextCompat.getColor(con, R.color.red_60));
//            }
//        }
//        if (c.activo == 1) {
//            binding.switchOculto.setChecked(true);
//        }
//        binding.switchOculto.setOnClickListener(v -> {
//            cuentasItemAdapter.adapterItemClickListener.onAdapterItemClickListener(getAdapterPosition());
//        });
//        binding.contenedor.setOnClickListener(v -> {
//            Intent intent = new Intent(con, addCuentasActivity.class);
//            intent.putExtra("Cuenta", c);
//            con.startActivity(intent);
//        });
    }

//    public int porcentajeRestante(Ticket c) {
//        return 100 - (int) Math.round(100 * c.saldoActual / c.saldoLimite);
//    }

}
