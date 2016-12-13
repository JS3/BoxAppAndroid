package com.example.ba.boxappandroid;

import java.io.Serializable;

import entidades.Solicitante;

import entidades.Producto;

/**
 * Created by 2096904 on 12/3/16.
 */
public class Pedido implements Serializable{

    public final static String ESPERA  = "Espera";
    public final static String ENVIANDO = "Enviando";
    public final static String ENTREGANDO = "Entregando";

    private Integer codigoPedido = 0;
    private Solicitante solicitante;
    private Mensajero mensajero;
    private Viaje viaje;

    private String estado = ESPERA;

    private Producto producto;

    public Pedido(Solicitante solicitante, Producto producto) {
        this.solicitante = solicitante;
        this.producto = producto;
    }

    public Pedido(Solicitante solicitante, Mensajero mensajero, Viaje viaje, Producto producto) {
        this.solicitante = solicitante;
        this.mensajero = mensajero;
        this.viaje = viaje;
        this.producto = producto;
    }

    public Integer getCodigoPedido() {
        return codigoPedido;
    }

    public void setCodigoPedido(Integer codigoPedido) {
        this.codigoPedido = codigoPedido;
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

    public Viaje getViaje() {
        return viaje;
    }

    public void setViaje(Viaje viaje) {
        this.viaje = viaje;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}