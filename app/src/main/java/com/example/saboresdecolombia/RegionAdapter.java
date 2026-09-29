package com.example.saboresdecolombia;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class RegionAdapter extends RecyclerView.Adapter<RegionAdapter.RegionViewHolder> {

    public interface OnRegionClickListener {
        void onRegionClick(int posicion);
    }

    private final List<Region> regiones;
    private final OnRegionClickListener listener;
    private int seleccionada = 0;

    public RegionAdapter(List<Region> regiones, OnRegionClickListener listener) {
        this.regiones = regiones;
        this.listener = listener;
    }

    public void setSeleccionada(int posicion) {
        seleccionada = posicion;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public RegionViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View vista = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_region, parent, false);
        return new RegionViewHolder(vista);
    }

    @Override
    public void onBindViewHolder(@NonNull RegionViewHolder holder, int posicion) {
        Region region = regiones.get(posicion);
        holder.txtNombreRegion.setText(region.getNombre());
        holder.itemView.setBackgroundColor(
                ContextCompat.getColor(holder.itemView.getContext(), region.getColorResId()));
        // La región seleccionada se ve completa; las demás, atenuadas
        holder.itemView.setAlpha(posicion == seleccionada ? 1f : 0.55f);
        holder.itemView.setOnClickListener(v -> listener.onRegionClick(holder.getAdapterPosition()));
    }

    @Override
    public int getItemCount() {
        return regiones.size();
    }

    public static class RegionViewHolder extends RecyclerView.ViewHolder {
        TextView txtNombreRegion;

        RegionViewHolder(@NonNull View itemView) {
            super(itemView);
            txtNombreRegion = itemView.findViewById(R.id.txtNombreRegion);
        }
    }
}
