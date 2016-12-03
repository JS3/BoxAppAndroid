package com.example.ba.boxappandroid;

import java.io.Serializable;

/**
 * Created by 2096904 on 12/3/16.
 */
public class Pedido implements Serializable{

    private Integer codigoPedido = 0;
    private Solicitante solicitante;
    private Mensajero mensajero;
    private Viaje viaje;

    public Pedido(Solicitante solicitante, Mensajero mensajero, Viaje viaje) {
        this.solicitante = solicitante;
        this.mensajero = mensajero;
        this.viaje = viaje;
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
}