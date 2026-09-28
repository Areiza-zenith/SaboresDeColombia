package com.example.saboresdecolombia;

import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class RegionesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_regiones);

        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setTitle(R.string.regiones_titulo);
        }

        Button btnVolver = findViewById(R.id.btnVolver);
        btnVolver.setOnClickListener(v -> finish());

        RecyclerView recycler = findViewById(R.id.recyclerRegiones);
        // 2 columnas = "cuadrantes", como en tu diseño
        recycler.setLayoutManager(new GridLayoutManager(this, 2));

        List<Region> regiones = DatosApp.obtenerRegiones();
        recycler.setAdapter(new RegionAdapter(regiones));
    }

    @Override
    public boolean onSupportNavigateUp() {
        getOnBackPressedDispatcher().onBackPressed();
        return true;
    }
}
