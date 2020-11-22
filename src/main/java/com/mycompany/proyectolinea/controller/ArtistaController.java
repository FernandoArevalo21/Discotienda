/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.proyectolinea.controller;

import com.mycompany.proyectolinea.pojo.datos;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.enterprise.context.RequestScoped;

import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import org.primefaces.PrimeFaces;
import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.file.UploadedFile;

/**
 *
 * @author usuario
 */
@Named(value = "artistaController")
@RequestScoped
public class ArtistaController  {

    private String nombre_artista;
    private String genero_musical;
    private String imagen;
    private String nacionalidad;
    private Date fecha_nacimiento;

    /**
     * Creates a new instance of ArtistaController
     */
    public ArtistaController() {
     nombre_artista=null;
     genero_musical=null;
     imagen=null;
     nacionalidad=null;
     fecha_nacimiento=null;
    }

    String ruta = "C:/xampp/imagenesProyectoLinea/";

    public void imagen(FileUploadEvent event) {
        UploadedFile uploadedFile = event.getFile();
        String filename = uploadedFile.getFileName();
        byte[] contents = uploadedFile.getContent();
        try {
            this.ruta += filename;
            FileOutputStream fileOutputStream = new FileOutputStream(this.ruta);
            fileOutputStream.write(contents);
            fileOutputStream.close();
        } catch (Exception e) {
            System.err.print(e);
        }
    }
String fecha;
    public void artista(Date fecha_nacimiento) throws IOException {
        System.out.println("Entro" + nombre_artista + "" + genero_musical + "" + nacionalidad + "" + fecha_nacimiento+""+ruta);
        SimpleDateFormat dateformat = new SimpleDateFormat("YYY-MM-dd");
        fecha=(dateformat.format(fecha_nacimiento));
        
        datos dt = new datos();
        dt.cagarDatosArtista(nombre_artista, genero_musical, ruta, nacionalidad,fecha);
         FacesContext.getCurrentInstance().getExternalContext().redirect("/ProyectoLinea/faces/Administrador.xhtml");
    }

    public String getNombre_artista() {
        return nombre_artista;
    }

    public void setNombre_artista(String nombre_artista) {
        this.nombre_artista = nombre_artista;
    }

    public String getGenero_musical() {
        return genero_musical;
    }

    public void setGenero_musical(String genero_musical) {
        this.genero_musical = genero_musical;
    }

    public String getNacionalidad() {
        return nacionalidad;
    }

    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    /*public String getFecha_nacimiento() {
        return fecha_nacimiento;
    }

    public void setFecha_nacimiento(String fecha_nacimiento) {
        this.fecha_nacimiento = fecha_nacimiento;
    }*/

    public Date getFecha_nacimiento() {
        return fecha_nacimiento;
    }

    public void setFecha_nacimiento(Date fecha_nacimiento) {
        this.fecha_nacimiento = fecha_nacimiento;
    }
    
}
