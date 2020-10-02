package com.example.evaluacionfinalmodulo3;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class Seguros extends AppCompatActivity {

    EditText propietario, valor, nAccidentes;
    TextView total;
    CheckBox cb1, cb2, cb3;
    RadioGroup rg1, rg2;
    RadioButton rb1, rb2, rb3;
    Button bt1;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.seguros);

        propietario = (EditText)findViewById(R.id.txt_et1);
        valor = (EditText)findViewById(R.id.txt_et2);
        nAccidentes = (EditText)findViewById(R.id.txt_et3);
        total = (TextView)findViewById(R.id.txt_tv1);
        cb1 = (CheckBox)findViewById(R.id.checkBox1);
        cb2 = (CheckBox)findViewById(R.id.checkBox2);
        cb3 = (CheckBox)findViewById(R.id.checkBox3);
        rg1 = (RadioGroup)findViewById(R.id.radioGroup1);
        rg2 = (RadioGroup)findViewById(R.id.radioGroup2);
        rb1 = (RadioButton)findViewById(R.id.radioButton1);
        rb2 = (RadioButton)findViewById(R.id.radioButton2);
        rb3 = (RadioButton)findViewById(R.id.radioButton3);
    }
    public void calcular(View view){
        int valorModelo=0, valorEdad=0, cargoXaccidente=17, cargoXvalor, cargoTotal;
        String nAccidentes_string = nAccidentes.getText().toString();
        String valor_string = valor.getText().toString();

        int nAccidentes_int = Integer.parseInt(nAccidentes_string);
        int valor_int = Integer.parseInt(valor_string);

        if(cb1.isChecked()==true){
            valorModelo = valor_int*11/1000;
        }else if(cb2.isChecked()==true){
            valorModelo = valor_int*12/1000;
        }else if(cb3.isChecked()==true){
            valorModelo = valor_int*15/1000;
        }

        if(rb1.isChecked()==true){
            valorEdad = 360;
        }else if(rb2.isChecked()==true){
            valorEdad = 240;
        }else if(rb3.isChecked()==true){
            valorEdad = 430;
        }

        if(nAccidentes_int<=3){
            cargoXaccidente = 17;
        }else if(nAccidentes_int>3){
            for (int i=4;i<=nAccidentes_int;i++ ){
                cargoXaccidente = cargoXaccidente + 21;
            }
        }
        cargoXvalor = valor_int*35/1000;
        cargoTotal = valorModelo + valorEdad + cargoXaccidente + cargoXvalor;

        total.setText(""+cargoTotal);

    }
    public void nuevo (View view){
        propietario.setText("");
        valor.setText("");
        nAccidentes.setText("");
        total.setText("");
        cb1.setChecked(false);
        cb2.setChecked(false);
        cb3.setChecked(false);
        rg2.clearCheck();
    }
    public void volver(View view){
        Intent regresar = new Intent(this,Opciones.class);
        startActivity(regresar);
    }
}
