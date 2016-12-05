package entidades;

import java.io.Serializable;

/**
 * Created by 2096904 on 12/3/16.
 */
public class Usuario implements Serializable{

    private String user, password, rol;

    public Usuario(String user, String password, String rol) {
        setUser(user);
        setPassword(password);
        setRol(rol);
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}