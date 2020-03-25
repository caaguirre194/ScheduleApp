package com.calcapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MantenimientoActivity extends AppCompatActivity {
    String nombre;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mantenimiento);
        nombre = getIntent().getStringExtra("nombre");
    }

    public void back(View view){
        Intent intent = new Intent(this, AdmonActivity.class);
        intent.putExtra("nombre", nombre);
        startActivity(intent);
    }

}
