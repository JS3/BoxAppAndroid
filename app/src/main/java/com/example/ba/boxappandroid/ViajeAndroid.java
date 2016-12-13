package com.example.ba.boxappandroid;

import android.app.Activity;
import android.app.AlertDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by 2096904 on 12/12/16.
 */

public class ViajeAndroid extends Activity {
    EditText origen;
    EditText destino;
    EditText ida;
    EditText llegada;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.viaje);
        origen = (EditText) findViewById(R.id.Origen);
        destino = (EditText) findViewById(R.id.Destino);
        ida = (EditText) findViewById(R.id.Ida);
        llegada = (EditText) findViewById(R.id.Llegada);

        {
            Button btnSelect = (Button) findViewById(R.id.btningresarv);
            btnSelect.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View v) {
                    if(origen.getText().length()==0){
                        origen.setError("No olvides tu origen!");
                    }else if(destino.getText().length()==0) {
                        destino.setError("No olvides tu destino!");
                    }else if(ida.getText().length()==0){
                        ida.setError("No olvides tu ida!");
                    }else if(llegada.getText().length()==0){
                        llegada.setError("No olvides tu llegada!");
                    }else{
                        postUser();
                      
                    }




                }
    });}}
        private void postUser() {
            AlertDialog.Builder alert = new AlertDialog.Builder(ViajeAndroid.this);
            alert.setTitle("Listo");
            alert.setMessage("Viaje registrado");
            alert.setPositiveButton("OK", null);
            alert.show();
            JSONObject json = new JSONObject();
            try {
                json.put("origen", origen);
            } catch (JSONException e) {
                e.printStackTrace();
            }
            try {
                json.put("destino", destino);
            } catch (JSONException e) {
                e.printStackTrace();
            }
            try {
                json.put("ida", ida);
            } catch (JSONException e) {
                e.printStackTrace();
            }
            try {
                json.put("llegada", llegada);
            } catch (JSONException e) {
                e.printStackTrace();
            }


}

}
