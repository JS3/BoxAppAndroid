package com.example.ba.boxappandroid;

/**
 * Created by 2096904 on 12/7/16.
 */

import android.util.Log;

import com.example.ba.boxappandroid.Producto;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class Network
{

    private final ProductService service;

    public Network()
    {
        Retrofit retrofit = new Retrofit.Builder().baseUrl(
                "https://raw.githubusercontent.com/sancarbar/starting-android-lists/master/" ).
                addConverterFactory(GsonConverterFactory.create() ).build();
        service = retrofit.create( ProductService.class );
    }

    public List<Producto> getTeamsFromUrl( String serverUrl )
    {
        List<Producto> teams = new ArrayList<>();
        try
        {
            URL url = new URL( serverUrl );
            InputStreamReader inputStreamReader = new InputStreamReader( url.openStream() );
            BufferedReader bufferedReader = new BufferedReader( inputStreamReader );

            String line;
            StringBuilder stringBuilder = new StringBuilder();
            while ( ( line = bufferedReader.readLine() ) != null )
            {
                stringBuilder.append( line );
            }

            inputStreamReader.close();
            String json = stringBuilder.toString();
            JSONArray jsonArray = new JSONArray( json );
            for ( int i = 0; i < jsonArray.length(); i++ )
            {
                JSONObject jsonObject = jsonArray.getJSONObject( i );
                teams.add( new Producto( jsonObject ) );
            }

        }
        catch ( Exception e )
        {
            e.printStackTrace();
            Log.e( Network.class.getSimpleName(), "Error loading network data", e.getCause() );
        }
        return teams;
    }

    public List<Producto> getTeams()
            throws IOException
    {
        Call<List<Producto>> call = service.listTeams();
        Response<List<Producto>> response = call.execute();
        return response.body();
    }
}