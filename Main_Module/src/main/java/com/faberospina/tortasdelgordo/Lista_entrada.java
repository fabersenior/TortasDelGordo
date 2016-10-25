package com.faberospina.tortasdelgordo;

import java.util.Arrays;
import java.util.concurrent.locks.ReentrantLock;

import static java.lang.reflect.Array.get;

/**
 * Created by Faber on 27/09/2016.
 */

public class Lista_entrada {
    private int idImagen;
    private String nombre;
    private int precio;
    private  String info;
    private volatile transient Object[] array;


    public Lista_entrada(int idImagen, String nombre, int precio, String info){
        this.idImagen=idImagen;
        this.nombre=nombre;
        this.precio=precio;
        this.info=info;
    }

    public void Editlista(String nombre, int precio, String info){
        this.nombre=nombre;
        this.precio=precio;
        this.info=info;
    }

    public void Editlista(int idImagen,String nombre, int precio, String info){
        this.idImagen=idImagen;
        this.nombre=nombre;
        this.precio=precio;
        this.info=info;
    }



    public int getIdImagen() {
        return idImagen;
    }

    public void setIdImagen(int idImagen) {
        this.idImagen = idImagen;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

}
