package com.example.evaluacionfinalmodulo3;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class Opciones extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.opciones);


    }

    public void divisas(View view){
        Intent Divisas = new Intent(this, Divisas.class);
        startActivity(Divisas);
    }

    public void multa(View view){
        Intent Multa = new Intent(this, Multa.class);
        startActivity(Multa);
    }

    public void seguros(View view){
        Intent Seguros = new Intent(this, Seguros.class);
        startActivity(Seguros);
    }
    public void salir(View view){
        finishAffinity();
    }

}
