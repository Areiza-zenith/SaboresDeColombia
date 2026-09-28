package com.example.saboresdecolombia;

import java.util.ArrayList;
import java.util.List;

// Clase que centraliza los datos de ejemplo de toda la app
public class DatosApp {

    private static List<Region> regiones;
    private static List<Plato> platos;

    public static synchronized List<Region> obtenerRegiones() {
        if (regiones == null) {
            regiones = new ArrayList<>();
            regiones.add(new Region("Andina"));
            regiones.add(new Region("Caribe"));
            regiones.add(new Region("Pacífica"));
            regiones.add(new Region("Orinoquía"));
            regiones.add(new Region("Amazonía"));
        }
        return regiones;
    }

    public static synchronized List<Plato> obtenerPlatos() {
        if (platos == null) {
            platos = new ArrayList<>();

            platos.add(new Plato(
                    "Ajiaco",
                    "Andina",
                    "Pollo, papa, mazorca, guascas, crema de leche, alcaparras",
                    "Es un plato tradicional de Bogotá, con origen indígena y gran importancia cultural en la región andina.",
                    "",
                    "https://www.recetasdecolombia.com/ajiaco",
                    new ArrayList<>(),
                    R.drawable.logo_sabores
            ));

            platos.add(new Plato(
                    "Arroz con coco",
                    "Caribe",
                    "Arroz, coco, azúcar, pasas",
                    "Plato típico de la costa Caribe colombiana, acompañante clásico del pescado frito.",
                    "",
                    "https://www.recetasdecolombia.com/arroz-con-coco",
                    new ArrayList<>(),
                    R.drawable.logo_sabores
            ));

            platos.add(new Plato(
                    "Encocado de pescado",
                    "Pacífica",
                    "Pescado, leche de coco, plátano, cilantro",
                    "Preparación típica del Pacífico colombiano, con fuerte influencia afrocolombiana.",
                    "",
                    "https://www.recetasdecolombia.com/encocado",
                    new ArrayList<>(),
                    R.drawable.logo_sabores
            ));

            platos.add(new Plato(
                    "Mojojoy",
                    "Orinoquía",
                    "Larva de mojojoy, sal",
                    "Delicia tradicional indígena de los Llanos Orientales, rica en proteína.",
                    "",
                    "https://www.recetasdecolombia.com/mojojoy",
                    new ArrayList<>(),
                    R.drawable.logo_sabores
            ));

            platos.add(new Plato(
                    "Pescado amazónico",
                    "Amazonía",
                    "Pescado de río, yuca, plátano",
                    "Plato representativo de las comunidades indígenas del Amazonas colombiano.",
                    "",
                    "https://www.recetasdecolombia.com/pescado-amazonico",
                    new ArrayList<>(),
                    R.drawable.logo_sabores
            ));
        }
        return platos;
    }

    // Busca el plato que pertenece a una región dada
    public static Plato obtenerPlatoPorRegion(String nombreRegion) {
        if (nombreRegion == null) return null;
        for (Plato p : obtenerPlatos()) {
            if (nombreRegion.equalsIgnoreCase(p.getOrigen())) {
                return p;
            }
        }
        return null;
    }
}
