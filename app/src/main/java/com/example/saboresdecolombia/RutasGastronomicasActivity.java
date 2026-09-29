package com.example.saboresdecolombia;

import android.os.Bundle;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

// Actividad principal: aloja los dos fragmentos lado a lado (listado a la izquierda, detalle a la derecha)
public class RutasGastronomicasActivity extends AppCompatActivity
        implements FragmentoListado.OnPlatoSeleccionadoListener {

    private FragmentoDetalle fragmentoDetalle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_rutas_gastronomicas);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        Button btnVolver = findViewById(R.id.btnVolver);
        btnVolver.setOnClickListener(v -> finish());

        fragmentoDetalle = (FragmentoDetalle) getSupportFragmentManager()
                .findFragmentById(R.id.fragmentoDetalle);

        // Al abrir, el detalle muestra el primer plato de la primera región
        fragmentoDetalle.mostrarPlato(DatosApp.obtenerRegiones().get(0).obtenerPlatos().get(0));
    }

    @Override
    public void onPlatoSeleccionado(Plato plato) {
        fragmentoDetalle.mostrarPlato(plato);
    }
}
