package com.example.saboresdecolombia;

import java.util.List;

public class Plato {
    private String nombre;
    private String origen;
    private String ingredientes;
    private String historia;
    private String preparacion;
    private String enlace;
    private List<String> comentarios;
    private int imagenResId;

    public Plato(String nombre, String origen, String ingredientes, String historia, String preparacion, String enlace, List<String> comentarios, int imagenResId) {
        this.nombre = nombre;
        this.origen = origen;
        this.ingredientes = ingredientes;
        this.historia = historia;
        this.preparacion = preparacion;
        this.enlace = enlace;
        this.comentarios = comentarios;
        this.imagenResId = imagenResId;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getOrigen() {
        return origen;
    }

    public void setOrigen(String origen) {
        this.origen = origen;
    }

    public String getIngredientes() {
        return ingredientes;
    }

    public void setIngredientes(String ingredientes) {
        this.ingredientes = ingredientes;
    }

    public String getHistoria() {
        return historia;
    }

    public void setHistoria(String historia) {
        this.historia = historia;
    }

    public String getPreparacion() {
        return preparacion;
    }

    public void setPreparacion(String preparacion) {
        this.preparacion = preparacion;
    }

    public String getEnlace() {
        return enlace;
    }

    public void setEnlace(String enlace) {
        this.enlace = enlace;
    }

    public List<String> getComentarios() {
        return comentarios;
    }

    public void setComentarios(List<String> comentarios) {
        this.comentarios = comentarios;
    }

    public int getImagenResId() {
        return imagenResId;
    }

    public void setImagenResId(int imagenResId) {
        this.imagenResId = imagenResId;
    }
}
