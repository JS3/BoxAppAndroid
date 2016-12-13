package com.example.ba.boxappandroid;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import entidades.*;
import entidades.Usuario;
import utils.Hashing;

/**
 * Created by 2096904 on 12/3/16.
 */
public class Register extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register);
        TextView loginScreen = (TextView) findViewById(R.id.link_to_login);

        // Listening to Login Screen link
        loginScreen.setOnClickListener(new View.OnClickListener() {

            public void onClick(View arg0) {
                // Closing registration screen
                // Switching to Login Screen/closing register screen
                finish();
            }
        });
        Button bm1 = (Button) findViewById(R.id.btnRegister);
        bm1.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                final EditText usernameText = (EditText) findViewById(R.id.reg_fullname);
                final EditText emailText = (EditText) findViewById(R.id.reg_email);
                final EditText passText = (EditText) findViewById(R.id.reg_password);

                String username = usernameText.getText().toString();
                String email = emailText.getText().toString();
                String pass = passText.getText().toString();

                if(!username.isEmpty() && !email.isEmpty() && !pass.isEmpty()) {
                    boolean matchEmail = Listas.getListas().checkEmail(email);
                    if(matchEmail) {
                        entidades.Usuario usernameUser = Listas.getListas().getUserByUsername(username);
                        entidades.Usuario emailUser = Listas.getListas().getUserByEmail(email);
                        if(usernameUser == null && emailUser == null) {
                            pass = Hashing.sha1(pass);
                            String rolUser = "USER";

                            final entidades.Usuario user = new entidades.Usuario(email, username, pass, rolUser);
                            Listas.getListas().addUser(user);

                            AlertDialog.Builder alert = new AlertDialog.Builder(Register.this);
                            alert.setTitle("Has sido registrado correctamente");
                            alert.setMessage("¡Bienvenido a BoxApp!");
                            alert.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    usernameText.setText("");
                                    emailText.setText("");
                                    passText.setText("");

                                    Intent i = new Intent(getApplicationContext(), MenuActivity.class);
                                    i.putExtra(MenuActivity.EXTRA_MESSAGE, user);
                                    startActivity(i);
                                }
                            });
                            alert.show();
                        } else {
                            if(usernameUser != null) {
                                usernameText.setError("Ya existe un usuario con ese username.");
                            }
                            if(emailUser != null) {
                                emailText.setError("Ya existe un usuario con ese email.");
                            }
                        }
                    } else {
                        emailText.setError("El email debe estar en su formato correspondiente.");
                    }

                } else {
                    if(username.isEmpty()) {
                        usernameText.setError("Debe ingresar el username.");
                    }
                    if(email.isEmpty()) {
                        emailText.setError("Debe ingresar el email.");
                    }
                    if(pass.isEmpty()) {
                        passText.setError("Debe ingresar el password.");
                    }
                }
            }
        });


    }
}
