/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.proyectolinea.pojo;

/**
 *
 * @author usuario
 */
public class Album {
    private String nombre_albun;
    private int precio_albun;
    private String nombre_artista;

    public Album(String nombre_albun, int precio_albun, String nombre_artista) {
        this.nombre_albun = nombre_albun;
        this.precio_albun = precio_albun;
        this.nombre_artista = nombre_artista;
    }
   public Album(){
       
   }

    public String getNombre_albun() {
        return nombre_albun;
    }

    public void setNombre_albun(String nombre_albun) {
        this.nombre_albun = nombre_albun;
    }

    public int getPrecio_albun() {
        return precio_albun;
    }

    public void setPrecio_albun(int precio_albun) {
        this.precio_albun = precio_albun;
    }

    public String getNombre_artista() {
        return nombre_artista;
    }

    public void setNombre_artista(String nombre_artista) {
        this.nombre_artista = nombre_artista;
    }
    
}
