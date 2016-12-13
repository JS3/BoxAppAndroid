package com.example.ba.boxappandroid;

import android.app.AlertDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.prefs.Preferences;

import utils.Hashing;

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
                final EditText nameText = (EditText) findViewById(R.id.name);
                final EditText passText = (EditText) findViewById(R.id.pass);

                String name = nameText.getText().toString();
                String pass = passText.getText().toString();

                if(!name.isEmpty() && !pass.isEmpty()) {
                    pass = Hashing.sha1(pass);
                    final entidades.Usuario user = Listas.getListas().loginUser(name, pass);
                    if(user != null) {
                        nameText.setText("");
                        passText.setText("");

                        Intent i = new Intent(getApplicationContext(), MenuActivity.class);
                        i.putExtra(MenuActivity.EXTRA_MESSAGE, user);
                        startActivity(i);
                    } else {
                        nameText.setError("No se ha encontrado el usuario ingresado.");
                        passText.setText("");
                    }
                } else {
                    if(name.isEmpty()) {
                        nameText.setError("Debe ingresar el username o email.");
                    }
                    if(pass.isEmpty()) {
                        passText.setError("Debe ingresar el password.");
                    }
                }

            }
        });


    }
}
