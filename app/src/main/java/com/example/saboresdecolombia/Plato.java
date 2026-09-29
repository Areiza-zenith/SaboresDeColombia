package com.example.saboresdecolombia;

import java.util.List;

public class Plato {
    private final String nombre;
    private final String origen;
    private final String ingredientes;
    private final String historia;
    private final String urlVideo;
    private final String urlReceta;
    private final int imagenResId;
    private final List<ImagenGaleria> galeria;
    private boolean favorito;

    public Plato(String nombre, String origen, String ingredientes, String historia,
                 String urlVideo, String urlReceta, int imagenResId, List<ImagenGaleria> galeria) {
        this.nombre = nombre;
        this.origen = origen;
        this.ingredientes = ingredientes;
        this.historia = historia;
        this.urlVideo = urlVideo;
        this.urlReceta = urlReceta;
        this.imagenResId = imagenResId;
        this.galeria = galeria;
    }

    public String getNombre() {
        return nombre;
    }

    public String getOrigen() {
        return origen;
    }

    public String getIngredientes() {
        return ingredientes;
    }

    public String getHistoria() {
        return historia;
    }

    public String getUrlVideo() {
        return urlVideo;
    }

    public String getUrlReceta() {
        return urlReceta;
    }

    public int getImagenResId() {
        return imagenResId;
    }

    public List<ImagenGaleria> getGaleria() {
        return galeria;
    }

    public boolean esFavorito() {
        return favorito;
    }

    // Alterna el estado de favorito (marcar / desmarcar)
    public void marcarFavorito() {
        favorito = !favorito;
    }
}
