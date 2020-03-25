package com.calcapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Button;
import android.widget.Toast;


public class OperationActivity extends AppCompatActivity {

    private TextView txtOper;
    private EditText numOper;
    private TextView txtTablaR;
    private EditText editTextR;
    private Button btnOperarR;
    private String operador;
    private Button btnOperar;
    private boolean validado;
    private int valValidado;
    private Toast toast;

    private Thread fila = new Thread(){
        public void run(){
            try{
                String str = numOper.getText().toString();
                int num = 0;
                if(str != null && !str.isEmpty()){
                    num = Integer.parseInt(str);
                }
                String result2 = "";
                String textBase = "";
                for(int i=1;i<=10;i++){
                    int result1 = 0;
                    switch(operador) {
                        case "+":
                            result1 = num + i;
                            break;
                        case "-":
                            result1 = num - i;
                            break;
                        case "x":
                            result1 = num * i;
                            break;
                        case "/":
                            result1 = num / i;
                    }
                    textBase+=num + operador + i + " = ? "+ '\n';
                    txtTablaR.setText(textBase);

                    int tiempo=0;
                    while(tiempo<15000){
                        sleep(100);
                        tiempo=tiempo+100;
                        if(validado){
                            tiempo=15000;
                        }
                    }

                    if(valValidado == result1){
                        result2 += num + operador + i + " = " + result1 +" (√) "+ '\n';
                        toast.setText("Correcto (√)");
                        toast.show();
                    }
                    else{
                        result2 += num + operador + i + " = " + valValidado +" (X) "+ '\n';
                        toast.setText("Incorrecto (X)");
                        toast.show();
                    }

                    validado = false;
                    editTextR.setText("");
                }
                txtTablaR.setText(result2);

                editTextR.setEnabled(false);
                btnOperarR.setEnabled(false);

                editTextR.setVisibility(View.INVISIBLE);
                btnOperarR.setVisibility(View.INVISIBLE);

            }
            catch(Exception e){
                e.printStackTrace();
            }finally{
                /*editTextR.setVisibility(View.INVISIBLE);
                btnOperarR.setVisibility(View.INVISIBLE);
                finish();*/
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_operation);
        txtOper = (TextView) findViewById(R.id.textView4);
        numOper = (EditText) findViewById(R.id.editText);
        btnOperar = (Button) findViewById(R.id.button6);
        validado = false;
        valValidado = 0;
        toast=Toast.makeText(getApplicationContext(),"",Toast.LENGTH_SHORT);
        toast.setGravity(20|20, 0, 0);

        operador = getIntent().getStringExtra("operador");
        switch(operador) {
            case "+":
                txtOper.setText("Suma");
                break;
            case "-":
                txtOper.setText("Resta");
                break;
            case "x":
                txtOper.setText("Producto");
                break;
            case "/":
                txtOper.setText("División");
                break;
        }

    }

    public void operar(View view){
        btnOperar.setEnabled(false);
        numOper.setEnabled(false);

        btnOperar.setVisibility(View.INVISIBLE);
        txtTablaR = (TextView) findViewById(R.id.textViewR1);
        txtTablaR.setVisibility(View.VISIBLE);

        editTextR = (EditText) findViewById(R.id.editTextR1);
        editTextR.setVisibility(View.VISIBLE);

        btnOperarR = (Button) findViewById(R.id.buttonR1);
        btnOperarR.setVisibility(View.VISIBLE);

        fila.start();

    }

    public void validar(View view){

        String str = editTextR.getText().toString();
        valValidado = 0;
        if(str != null && !str.isEmpty()){
            valValidado = Integer.parseInt(str);
        }
        validado = true;

    }

    public void goMain(View view){
        Intent intent = new Intent(this, LoginActivity.class);
        startActivity(intent);
    }
}
