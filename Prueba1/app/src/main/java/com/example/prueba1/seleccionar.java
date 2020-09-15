package com.example.prueba1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

public class seleccionar extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seleccionar);
    }

    public void vista_agenda (View view){
        Toast.makeText(this, "ingresando a Agenda", Toast.LENGTH_SHORT).show();
        Intent ingresarAgenda = new Intent(this,AgendaTelefonica.class);
        startActivity(ingresarAgenda);
    }

    public void vista_lista (View view){
        Toast.makeText(this, "ingresando a Lista de Contactos", Toast.LENGTH_SHORT).show();
        Intent ingresarLista= new Intent(this,ListaContactos.class);
        startActivity(ingresarLista);
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