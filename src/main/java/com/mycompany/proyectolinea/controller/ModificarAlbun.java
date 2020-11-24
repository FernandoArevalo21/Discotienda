/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.proyectolinea.controller;

import com.mycompany.proyectolinea.pojo.ActualizarArtista;
import com.mycompany.proyectolinea.pojo.ActualizarDatosAlbun;
import com.mycompany.proyectolinea.pojo.Artista;
import com.mycompany.proyectolinea.pojo.DatosComprador;
import com.mycompany.proyectolinea.pojo.ModificarAlbunPojo;
import com.mycompany.proyectolinea.servic.Informacion_Artista;
import java.sql.SQLException;
import java.util.List;
import javax.inject.Named;
import javax.enterprise.context.Dependent;
import org.primefaces.event.RowEditEvent;

/**
 *
 * @author Johan
 */
@Named(value = "modificarAlbun")
@Dependent
public class ModificarAlbun {
    private String nombreAlbun;
    private String precioAlbun;
    private ModificarAlbunPojo modificar = new ModificarAlbunPojo();
    private List<ModificarAlbunPojo> datos;

    /**
     * Creates a new instance of MostrarData
     */
    ActualizarDatosAlbun up = null;
    public ModificarAlbun() {
        Informacion_Artista artista = new Informacion_Artista();
        datos = artista.modificarAlbun();
        up = new ActualizarDatosAlbun();
    }
        public void actualizar(RowEditEvent editEvent) {
        ModificarAlbunPojo albun = (ModificarAlbunPojo) editEvent.getObject();
        albun.setNombreAlbun(nombreAlbun);
        try {
            up.actualizaArtista(albun);
        } catch (SQLException ex) {
        } catch (ClassNotFoundException ex) {
        }
        //FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Actualización exitosa"));
    }
    public void cancelar(){
        
    }
    public String getNombreAlbun() {
        return nombreAlbun;
    }

    public void setNombreAlbun(String nombreAlbun) {
        this.nombreAlbun = nombreAlbun;
    }

    public String getPrecioAlbun() {
        return precioAlbun;
    }

    public void setPrecioAlbun(String precioAlbun) {
        this.precioAlbun = precioAlbun;
    }

    public ModificarAlbunPojo getModificar() {
        return modificar;
    }

    public void setModificar(ModificarAlbunPojo modificar) {
        this.modificar = modificar;
    }

    public List<ModificarAlbunPojo> getDatos() {
        return datos;
    }

    public void setDatos(List<ModificarAlbunPojo> datos) {
        this.datos = datos;
    }
    
}
