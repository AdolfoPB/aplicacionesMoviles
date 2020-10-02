package com.example.evaluacionfinalmodulo3;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class Multa extends AppCompatActivity {

    EditText et1;
    EditText et2;
    EditText et3;
    TextView tv1;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.multa);

        et1 = (EditText)findViewById(R.id.dni);
        et2 = (EditText)findViewById(R.id.nombre);
        et3 = (EditText)findViewById(R.id.sueldo);
        tv1 = (TextView)findViewById(R.id.total);
    }

    public void calcular(View view){

        String sueldo = et3.getText().toString();
        int sueldo_int = Integer.parseInt(sueldo);
        int totalApagar = (sueldo_int*10)/100;

        String total = String.valueOf(totalApagar);
        tv1.setText(total);
    }

    public void nuevo(View view){
        et1.setText("");
        et2.setText("");
        et3.setText("");
        tv1.setText("");
    }

    public void volver(View view){
        Intent regresar = new Intent(this,Opciones.class);
        startActivity(regresar);
    }
}
