package com.calcapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class CrearActivity extends AppCompatActivity {
    String rol;
    String nombre;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crear);
        rol = getIntent().getStringExtra("rol");
        nombre = getIntent().getStringExtra("nombre");
    }

    public void back(View view){
        Intent intent;
        if(rol.equals("admin")) {
            intent = new Intent(this, AdmonActivity.class);
        }else{
            intent = new Intent(this, UsuarioActivity.class);
        }
        intent.putExtra("nombre", nombre);
        startActivity(intent);
    }

}
