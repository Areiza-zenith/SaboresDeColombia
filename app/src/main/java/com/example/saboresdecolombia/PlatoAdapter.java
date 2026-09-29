package com.example.saboresdecolombia;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class PlatoAdapter extends RecyclerView.Adapter<PlatoAdapter.PlatoViewHolder> {

    public interface OnPlatoClickListener {
        void onPlatoClick(Plato plato);
    }

    private final List<Plato> platos = new ArrayList<>();
    private final OnPlatoClickListener listener;
    private int seleccionado = 0;

    public PlatoAdapter(OnPlatoClickListener listener) {
        this.listener = listener;
    }

    // Reemplaza la lista por los platos de otra región y selecciona el primero
    public void setPlatos(List<Plato> nuevos) {
        platos.clear();
        platos.addAll(nuevos);
        seleccionado = 0;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public PlatoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View vista = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_plato_list, parent, false);
        return new PlatoViewHolder(vista);
    }

    @Override
    public void onBindViewHolder(@NonNull PlatoViewHolder holder, int posicion) {
        Plato plato = platos.get(posicion);
        holder.txtNombrePlato.setText(plato.getNombre());
        holder.itemView.setBackgroundColor(posicion == seleccionado
                ? ContextCompat.getColor(holder.itemView.getContext(), R.color.seleccion)
                : 0);
        holder.itemView.setOnClickListener(v -> {
            seleccionado = holder.getAdapterPosition();
            notifyDataSetChanged();
            listener.onPlatoClick(plato);
        });
    }

    @Override
    public int getItemCount() {
        return platos.size();
    }

    public static class PlatoViewHolder extends RecyclerView.ViewHolder {
        TextView txtNombrePlato;

        PlatoViewHolder(@NonNull View itemView) {
            super(itemView);
            txtNombrePlato = itemView.findViewById(R.id.txtNombrePlato);
        }
    }
}
