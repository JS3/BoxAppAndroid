package com.example.ba.boxappandroid;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;
import entidades.Producto;
/**
 * Created by MSTRJL on 10/12/16.
 */

public class Detalles extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detalles_producto);

        Intent intent = getIntent();
        Producto p = (Producto) intent.getSerializableExtra("PRODUCTO");

        TextView textView1 = (TextView) findViewById((R.id.id));
        textView1.setText(p.getIdProducto().toString());

        TextView textView2 = (TextView) findViewById((R.id.nombre));
        textView2.setText(p.getNombre());

        TextView textView3 = (TextView) findViewById((R.id.ubic));
        textView3.setText(p.getUbicacion());

        TextView textView4 = (TextView) findViewById((R.id.desc));
        textView4.setText(p.getDescripcion());

        TextView textView5 = (TextView) findViewById((R.id.pcO));
        textView5.setText(p.getPaisOrigen()+"/"+p.getCiudadOrigen());

        TextView textView6 = (TextView) findViewById((R.id.pcD));
        textView6.setText(p.getPaisDestino()+"/"+p.getCiudadDestino());

        TextView textView7 = (TextView) findViewById((R.id.peso));
        //Hago esto porque la aplicación se rompe cuando convierte null en String.
        String peso = "0";

        if(p.getPeso() != null)
            peso = p.getPeso().toString();

        textView7.setText(peso);

        TextView textView8 = (TextView) findViewById((R.id.del));

        String delicado = "null";

        if(p.getDelicado() != null) {

            delicado = "Si";
            if (!p.getDelicado())
                delicado = "No";
        }

        textView8.setText(delicado);

        TextView textView9 = (TextView) findViewById((R.id.entr));

        String entregado = "null";

        if(p.getEntregado() != null) {

            entregado = "Si";
            if (!p.getEntregado())
                entregado = "No";
        }

        textView9.setText(entregado);
    }
}
