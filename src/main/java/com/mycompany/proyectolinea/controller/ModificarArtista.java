/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.proyectolinea.controller;

import com.mycompany.proyectolinea.pojo.ActualizarArtista;
import com.mycompany.proyectolinea.pojo.Artista;
import com.mycompany.proyectolinea.servic.Informacion_Artista;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import org.primefaces.event.RowEditEvent;

/**
 *
 * @author Johan
 */
@Named(value = "modificarArtista")
@RequestScoped
public class ModificarArtista {
    private Artista artista = new Artista();
    private List<Artista> datos;
    private String nombre;
    /**
     * Creates a new instance of ModificarArtista
     */
    ActualizarArtista up = null;
    public ModificarArtista() {
        Informacion_Artista artista = new Informacion_Artista();
        datos = artista.modificarArtista();
        up = new ActualizarArtista();
    }

    public void actualizar(RowEditEvent editEvent) {
        Artista artista = (Artista) editEvent.getObject();
        artista.setNombreArtista(nombre);
        try {
            up.actualizaArtista(artista);
        } catch (SQLException ex) {
        } catch (ClassNotFoundException ex) {
        }
        //FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Actualización exitosa"));
    }
    public void cancelar(){
        
    }
    public Artista getArtista() {
        return artista;
    }

    public void setArtista(Artista artista) {
        this.artista = artista;
    }

    public List<Artista> getDatos() {
        return datos;
    }

    public void setDatos(List<Artista> datos) {
        this.datos = datos;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

}
