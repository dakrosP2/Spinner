package com.example.spinner;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
public class MainActivity extends AppCompatActivity {
    private Spinner spinner1;
    private EditText et1, et2;
    private TextView tv1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et1 = (EditText)findViewById(R.id.txtvalor1);
        et2 = (EditText)findViewById(R.id.txtvalor2);
        tv1 = (TextView)findViewById(R.id.txtresultado);
        spinner1 = (Spinner)findViewById(R.id.spinner1);

        String[] opciones = {"SUMAR","RESTAR","MULTIPLICAR","DIVIDIR"};
        ArrayAdapter <String>adapter = new ArrayAdapter<String>( this, android.R.layout.simple_spinner_item, opciones);
        spinner1.setAdapter(adapter);

    }
    public void calcular(View view){
        String valor1_String = et1.getText().toString();
        String valor2_String = et2.getText().toString();

        int valor1_int = Integer.parseInt(valor1_String);
        int valor2_int = Integer.parseInt(valor2_String);

        String seleccion = spinner1.getSelectedItem().toString();
        if (seleccion.equals("SUMAR")){
            int sum = valor1_int + valor2_int;
            String resultado = String.valueOf(sum);
            tv1.setText(resultado);
        } else if (seleccion.equals("RESTAR")){
            int res = valor1_int - valor2_int;
            String resultado = String.valueOf(res);
            tv1.setText(resultado);
        } else if (seleccion.equals("MULTIPLICAR")){
            int mult = valor1_int * valor2_int;
            String resultado = String.valueOf(mult);
            tv1.setText(resultado);
        } else if (seleccion.equals("DIVIDIR")){
            if(valor2_int != 0){
                int div = valor1_int / valor2_int;
                String resultado = String.valueOf(div);
                tv1.setText(resultado);
            } else {
                Toast.makeText( this, "ERROR", Toast.LENGTH_LONG).show();
            }
        }
    }
}