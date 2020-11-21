/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.proyectolinea.controller;

import com.mycompany.proyectolinea.servic.Informacion_Artista;
import java.io.IOException;
import java.util.List;
import java.util.Spliterator;
import javax.annotation.PostConstruct;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import org.primefaces.model.menu.DefaultMenuItem;
import org.primefaces.model.menu.DefaultMenuModel;
import org.primefaces.model.menu.DefaultSubMenu;
import org.primefaces.model.menu.MenuModel;

/**
 *
 * @author Johan
 */
@Named(value = "administradorControlador")
@RequestScoped
public class AdministradorControlador {

    private List<String> datosAdministrador;
    private MenuModel model;
    
    public AdministradorControlador(){
        Informacion_Artista artista = new Informacion_Artista();
        datosAdministrador = artista.listarAdministrador();
        for (String datos : datosAdministrador) {
            System.out.println(datos);
        }
    }
    /**
     * Creates a new instance of AdministradorController
     */
    @PostConstruct
    public void init() {
        
        model = new DefaultMenuModel();
 
        //First submenu
        DefaultSubMenu firstSubmenu = DefaultSubMenu.builder()
                .label("Dynamic Submenu")
                .build();
 
        DefaultMenuItem item = DefaultMenuItem.builder()
                .value("External")
                .url("http://www.primefaces.org")
                .icon("pi pi-home")
                .build();
        firstSubmenu.getElements().add(item);
 
        model.getElements().add(firstSubmenu);
 
        //Second submenu
        DefaultSubMenu secondSubmenu = DefaultSubMenu.builder()
                .label("Dynamic Actions")
                .build();
 
        item = DefaultMenuItem.builder()
                .value("Save")
                .icon("pi pi-save")
                .command("#{menuView.save}")
                .update("messages")
                .build();
        secondSubmenu.getElements().add(item);
 
        item = DefaultMenuItem.builder()
                .value("Delete")
                .icon("pi pi-times")
                .command("#{menuView.delete}")
                .ajax(false)
                .build();
        secondSubmenu.getElements().add(item);
 
        item = DefaultMenuItem.builder()
                .value("Redirect")
                .icon("pi pi-search")
                .command("#{menuView.redirect}")
                .build();
        secondSubmenu.getElements().add(item);
 
        model.getElements().add(secondSubmenu);
    }
    public void cargarDatos() {
        Informacion_Artista artista = new Informacion_Artista();
        datosAdministrador = artista.listarAdministrador();
        for (String datos : datosAdministrador) {
            System.out.println(datos);   
        }   
    }
    public MenuModel getModel() {
        return model;
    }
 
    public void save() {
        
    }
 
    public void update() throws IOException {
        FacesContext.getCurrentInstance().getExternalContext().redirect("/ProyectoLinea/faces/Artista.xhtml");
    }

    public void delete() throws IOException {
        FacesContext.getCurrentInstance().getExternalContext().redirect("/ProyectoLinea/faces/Crearalbum.xhtml");
    }
        public void crearCancion() throws IOException {
        FacesContext.getCurrentInstance().getExternalContext().redirect("/ProyectoLinea/faces/Crearcanciones.xhtml");
    }
     
        public void registroadmin() throws IOException {
        FacesContext.getCurrentInstance().getExternalContext().redirect("/ProyectoLinea/faces/Registroadministrador.xhtml");
    }
    public void addMessage(String summary, String detail) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary, detail);
        FacesContext.getCurrentInstance().addMessage(null, message);
    }
        public List<String> getDatosAdministrador() {
        return datosAdministrador;
    }

    public void setDatosAdministrador(List<String> datosAdministrador) {
        this.datosAdministrador = datosAdministrador;
    }
}

