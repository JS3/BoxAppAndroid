package com.example.ba.boxappandroid;

import java.util.ArrayList;
import java.util.List;

import entidades.*;
import entidades.Mensajero;
import entidades.Producto;
import entidades.Solicitante;

/**
 * Created by JS3 on 11/12/16.
 */

public class Listas {

    private entidades.Solicitante solicitante;
    private entidades.Mensajero mensajero;
    private List<entidades.Producto> productos;

    private static Listas listas = null;

    private Listas(){
        this.solicitante = null;
        this.mensajero = null;
        this.productos = new ArrayList<>();
    }

    public static Listas getListas() {
        if (listas == null) listas = new Listas();
        return listas;
    }

    public Solicitante getSolicitante() {
        return solicitante;
    }

    public void setSolicitante(Solicitante solicitante) {
        this.solicitante = solicitante;
    }

    public Mensajero getMensajero() {
        return mensajero;
    }

    public void setMensajero(Mensajero mensajero) {
        this.mensajero = mensajero;
    }

    public List<Producto> getProductos() {
        return productos;
    }

    public void setProductos(List<Producto> productos) {
        this.productos = productos;
    }

    public void addProducto(entidades.Producto p){
        productos.add(p);
    }

    public void addSolicitante(entidades.Solicitante s){
        solicitante = s;
    }
}
