package com.example.ba.boxappandroid;

/**
 * Created by 2096904 on 12/3/16.
 */
import android.app.Activity;
import android.app.AlertDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.Date;

/**
 * Created by PILAR on 11/12/2016.
 */

public class Solicitante extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.producto);
        Button botonSol = (Button) findViewById(R.id.okRegSolicitante);


        botonSol.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){

                String nombre = ((EditText)findViewById(R.id.nombreSol)).getText().toString();
                String pApellido = ((EditText)findViewById(R.id.pApellido)).getText().toString();
                String sApellido = ((EditText)findViewById(R.id.sApellido)).getText().toString();
                int cedula = Integer.parseInt(((EditText)findViewById(R.id.cedula)).getText().toString());
                int edad = Integer.parseInt(((EditText)findViewById(R.id.edad)).getText().toString());
                int telefono = Integer.parseInt(((EditText)findViewById(R.id.telefono)).getText().toString());
                String direccion = ((EditText)findViewById(R.id.direccion)).getText().toString();
                String pais = ((EditText)findViewById(R.id.pais)).getText().toString();
                int postal = Integer.parseInt(((EditText)findViewById(R.id.codigoPostal)).getText().toString());


                entidades.Solicitante solicitante = new entidades.Solicitante(3, nombre, pApellido,
                        sApellido, cedula, edad,
                        new Date(87767576), telefono, direccion, pais, "Cundinamarca",
                        postal);

                Listas.getListas().addSolicitante(solicitante);

                AlertDialog.Builder alert = new AlertDialog.Builder(Solicitante.this);
                alert.setTitle("Registrado");
                alert.setMessage("Registro completado satisfactoriamente");
                alert.setPositiveButton("OK", null);
                alert.show();

            }
        });
    }

}
