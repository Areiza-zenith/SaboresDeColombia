package com.example.saboresdecolombia;

// Foto de la galería de un plato (clase ImagenGaleria del UML)
public class ImagenGaleria {
    private final int imagenResId;
    private final String descripcion;

    public ImagenGaleria(int imagenResId, String descripcion) {
        this.imagenResId = imagenResId;
        this.descripcion = descripcion;
    }

    public int getImagenResId() {
        return imagenResId;
    }

    public String getDescripcion() {
        return descripcion;
    }
}
