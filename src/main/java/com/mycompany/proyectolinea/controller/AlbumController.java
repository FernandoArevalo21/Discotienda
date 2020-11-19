/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.proyectolinea.controller;

import com.mycompany.proyectolinea.servic.Informacion_Artista;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;

/**
 *
 * @author usuario
 */
@Named(value = "albumController")
@RequestScoped
public class AlbumController {
private String nombre_album;
private int precio_album;
    /**
     * Creates a new instance of AlbumController
     */
    public AlbumController() {
    }
    public void registroalbum() throws ClassNotFoundException{
        System.out.println("Entro"+""+nombre_album+""+precio_album);
        Informacion_Artista ifa = new Informacion_Artista();
        ifa.informacionArtista();
    }

    public String getNombre_album() {
        return nombre_album;
    }

    public void setNombre_album(String nombre_album) {
        this.nombre_album = nombre_album;
    }

    public int getPrecio_album() {
        return precio_album;
    }

    public void setPrecio_album(int precio_album) {
        this.precio_album = precio_album;
    }
    
}
