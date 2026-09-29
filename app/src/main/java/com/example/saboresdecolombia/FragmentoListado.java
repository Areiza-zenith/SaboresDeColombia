package com.example.saboresdecolombia;

import android.content.Context;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

// Fragmento izquierdo: regiones y platos típicos de la región seleccionada
public class FragmentoListado extends Fragment {

    // La Activity que aloja el fragmento implementa esta interfaz para enterarse del plato elegido
    public interface OnPlatoSeleccionadoListener {
        void onPlatoSeleccionado(Plato plato);
    }

    private OnPlatoSeleccionadoListener listener;
    private List<Region> regiones;
    private RegionAdapter regionAdapter;
    private PlatoAdapter platoAdapter;
    private RecyclerView rvRegiones;
    private RecyclerView rvPlatos;

    public FragmentoListado() {
        super(R.layout.fragment_listado);
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        if (context instanceof OnPlatoSeleccionadoListener) {
            listener = (OnPlatoSeleccionadoListener) context;
        } else {
            throw new ClassCastException(context + " debe implementar OnPlatoSeleccionadoListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        listener = null;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        rvRegiones = view.findViewById(R.id.rvRegiones);
        rvPlatos = view.findViewById(R.id.rvPlatos);
        regiones = DatosApp.obtenerRegiones();

        mostrarRegiones();
        mostrarPlatos(regiones.get(0));
    }

    // Llena la lista de regiones
    private void mostrarRegiones() {
        regionAdapter = new RegionAdapter(regiones, this::alTocarRegion);
        rvRegiones.setLayoutManager(new LinearLayoutManager(requireContext()));
        rvRegiones.setAdapter(regionAdapter);
    }

    // Llena la lista de platos con los de la región indicada
    private void mostrarPlatos(Region region) {
        if (platoAdapter == null) {
            platoAdapter = new PlatoAdapter(this::seleccionarPlato);
            rvPlatos.setLayoutManager(new LinearLayoutManager(requireContext()));
            rvPlatos.setAdapter(platoAdapter);
        }
        platoAdapter.setPlatos(region.obtenerPlatos());
    }

    // Evento: el usuario toca una región
    private void alTocarRegion(int posicion) {
        regionAdapter.setSeleccionada(posicion);
        Region region = regiones.get(posicion);
        mostrarPlatos(region);
        seleccionarPlato(region.obtenerPlatos().get(0));
    }

    // Evento: el usuario toca un plato; se avisa a la Activity para que actualice el detalle
    private void seleccionarPlato(Plato plato) {
        if (listener != null) {
            listener.onPlatoSeleccionado(plato);
        }
    }
}
