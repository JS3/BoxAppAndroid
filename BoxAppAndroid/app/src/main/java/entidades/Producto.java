package entidades;

import android.app.Activity;
import android.os.Bundle;

import java.io.Serializable;

/**
 * Created by 2096904 on 12/3/16.
 */
public class Producto implements Serializable {


    public final static String ORIGEN  = "ORIGEN";
    public final static String DESTINO = "DESTINO";

    private Integer idProducto = 0; // Autogenerado
    private String ubicacion; // "ORIGEN" o "DESTINO"
    private String nombre;
    private String descripcion;
    private String paisOrigen;
    private String ciudadOrigen;
    private String paisDestino;
    private String ciudadDestino;
    private Double peso;
    private Boolean delicado;
    private Boolean entregado; // False si no esta entrgado, True D.L.C.

    public Producto() {
    }

    public Producto(String ubicacion, String nombre, String descripcion, String paisOrigen, String ciudadOrigen, String paisDestino, String ciudadDestino, Double peso, Boolean delicado, Boolean entregado) {
        this.ubicacion = ubicacion;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.paisOrigen = paisOrigen;
        this.ciudadOrigen = ciudadOrigen;
        this.paisDestino = paisDestino;
        this.ciudadDestino = ciudadDestino;
        this.peso = peso;
        this.delicado = delicado;
        this.entregado = entregado;
    }

    public Producto(Integer idProducto, String ubicacion, String nombre, String descripcion, String paisOrigen, String ciudadOrigen, String paisDestino, String ciudadDestino, Double peso, Boolean delicado, Boolean entregado) {
        this(ubicacion, nombre, descripcion, paisOrigen, ciudadOrigen, paisDestino, ciudadDestino, peso, delicado, entregado);
        this.idProducto = idProducto;
    }

    public Integer getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(Integer idProducto) {
        this.idProducto = idProducto;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getPaisOrigen() {
        return paisOrigen;
    }

    public void setPaisOrigen(String paisOrigen) {
        this.paisOrigen = paisOrigen;
    }

    public String getCiudadOrigen() {
        return ciudadOrigen;
    }

    public void setCiudadOrigen(String ciudadOrigen) {
        this.ciudadOrigen = ciudadOrigen;
    }

    public String getPaisDestino() {
        return paisDestino;
    }

    public void setPaisDestino(String paisDestino) {
        this.paisDestino = paisDestino;
    }

    public String getCiudadDestino() {
        return ciudadDestino;
    }

    public void setCiudadDestino(String ciudadDestino) {
        this.ciudadDestino = ciudadDestino;
    }

    public Double getPeso() {
        return peso;
    }

    public void setPeso(Double peso) {
        this.peso = peso;
    }

    public Boolean getDelicado() {
        return delicado;
    }

    public void setDelicado(Boolean delicado) {
        this.delicado = delicado;
    }

    public Boolean getEntregado() {
        return entregado;
    }

    public void setEntregado(Boolean entregado) {
        this.entregado = entregado;
    }

}

