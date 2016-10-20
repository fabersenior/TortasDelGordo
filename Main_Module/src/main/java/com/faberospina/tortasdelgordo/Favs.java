package com.faberospina.tortasdelgordo;



public class Favs {
    private int id;
    private int ids;
    private int idp;
    // Constructor de un objeto Contactos
    public Favs(int id1, int ids1, int idp1) {
        this.id = id1;
        this.ids = ids1;
        this.idp = idp1;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIds() {
        return ids;
    }

    public void setIds(int ids) {
        this.ids = ids;
    }

    public int getIdp() {
        return idp;
    }

    public void setIdp(int idp) {
        this.idp = idp;
    }
}
