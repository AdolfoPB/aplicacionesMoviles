package com.example.prueba1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText et1,et2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et1 = (EditText)findViewById(R.id.user);
        et2= (EditText)findViewById(R.id.password);

    }

    public void ingresar (View view) {

        // Transformar a String

        String user = et1.getText().toString();
        String password = et2.getText().toString();

        if (user.length() == 0) {
            Toast.makeText(this, "Debes ingresar tu usuario", Toast.LENGTH_LONG).show();
        }
        if (password.length() == 0) {
            Toast.makeText(this, "Debes ingresar tu contraseña", Toast.LENGTH_LONG).show();
        }

        if (user.equals("admin") && password.equals("1234")) {
            Toast.makeText(this, "ingresando a la app", Toast.LENGTH_SHORT).show();
            Intent ingresarSeleccionar = new Intent(this, seleccionar.class);
            startActivity(ingresarSeleccionar);

        } else if(password != "1234") {
            Toast.makeText(this, "Contraseña Incorrecta", Toast.LENGTH_SHORT).show();

        }
    }
    //metodo para mostrar y ocultar menu , mwtodo que recibe un parametro
    public boolean onCreateOptionMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    // metodo para asignar las funciones a las opciones

    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();
        // CODIGO PARA ENVIAR A UN FRAGEMENTO
        FragmentManager fm = getSupportFragmentManager();
        if (id == R.id.Salir) {
            Toast.makeText(this, "Salir", Toast.LENGTH_LONG).show();

            //finish();
            System.exit(0);
        }
        return super.onOptionsItemSelected(item);


    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // le pasamos a nuestra accion nuestro menu
        getMenuInflater().inflate(R.menu.menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    }
