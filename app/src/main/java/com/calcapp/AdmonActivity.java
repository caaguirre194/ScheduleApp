package com.calcapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class AdmonActivity extends AppCompatActivity {
    String nombre;
    private TextView txtNombre;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admon);
        txtNombre = (TextView) findViewById(R.id.textView9);
        nombre = getIntent().getStringExtra("nombre");
        txtNombre.setText(nombre);
    }

    public void back(View view){
        Intent intent = new Intent(this, LoginActivity.class);
        startActivity(intent);
    }

    public void crear(View view){
        Intent intent = new Intent(this, CrearActivity.class);
        intent.putExtra("rol", "admin");
        intent.putExtra("nombre", nombre);
        startActivity(intent);
    }

    public void listar(View view){
        Intent intent = new Intent(this, ListarActivity.class);
        intent.putExtra("rol", "admin");
        intent.putExtra("nombre", nombre);
        startActivity(intent);
    }

    public void mantenimimento(View view){
        Intent intent = new Intent(this, MantenimientoActivity.class);
        intent.putExtra("nombre", nombre);
        startActivity(intent);
    }

}
