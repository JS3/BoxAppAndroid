package com.example.ba.boxappandroid;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

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

        Button bm4 = (Button) findViewById(R.id.btnRegister);

        bm4.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
//                findViewById(R.id.reg_fullname);

//                Intent i = new Intent(getApplicationContext(), listActivity.class);
//                startActivity(i);

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

        //MSTRJL
        Button bm6 = (Button) findViewById(R.id.btnProductos);

        bm6.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), ProductListActivity.class);
                startActivity(i);
            }
        });

        Button bm7 = (Button) findViewById(R.id.btnProductosPendientes);

        bm7.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), ProductListActivity.class);
                i.putExtra("ORDENA_POR_PENDIENTES", true);
                startActivity(i);
            }
        });

        Button bm8 = (Button) findViewById(R.id.btnProductosEntregados);

        bm8.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), ProductListActivity.class);
                i.putExtra("ORDENA_POR_ENTREGADOS", true);
                startActivity(i);
            }
        });
        //

    }
}