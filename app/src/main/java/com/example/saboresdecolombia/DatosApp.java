package com.example.saboresdecolombia;

import java.util.ArrayList;
import java.util.List;

// Datos de ejemplo de la app. En una entrega posterior se reemplazan por datos reales.
public class DatosApp {

    // Video y fotos de ejemplo (se reemplazan por los reales de cada plato)
    private static final String VIDEO_EJEMPLO =
            "https://storage.googleapis.com/gtv-videos-bucket/sample/ForBiggerBlazes.mp4";
    private static final String WIKI = "https://es.wikipedia.org/wiki/";

    private static List<Region> regiones;

    public static synchronized List<Region> obtenerRegiones() {
        if (regiones == null) {
            regiones = new ArrayList<>();

            Region andina = new Region("Andina", R.color.region_andina);
            andina.agregarPlato(crearPlato("Ajiaco", "Andina",
                    "Pollo, papa, mazorca, guascas, crema de leche, alcaparras",
                    "Plato tradicional de Bogotá, con origen indígena y gran importancia cultural en la región andina.",
                    "Ajiaco"));
            andina.agregarPlato(crearPlato("Bandeja paisa", "Andina",
                    "Frijoles, arroz, chicharrón, carne molida, chorizo, huevo, plátano maduro, arepa, aguacate",
                    "Plato insignia de Antioquia, nacido como comida abundante para los arrieros y campesinos.",
                    "Bandeja_paisa"));
            andina.agregarPlato(crearPlato("Tamal", "Andina",
                    "Masa de maíz, cerdo, pollo, arroz, arveja, zanahoria, hoja de plátano",
                    "Preparación envuelta en hoja de plátano, presente en celebraciones familiares de toda la región.",
                    "Tamal"));
            regiones.add(andina);

            Region caribe = new Region("Caribe", R.color.region_caribe);
            caribe.agregarPlato(crearPlato("Arroz con coco", "Caribe",
                    "Arroz, coco, azúcar, pasas",
                    "Plato típico de la costa Caribe colombiana, acompañante clásico del pescado frito.",
                    "Arroz_con_coco"));
            caribe.agregarPlato(crearPlato("Sancocho de pescado", "Caribe",
                    "Pescado, yuca, plátano, ñame, cilantro",
                    "Sopa costeña de influencia africana e indígena, muy común en los pueblos de pescadores.",
                    "Sancocho"));
            regiones.add(caribe);

            Region pacifica = new Region("Pacífica", R.color.region_pacifica);
            pacifica.agregarPlato(crearPlato("Encocado de pescado", "Pacífica",
                    "Pescado, leche de coco, plátano, cilantro",
                    "Preparación típica del Pacífico colombiano, con fuerte influencia afrocolombiana.",
                    "Gastronomía_del_Pacífico_colombiano"));
            pacifica.agregarPlato(crearPlato("Arroz atollado", "Pacífica",
                    "Arroz, cerdo, pollo, chorizo, papa, hogao",
                    "Arroz caldoso tradicional del Valle del Cauca, servido en reuniones familiares.",
                    "Arroz_atollado"));
            regiones.add(pacifica);

            Region orinoquia = new Region("Orinoquía", R.color.region_orinoquia);
            orinoquia.agregarPlato(crearPlato("Carne a la llanera", "Orinoquía",
                    "Carne de res, sal, yuca, plátano, guiso criollo",
                    "Carne asada a las brasas, símbolo de la cultura llanera y de las fiestas de los Llanos Orientales.",
                    "Carne_a_la_llanera"));
            orinoquia.agregarPlato(crearPlato("Mojojoy", "Orinoquía",
                    "Larva de mojojoy, sal",
                    "Delicia tradicional indígena de los Llanos Orientales, rica en proteína.",
                    "Mojojoy"));
            regiones.add(orinoquia);

            Region amazonia = new Region("Amazonía", R.color.region_amazonia);
            amazonia.agregarPlato(crearPlato("Pescado amazónico", "Amazonía",
                    "Pescado de río, yuca, plátano",
                    "Plato representativo de las comunidades indígenas del Amazonas colombiano.",
                    "Gastronomía_de_la_región_amazónica_de_Colombia"));
            amazonia.agregarPlato(crearPlato("Casabe", "Amazonía",
                    "Yuca brava, agua",
                    "Torta delgada de yuca, alimento base de los pueblos indígenas amazónicos.",
                    "Casabe"));
            regiones.add(amazonia);
        }
        return regiones;
    }

    private static Plato crearPlato(String nombre, String origen, String ingredientes,
                                    String historia, String paginaWiki) {
        List<ImagenGaleria> galeria = new ArrayList<>();
        galeria.add(new ImagenGaleria(R.drawable.fondo_cartagena, nombre + " tradicional (foto de ejemplo)"));
        galeria.add(new ImagenGaleria(R.drawable.logo_sabores, nombre + " en la ruta gastronómica (foto de ejemplo)"));
        galeria.add(new ImagenGaleria(R.drawable.fondo_cartagena, nombre + " servido en la mesa (foto de ejemplo)"));
        return new Plato(nombre, origen, ingredientes, historia,
                VIDEO_EJEMPLO, WIKI + paginaWiki, R.drawable.fondo_cartagena, galeria);
    }
}
