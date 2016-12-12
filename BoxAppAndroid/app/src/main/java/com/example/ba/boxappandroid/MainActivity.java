package com.example.ba.boxappandroid;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);
        TextView registerScreen = (TextView) findViewById(R.id.link_to_register);

        // Listening to register new account link
        registerScreen.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                // Switching to Register screen
                Intent i = new Intent(getApplicationContext(), Register.class);
                startActivity(i);
            }
        });

        Button bm2 = (Button) findViewById(R.id.btnLogin);

        bm2.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), product.class);
                startActivity(i);

            }
        });

        //MstrJL
        Button bm3 = (Button) findViewById(R.id.btnProductos);

        bm3.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), ProductListActivity.class);
                startActivity(i);
            }
        });

        Button bm4 = (Button) findViewById(R.id.btnProductosPendientes);

        bm4.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), ProductListActivity.class);
                i.putExtra("ORDENA_POR_PENDIENTES", true);
                startActivity(i);
            }
        });

        Button bm5 = (Button) findViewById(R.id.btnProductosEntregados);

        bm5.setOnClickListener(new View.OnClickListener() {

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
