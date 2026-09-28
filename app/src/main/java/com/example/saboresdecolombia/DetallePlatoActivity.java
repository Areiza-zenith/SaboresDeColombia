package com.example.saboresdecolombia;

import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class DetallePlatoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle_plato);

        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setTitle(R.string.detalle_plato_titulo);
        }

        Button btnVolver = findViewById(R.id.btnVolver);
        btnVolver.setOnClickListener(v -> finish());

        ImageView imgPlato = findViewById(R.id.imgPlato);
        TextView txtNombrePlato = findViewById(R.id.txtNombrePlato);
        TextView txtValorIngredientes = findViewById(R.id.txtValorIngredientes);
        TextView txtHistoria = findViewById(R.id.txtHistoria);

        String nombreRegion = getIntent().getStringExtra("region");
        if (nombreRegion != null) {
            Plato plato = DatosApp.obtenerPlatoPorRegion(nombreRegion);
            if (plato != null) {
                txtNombrePlato.setText(plato.getNombre());
                txtValorIngredientes.setText(plato.getIngredientes());
                txtHistoria.setText(plato.getHistoria());
                if (plato.getImagenResId() != 0) {
                    imgPlato.setImageResource(plato.getImagenResId());
                }
            }
        }
    }

    @Override
    public boolean onSupportNavigateUp() {
        getOnBackPressedDispatcher().onBackPressed();
        return true;
    }
}
