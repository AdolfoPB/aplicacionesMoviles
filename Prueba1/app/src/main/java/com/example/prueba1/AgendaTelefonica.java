package com.example.prueba1;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import java.util.ArrayList;

public class AgendaTelefonica extends AppCompatActivity {

    EditText et1;
    EditText et2;
    ListView lv1;
    Button btn1;
    String lista;
    ListView list;

    Integer index;

    ArrayList<String> arrayList = new ArrayList<String>();
    ArrayAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agenda_telefonica);

        et1 = (EditText) findViewById(R.id.nom);
        et2 = (EditText) findViewById(R.id.tel);
        lv1 = (ListView) findViewById(R.id.lv1);
        btn1 = (Button) findViewById(R.id.btn2);


        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, arrayList);
        lv1.setAdapter(adapter);

        // Seleccionar
        lv1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long id) {
                String s = lista = adapterView.getItemAtPosition(i).toString() + " se ha seleccionado : ";
                index = i;
                Toast.makeText(AgendaTelefonica.this, lista, Toast.LENGTH_SHORT).show();
            }
        });


    }

    public void registrar(View view) {
        if (et1.getText().toString().isEmpty()) {
            Toast.makeText(AgendaTelefonica.this, "Escribir Nombre",
                    Toast.LENGTH_SHORT).show();
            et1.requestFocus();
        }
        if (et2.getText().toString().isEmpty()) {
            Toast.makeText(AgendaTelefonica.this, "Escribir Telefono",
                    Toast.LENGTH_SHORT).show();
            et2.requestFocus();
        } else {
            String datosAgenda = et1.getText().toString() + " Tel." + et2.getText().toString();
            arrayList.add(datosAgenda);
            et1.setText("");
            et2.setText("");
            adapter.notifyDataSetChanged();
            Toast.makeText(AgendaTelefonica.this, "Nombre Agregado",
                    Toast.LENGTH_SHORT).show();
        }

        lv1.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {


            public boolean onItemLongClick(AdapterView<?> a, View v, final int i, long id) {
                String nombres = et1.getText().toString();

                AlertDialog.Builder adb = new AlertDialog.Builder(AgendaTelefonica.this);
                adb.setTitle("Eliminar");
                adb.setMessage("Realmente quieres borrar este contacto");
                final int positionToRemove = i;
                adb.setNegativeButton("Cancelar", null);
                adb.setPositiveButton("Borrar", new AlertDialog.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        arrayList.remove(i);
                        adapter.notifyDataSetChanged();
                        lv1.invalidateViews();
                        Toast.makeText(AgendaTelefonica.this, "Contacto eliminado", Toast.LENGTH_LONG).show();
                    }
                });
                adb.show();
                return false;
            }
        });
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









