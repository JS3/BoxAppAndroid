package com.example.ba.boxappandroid;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by 2096904 on 12/12/16.
 */

public class ViajeAndroid extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.viaje); {
            Button btnSelect = (Button) findViewById(R.id.btningresarv);
            btnSelect.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View v) {
                    

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
    });
    }}
}
