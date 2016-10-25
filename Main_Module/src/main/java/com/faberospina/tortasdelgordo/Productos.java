package com.faberospina.tortasdelgordo;


public class Productos {

    private int id;
    private String namep;
    private String info;
    private int price;
    // Constructor de un objeto Contactos
    public Productos(int id, String np , String in, int pr) {
        this.id = id;
        this.namep = np;
        this.info = in;
        this.price = pr;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNamep() {
        return namep;
    }

    public void setNamep(String namep) {
        this.namep = namep;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
