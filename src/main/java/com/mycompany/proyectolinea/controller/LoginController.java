/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.proyectolinea.controller;
import com.mycompany.proyectolinea.pojo.Comprador;
import com.mycompany.proyectolinea.servic.Informacion_Artista;
import com.mycompany.proyectolinea.servic.Loginservice;
import java.io.IOException;
import java.io.Serializable;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author usuario
 */
@Named(value = "loginController")
@SessionScoped
public class LoginController implements Serializable {
String correo;
String password;
    /**
     * Creates a new instance of LoginController
     */
    public LoginController() {
        correo=null;
        password=null;
    }

    public void Login() throws IOException{
    try {
        System.out.println("Entro " + correo + " " + password);
        Loginservice service = new Loginservice();
        if(service.VerDatosComprador(correo,password).equals("Admin")){
            FacesContext.getCurrentInstance().getExternalContext().redirect("/ProyectoLinea/faces/Administrador.xhtml");
        }else if(service.VerDatosComprador(correo,password).equals("comprador")){
            FacesContext.getCurrentInstance().getExternalContext().redirect("/ProyectoLinea/faces/Comprador.xhtml");
        }else{
            FacesContext.getCurrentInstance().getExternalContext().redirect("/ProyectoLinea/faces/Error.xhtml"); 
        }
    } catch (Exception ex) {
        Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
    }
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
}
