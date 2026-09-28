package com.example.saboresdecolombia;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class RegionAdapter extends RecyclerView.Adapter<RegionAdapter.RegionViewHolder> {

    private final List<Region> regiones;

    public RegionAdapter(List<Region> regiones) {
        this.regiones = regiones;
    }

    // Crea un cuadro vacío usando item_region.xml
    @NonNull
    @Override
    public RegionViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View vista = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_region, parent, false);
        return new RegionViewHolder(vista);
    }

    // Llena el cuadro en la posición "posicion" con los datos reales
    @Override
    public void onBindViewHolder(@NonNull RegionViewHolder holder, int posicion) {
        Region region = regiones.get(posicion);
        holder.txtNombreRegion.setText(region.getNombre());

        // Al tocar el cuadro, abre la pantalla de detalle pasando el nombre de la región
        holder.itemView.setOnClickListener(v -> {
            Intent intent = new Intent(v.getContext(), DetallePlatoActivity.class);
            intent.putExtra("region", region.getNombre());
            v.getContext().startActivity(intent);
        });
    }

    // Cuántos cuadros hay en total
    @Override
    public int getItemCount() {
        return regiones.size();
    }

    // Guarda las referencias a las vistas de UN cuadro, para no buscar con findViewById cada vez
    public static class RegionViewHolder extends RecyclerView.ViewHolder {
        TextView txtNombreRegion;

        RegionViewHolder(@NonNull View itemView) {
            super(itemView);
            txtNombreRegion = itemView.findViewById(R.id.txtNombreRegion);
        }
    }
}