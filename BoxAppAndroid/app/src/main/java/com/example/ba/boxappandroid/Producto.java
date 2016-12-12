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

    public String getOrigen()
    {
        return origen;
    }

    public String getdestino()
    {
        return destino;
    }

//MSTRJL Un nuevo constructor para probar funciones

    public boolean isEntregado() {
        return entregado;
    }

    public void setEntregado(boolean entregado) {
        this.entregado = entregado;
    }

    private boolean entregado = false;

    public Producto(String nombre){
        this.nombre = nombre;
    }
}
