/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.proyectolinea.controller;

import com.mycompany.proyectolinea.pojo.Album;
import com.mycompany.proyectolinea.pojo.Comprador;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Spliterator;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;

/**
 *
 * @author usuario
 */
@Named(value = "paginaprincipalController")
@RequestScoped
public class PaginaprincipalController {
   private Album album = new Album();
   private List<Album> datos;
    /**
     * Creates a new instance of PaginaprincipalController
     */
    public PaginaprincipalController() {
    Comprador comprador=new Comprador();   
    datos=comprador.verAlbum();
    }
    
    public Album getAlbum() {
        return album;
    }

    public void setAlbum(Album album) {
        this.album = album;
    }

    public List<Album> getDatos() {
        return datos;
    }

    public void setDatos(List<Album> datos) {
        this.datos = datos;
    }

   
   
}
