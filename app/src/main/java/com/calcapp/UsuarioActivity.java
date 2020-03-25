package com.calcapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class UsuarioActivity extends AppCompatActivity {
    String nombre;
    private TextView txtNombre;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_usuario);
        txtNombre = (TextView) findViewById(R.id.textView10);
        nombre = getIntent().getStringExtra("nombre");
        txtNombre.setText(nombre);
    }

    public void back(View view){
        Intent intent = new Intent(this, LoginActivity.class);
        startActivity(intent);
    }

    public void crear(View view){
        Intent intent = new Intent(this, CrearActivity.class);
        intent.putExtra("rol", "user");
        intent.putExtra("nombre", nombre);
        startActivity(intent);
    }

    public void listar(View view){
        Intent intent = new Intent(this, ListarActivity.class);
        intent.putExtra("rol", "user");
        intent.putExtra("nombre", nombre);
        startActivity(intent);
    }

}
