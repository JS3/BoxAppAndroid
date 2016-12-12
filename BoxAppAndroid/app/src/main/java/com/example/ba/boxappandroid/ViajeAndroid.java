package com.example.ba.boxappandroid;

import android.app.Activity;
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
        origen = (EditText) findViewById(R.id.origen);
        destino = (EditText) findViewById(R.id.destino);
        ida = (EditText) findViewById(R.id.ida);
        llegada = (EditText) findViewById(R.id.llegada);

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
            JSONObject json = new JSONObject();
            try {
                json.put("name", "emil");
            } catch (JSONException e) {
                e.printStackTrace();
            }
            try {
                json.put("username", "emil111");
            } catch (JSONException e) {
                e.printStackTrace();
            }
            try {
                json.put("age", "111");
            } catch (JSONException e) {
                e.printStackTrace();
            }

}

}
