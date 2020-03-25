package com.calcapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.content.Intent;
import android.widget.EditText;

public class LoginActivity extends AppCompatActivity {
    private EditText txtUsuario;
    private EditText txtContra;
    Usuario admin;
    Usuario user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        admin = new Usuario("admin","123");
        user = new Usuario("user","123");
        txtUsuario = (EditText) findViewById(R.id.editText2);
        txtContra = (EditText) findViewById(R.id.editText4);
    }

    public void operar(View view){
        Intent i = new Intent(this, OperationActivity.class);
        String txtOper = (String) view.getTag();//tomas el tag asignado
        i.putExtra("operador", txtOper);
        startActivity(i);
    }

    public void login(View view){
        Intent i;
        if(txtUsuario.getText().toString().equals(user.getNombre()) && txtContra.getText().toString().equals(user.getContra())){
            i = new Intent(this, UsuarioActivity.class);
            i.putExtra("nombre", user.getNombre());
            startActivity(i);
        }else if(txtUsuario.getText().toString().equals(admin.getNombre()) && txtContra.getText().toString().equals(admin.getContra())){
            i = new Intent(this, AdmonActivity.class);
            i.putExtra("nombre", admin.getNombre());
            startActivity(i);
        }
    }

}
