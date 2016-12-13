package com.example.ba.boxappandroid;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

import entidades.*;
import entidades.Mensajero;
import entidades.Producto;
import entidades.Solicitante;
import entidades.Usuario;
import utils.Hashing;

/**
 * Created by JS3 on 11/12/16.
 */

public class Listas {
    public static final Pattern EMAIL_ADDRESS_PATTERN = Pattern.compile(
            "[a-zA-Z0-9\\+\\.\\_\\%\\-\\+]{1,256}" +
                    "\\@" +
                    "[a-zA-Z0-9][a-zA-Z0-9\\-]{0,64}" +
                    "(" +
                    "\\." +
                    "[a-zA-Z0-9][a-zA-Z0-9\\-]{0,25}" +
                    ")+"
    );

    private entidades.Solicitante solicitante;
    private entidades.Mensajero mensajero;
    private List<entidades.Producto> productos;
    private List<entidades.Usuario> usuarios;

    private static Listas listas = null;

    private Listas() {
        this.solicitante = null;
        this.mensajero = null;
        this.productos = new ArrayList<>();

        this.usuarios = new ArrayList<>();
        String rolUser = "USER";

        // Usuarios y contrasenas - quemado en codigo
        usuarios.add(new entidades.Usuario("user", "user@login.com", Hashing.sha1("password"), rolUser));
        usuarios.add(new entidades.Usuario("julian", "julian@boxapp.dev", Hashing.sha1("avuuna"), rolUser));
        usuarios.add(new entidades.Usuario("diana", "diana@boxapp.dev", Hashing.sha1("diana"), rolUser));
        usuarios.add(new entidades.Usuario("juan", "juan@boxapp.dev", Hashing.sha1("juan"), rolUser));
        usuarios.add(new entidades.Usuario("jose", "jose@boxapp.dev", Hashing.sha1("jose"), rolUser));
        usuarios.add(new entidades.Usuario("ramiro", "ramiro@boxapp.dev", Hashing.sha1("ramiro"), rolUser));
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

    public void addProducto(entidades.Producto p) {
        productos.add(p);
    }

    public void addSolicitante(entidades.Solicitante s) {
        solicitante = s;
    }

    public List<entidades.Usuario> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(List<entidades.Usuario> usuarios) {
        this.usuarios = usuarios;
    }

    /**
     * Permite registrar un usuario.
     *
     * @param user
     */
    public void addUser(entidades.Usuario user) {
        usuarios.add(user);
    }

    /**
     * Obtiene el usuario dado su username.
     *
     * @param username Username del usuario.
     * @return
     */
    public entidades.Usuario getUserByUsername(String username) {
        entidades.Usuario response = null;
        for (entidades.Usuario user : usuarios) {
            if (user.getUser().equals(username)) {
                response = user;
                break;
            }
        }
        return response;
    }

    /**
     * Obtiene el usuario dado su email.
     *
     * @param email Email del usuario.
     * @return
     */
    public entidades.Usuario getUserByEmail(String email) {
        entidades.Usuario response = null;
        for (entidades.Usuario user : usuarios) {
            if (user.getEmail().equals(email)) {
                response = user;
                break;
            }
        }
        return response;
    }

    /**
     * Logea a un usuario dado su username o email y su password.
     *
     * @param name Username o Email del usuario.
     * @param pass Password del usuario.
     * @return
     */
    public entidades.Usuario loginUser(String name, String pass) {
        entidades.Usuario response = null;
        for (entidades.Usuario user : usuarios) {
            if ((user.getUser().equals(name) || user.getEmail().equals(name)) && user.getPassword().equals(pass)) {
                response = user;
                break;
            }
        }
        return response;
    }

    /**
     * Fuente: http://stackoverflow.com/questions/1819142/how-should-i-validate-an-e-mail-address
     *
     * @param email
     * @return
     */
    public boolean checkEmail(String email) {
        return EMAIL_ADDRESS_PATTERN.matcher(email).matches();
    }
}
