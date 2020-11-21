/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.proyectolinea.controller;

import com.mycompany.proyectolinea.servic.Informacion_Artista;
import java.util.List;
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
    private String albunSeleccionado;
    private List<String> listaAlbun;
    /**
     * Creates a new instance of CancionesController
     */
    public CancionesController() {
        Informacion_Artista artista = new Informacion_Artista();
        listaAlbun = artista.listarAlbun();
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

    public String getAlbunSeleccionado() {
        return albunSeleccionado;
    }

    public void setAlbunSeleccionado(String albunSeleccionado) {
        this.albunSeleccionado = albunSeleccionado;
    }

    public List<String> getListaAlbun() {
        return listaAlbun;
    }

    public void setListaAlbun(List<String> listaAlbun) {
        this.listaAlbun = listaAlbun;
    }
    
    
}
