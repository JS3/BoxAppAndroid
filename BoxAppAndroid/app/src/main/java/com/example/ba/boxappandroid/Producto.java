package com.example.ba.boxappandroid;
import android.util.Log;
import org.json.JSONException;
import org.json.JSONObject;


public class Producto
{
    private int peso;

    private String nombre;

    private String origen;

    private String destino;

    public Producto()
    {
    }

    public Producto( JSONObject jsonObject )
    {
        try
        {
            peso = jsonObject.getInt( "peso" );
            nombre = jsonObject.getString( "nombre" );
            origen = jsonObject.getString( "origen" );
            destino = jsonObject.getString( "destino" );
        }
        catch ( JSONException e )
        {
            Log.e( Producto.class.getSimpleName(), "Error creating object from jsonObject: " + jsonObject, e );
        }
    }

    public String getName()
    {
        return nombre;
    }

    public String getnombre()
    {
        return origen;
    }

    public String getdestino()
    {
        return destino;
    }
}
