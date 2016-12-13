package entidades;

/**
 * Created by 2096904 on 12/3/16.
 */

import java.io.Serializable;
import java.util.Date;


public class Mensajero extends Solicitante implements Serializable  {

    private int calificacion;

    public Mensajero(){
    }

    public Mensajero(int idSolicitante, String nombre, String primerApellido, String segundoApellido, int cedula,
                     int edad, Date fechaNacimiento, int telefono, String direccion, String pais, String municipio,
                     int codigoPostal, int calificacion) {

        super(idSolicitante, nombre, primerApellido, segundoApellido, cedula, edad, fechaNacimiento, telefono,
                direccion, pais, municipio, codigoPostal);

        this.calificacion = calificacion;
    }

    public int getCalificacion() {
        return calificacion;
    }

    /**
     * Created by 2096904 on 12/3/16.
     */
    public static class Pedido implements Serializable{

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
}