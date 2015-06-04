/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package alumnes.Modulos.GestioProfessors.Modelo.Clases;

import java.io.Serializable;

/**
 *
 * @author carlos
 */
public class Profesors implements Comparable<Profesors>, Serializable {

    private String user;
    private String pass;
    private String Email;
    private String tipo;
    private String estado;
    private String avatar;
    private String token;

    public Profesors(String user, String pass, String Email, String tipo,
            String estado, String avatar, String token) {

        this.user = user;
        this.pass = pass;
        this.Email = Email;
        this.tipo = tipo;
        this.estado = estado;
        this.avatar = avatar;
        this.token = token;
    }

    public Profesors() {
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String Estado) {
        this.estado = Estado;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String Avatar) {
        this.avatar = Avatar;
    }
    
      public String getToken() {
        return token;
    }

    public void setToken(String Token) {
        this.token = Token;
    }

    @Override
    public int compareTo(Profesors o) {
        if (this.getUser().compareTo(o.getUser()) > 0) {
            return 1;
        }
        if (this.getUser().compareTo(o.getUser()) < 0) {
            return -1;
        }
        return 0;
    }

    public boolean equals(Object a) {
        return getUser().equals(((Profesors) a).getUser());
    }

    public String toString() {
        StringBuffer tarjeta = new StringBuffer();
        tarjeta.append("User: " + getUser() + "\n");
        tarjeta.append("Password: " + getPass() + "\n");
        tarjeta.append("Email: " + getEmail() + "\n");
        tarjeta.append("Tipo: " + getTipo() + "\n");
        tarjeta.append("Estado: " + getEstado() + "\n");
        tarjeta.append("Avatar: " + getAvatar() + "\n");
        tarjeta.append("Token: " + getToken() + "\n");
        return tarjeta.toString();

    }
}
