package com.example.saboresdecolombia;

import java.util.ArrayList;
import java.util.List;

public class Region {
    private final String nombre;
    private final int colorResId;
    private final List<Plato> platos = new ArrayList<>();

    public Region(String nombre, int colorResId) {
        this.nombre = nombre;
        this.colorResId = colorResId;
    }

    public String getNombre() {
        return nombre;
    }

    public int getColorResId() {
        return colorResId;
    }

    public void agregarPlato(Plato plato) {
        platos.add(plato);
    }

    public List<Plato> obtenerPlatos() {
        return platos;
    }
}
