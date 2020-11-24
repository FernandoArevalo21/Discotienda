package com.mycompany.proyectolinea.controller;

import com.mycompany.proyectolinea.servic.Informacion_Artista;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Johan
 */
@Named(value = "adminController")
@RequestScoped
public class AdminController {
    @Inject
private LoginSession loginSession;
    private List<String> datosAdministrador;
    Informacion_Artista artista = new Informacion_Artista();

    /**
     * Creates a new instance of AdminController
     */
    public AdminController() {
        //datosAdministrador = artista.listarAdministrador();
        datosAdministrador = artista.listarAdministrador();
        /*for (String datos : datosAdministrador) {
            System.out.println(datos);   
        } */ 
    }
    public void cargarDatos() {
        datosAdministrador = artista.listarAdministrador();
        for (String datos : datosAdministrador) {
            System.out.println(datos);   
        }   
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
    public void mostrarDatos() throws IOException{
        FacesContext.getCurrentInstance().getExternalContext().redirect("/ProyectoLinea/faces/MostrarInformacion.xhtml");
    }
    public void mosrarGraficas() throws IOException{
        FacesContext.getCurrentInstance().getExternalContext().redirect("/ProyectoLinea/faces/graficas.xhtml");
    }
    public void editarArtista() throws IOException{
        FacesContext.getCurrentInstance().getExternalContext().redirect("/ProyectoLinea/faces/ModificarArtista.xhtml");
    }
    public void addMessage(String summary, String detail) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary, detail);
        FacesContext.getCurrentInstance().addMessage(null, message);
    }
    public void cerrarSesion(){
        loginSession.setLlave(null);
        FacesContext context = FacesContext.getCurrentInstance();
        context.getExternalContext().invalidateSession();
    }

    public List<String> getDatosAdministrador() {
        return datosAdministrador;
    }

    public void setDatosAdministrador(List<String> datosAdministrador) {
        this.datosAdministrador = datosAdministrador;
    }
}
