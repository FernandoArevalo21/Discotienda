/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.proyectolinea.controller;

import com.mycompany.proyectolinea.servic.Informacion_album;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;

/**
 *
 * @author usuario
 */
@Named(value = "cancionesController")
@RequestScoped
public class CancionesController {
    private String nombre_cancion;
    private String precio_cancion;
    /**
     * Creates a new instance of CancionesController
     */
    public CancionesController() {
        Informacion_album album = new Informacion_album();
    }
    public void registrocancion(){
        System.out.println("Entro"+nombre_cancion+""+precio_cancion);       
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
    
}
