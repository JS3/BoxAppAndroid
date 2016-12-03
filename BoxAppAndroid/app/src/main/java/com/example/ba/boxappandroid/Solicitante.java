package com.example.ba.boxappandroid;

/**
 * Created by 2096904 on 12/3/16.
 */
import java.io.Serializable;
import java.util.Date;


public class Solicitante implements Serializable{

    private int idSolicitante; //Autogenerado
    private String nombre;
    private String primerApellido;
    private String segundoApellido;
    private String genero;
    private int cedula;
    private int edad;
    private Date fechaNacimiento;
    private int telefono;
    private String direccion;
    private String pais;
    private String municipio;
    private int codigoPostal;

    public Solicitante (){
    }

    public Solicitante(int idSolicitante, String nombre, String primerApellido, String segundoApellido, int cedula,
                       int edad, Date fechaNacimiento, int telefono, String direccion, String pais, String municipio,
                       int codigoPostal)
    {
        this.idSolicitante = idSolicitante;
        this.nombre = nombre;
        this.primerApellido = primerApellido;
        this.segundoApellido = segundoApellido;
        this.cedula = cedula;
        this.edad = edad;
        this.fechaNacimiento = fechaNacimiento;
        this.telefono = telefono;
        this.direccion = direccion;
        this.pais = pais;
        this.municipio = municipio;
        this.codigoPostal = codigoPostal;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setPrimerApellido(String primerApellido) {
        this.primerApellido = primerApellido;
    }

    public void setSegundoApellido(String segundoApellido) {
        this.segundoApellido = segundoApellido;
    }

    public void setCedula(int cedula) {
        this.cedula = cedula;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public void setMunicipio(String municipio) {
        this.municipio = municipio;
    }

    public void setCodigoPostal(int codigoPostal) {
        this.codigoPostal = codigoPostal;
    }

    public int getIdSolicitante() {
        return idSolicitante;
    }

    public String getNombre() {
        return nombre;
    }

    public String getPrimerApellido() {
        return primerApellido;
    }

    public String getSegundoApellido() {
        return segundoApellido;
    }

    public int getCedula() {
        return cedula;
    }

    public int getEdad() {
        return edad;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public int getTelefono() {
        return telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public String getPais() {
        return pais;
    }

    public String getMunicipio() {
        return municipio;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public int getCodigoPostal() { return codigoPostal; }
}