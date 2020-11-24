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
public class Cancion {
    private String nombre_cancion;
    private String precio_cancion;
    private String nombre_albun;

    public Cancion(String nombre_cancion, String precio_cancion, String nombre_albun) {
        this.nombre_cancion = nombre_cancion;
        this.precio_cancion = precio_cancion;
        this.nombre_albun = nombre_albun;
    }

    public Cancion(){   
   }
    
    public String getNombre_cancion() {
        return nombre_cancion;
    }

    public void setNombre_cancion(String nombre_cancion) {
        this.nombre_cancion = nombre_cancion;
    }

    public String getPrecio_cancion() {
        return precio_cancion;
    }

    public void setPrecio_cancion(String precio_cancion) {
        this.precio_cancion = precio_cancion;
    }


    public String getNombre_albun() {
        return nombre_albun;
    }

    public void setNombre_albun(String nombre_albun) {
        this.nombre_albun = nombre_albun;
    }
    
    
}

