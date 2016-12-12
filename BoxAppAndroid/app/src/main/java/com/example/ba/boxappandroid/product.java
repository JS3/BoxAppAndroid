package com.example.ba.boxappandroid;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

/**
 * Created by 2096904 on 12/5/16.
 * Esta clase se encarga de implementar los inputs para agregar un producto.
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
                Intent i = new Intent(getApplicationContext(), listActivity.class);
                startActivity(i);
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