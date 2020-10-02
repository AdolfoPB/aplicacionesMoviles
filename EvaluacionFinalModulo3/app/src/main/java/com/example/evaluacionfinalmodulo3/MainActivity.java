package com.example.evaluacionfinalmodulo3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText usuario, password;
    Button iniciar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        usuario = (EditText) findViewById(R.id.user);
        password = (EditText)findViewById(R.id.pass);
        iniciar = (Button) findViewById(R.id.button);
    }

    public void iniciar(View view){
        String usuario_string = usuario.getText().toString();
        String password_string = password.getText().toString();

        if(usuario_string.equals("admin") && password_string.equals("admin")) {
            Toast.makeText(this, "Espere un momento", Toast.LENGTH_LONG).show();
            Intent iniciar = new Intent(getApplicationContext(), Opciones.class);
            startActivity(iniciar);
        }else if(usuario_string.isEmpty() || password_string.isEmpty()){
            Toast.makeText(this,"ingrese un usuario", Toast.LENGTH_LONG).show();
        }else if(usuario_string != "admin"){
            Toast.makeText(this, "usuario incorrecto",Toast.LENGTH_LONG).show();
        }else if (password_string != "admin"){
            Toast.makeText(this, "pasword incorrecta",Toast.LENGTH_LONG).show();
        }








    }


}