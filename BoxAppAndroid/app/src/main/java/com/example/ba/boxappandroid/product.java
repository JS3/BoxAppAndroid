package com.example.ba.boxappandroid;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

import entidades.*;
import entidades.Producto;

/**
 * Created by 2096904 on 12/5/16.
 */

public class product extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.producto);
        Button bm3 = (Button) findViewById(R.id.btnlocalizar);

        bm3.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), MapsActivity.class);
                startActivity(i);

            }
        });

        Button bm4 = (Button) findViewById(R.id.btnRegistrarProducto);

        bm4.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
//                findViewById(R.id.reg_fullname);

//                Intent i = new Intent(getApplicationContext(), listActivity.class);
//                startActivity(i);

                String nombreProducto = ((EditText)findViewById(R.id.nombreProducto)).getText().toString();
                String descripcionProducto = "";
                Double peso = (new Double(((EditText)findViewById(R.id.peso)).getText().toString()));
                String paisOrigen = ((EditText)findViewById(R.id.origen)).getText().toString();
                String ciudadOrigen = ((EditText)findViewById(R.id.origenCiudad)).getText().toString();
                String paisDestino = ((EditText)findViewById(R.id.destino)).getText().toString();
                String ciudadDestino = ((EditText)findViewById(R.id.destinoCiudad)).getText().toString();

                entidades.Producto p = new entidades.Producto(Producto.ORIGEN, nombreProducto,
                        descripcionProducto, paisOrigen, ciudadOrigen, paisDestino, ciudadDestino,
                        peso, true, false);

                Listas.getListas().addProducto(p);

                AlertDialog.Builder alert = new AlertDialog.Builder(product.this);
                alert.setTitle("Producto registrado");
                alert.setMessage("El producto " + nombreProducto + " fue registrado satisfactoriamente");
                alert.setPositiveButton("OK", null);
                alert.show();

            }
        });
        Button bm5 = (Button) findViewById(R.id.btnimagen);

        bm5.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), ImagenActivity.class);
                startActivity(i);

            }
        });

    }
}