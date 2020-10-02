package com.example.evaluacionfinalmodulo3;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class Divisas extends AppCompatActivity {

    EditText num_monto;
    TextView num_usd;
    TextView num_eur;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.divisas);

        num_monto = (EditText)findViewById(R.id.num_monto);
        num_usd = (TextView)findViewById(R.id.num_usd);
        num_eur = (TextView)findViewById(R.id.num_eur);
    }

    public void convertir(View view){
        String num_monto_string = num_monto.getText().toString();
        String num_usd_string = num_usd.getText().toString();
        String num_eur_string = num_eur.getText().toString();

        double num_monto_int = Double.parseDouble(num_monto_string);

        double convercion_usd = num_monto_int*0.0013;
        String usdString = "" + convercion_usd;
        num_usd.setText(usdString);

        double convercion_eur = num_monto_int*0.0011;
        String eurString = "" + convercion_eur;
        num_eur.setText(eurString);
    }

    public void nuevo(View view){
        num_monto.setText("");
        num_usd.setText("");
        num_eur.setText("");
    }

    public void volver(View view){
        Intent regresar = new Intent(this,Opciones.class);
        startActivity(regresar);
    }
}
