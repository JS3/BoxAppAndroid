package com.example.ba.boxappandroid;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MenuActivity extends AppCompatActivity {

    public final static String EXTRA_MESSAGE = "com.example.ba.boxappandroid.MenuActivity.MESSAGE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        Intent intent = getIntent();
        entidades.Usuario user = (entidades.Usuario) intent.getSerializableExtra(EXTRA_MESSAGE);
    }

    public void goToRegistrarseComoSolicitante(View view) {
        Intent i = new Intent(getApplicationContext(), SolicitanteActivity.class);
        startActivity(i);
    }

    public void goToRegistrarProducto(View view) {
        Intent i = new Intent(getApplicationContext(), product.class);
        startActivity(i);
    }

    //MSTRJL
    public void goToVerProductos(View view) {
        Intent i = new Intent(getApplicationContext(), ProductListActivity.class);
        startActivity(i);
    }

    public void goToVerProductosPendientes(View view) {
        Intent i = new Intent(getApplicationContext(), ProductListActivity.class);
        i.putExtra("ORDENA_POR_PENDIENTES", true);
        startActivity(i);
    }

    public void goToVerProductosEntregados(View view) {
        Intent i = new Intent(getApplicationContext(), ProductListActivity.class);
        i.putExtra("ORDENA_POR_ENTREGADOS", true);
        startActivity(i);
    }

    public void goToIngresarViaje(View view) {
        Intent i = new Intent(getApplicationContext(), ViajeAndroid.class);
        startActivity(i);
    }
    //

    public void logout(View view) {
        finish();
    }
}