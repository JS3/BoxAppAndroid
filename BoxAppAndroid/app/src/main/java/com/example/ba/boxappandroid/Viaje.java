package com.example.ba.boxappandroid;

/**
 * Created by 2096904 on 12/3/16.
 */
import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author 2096904
 */
public class Viaje implements Serializable{
    private String Origen;
    private String Destino;
    private String Ida;
    private String Llegada;

    public Viaje(){

    }
    public String getOrigen() {
        return Origen;
    }

    public void setOrigen(String Origen) {
        this.Origen = Origen;
    }

    public String getDestino() {
        return Destino;
    }

    public void setDestino(String Destino) {
        this.Destino = Destino;
    }

    public String getIda() {
        return Ida;
    }

    public void setIda(String ida) {
        this.Ida = ida;
    }

    public String getLlegada() {
        return Llegada;
    }

    public void setLlegada(String llegada) {
        this.Llegada = llegada;
    }


}