package com.faberospina.tortasdelgordo;

/**
 * Created by Rios on 17/10/2016.
 * base
 */

public class Usuarios {
        private int id;
        private String usser;
        private String pass;
        private String email;
    // Constructor de un objeto Contactos
    public Usuarios(int id, String us, String pa, String em) {
        this.id = id;
        this.usser = us;
        this.pass = pa;
        this.email = em;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsser() {
        return usser;
    }

    public void setUsser(String usser) {
        this.usser = usser;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }
}
