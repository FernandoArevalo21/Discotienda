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
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

/**
 *
 * @author usuario
 */
@Named(value = "loginController")
@SessionScoped
public class LoginController implements Serializable {
String correo;
String password;
 @Inject
    private LoginSession loginSession;
    /**
     * Creates a new instance of LoginController
     */
    public LoginController() {
        correo=null;
        password=null;
    }
@PostConstruct
void init(){
    String name=this.correo;
}
    public void Login() throws IOException{
    try {
        System.out.println("Entro " + correo + " " + password);
        Loginservice service = new Loginservice();
        if(service.VerDatosComprador(correo,password).equals("Admin")){
            FacesContext context = FacesContext.getCurrentInstance();
            loginSession.setLlave(service.getUser());
            //service = (Loginservice) context.getExternalContext().getSessionMap().get(loginSession.getLlave());
           /* context.getExternalContext().getSessionMap().put(service.getUser(), service);
            service = (Loginservice) context.getExternalContext().getSessionMap().get("");
            Map<String, Object> map= context.getExternalContext().getSessionMap();
            for(Map.Entry<String, Object> entrySet : map.entrySet()){
                String key= entrySet.getKey();
                System.out.println("Llave"+key);
            }*/
            FacesContext.getCurrentInstance().getExternalContext().redirect("/ProyectoLinea/faces/Administrador.xhtml");
        }else if(service.VerDatosComprador(correo,password).equals("comprador")){
            FacesContext context = FacesContext.getCurrentInstance();
             loginSession.setLlave(service.getUser());
            //service = (Loginservice) context.getExternalContext().getSessionMap().get(loginSession.getLlave());
            //context.addMessage(null,new FacesMessage("Exito","Bienvenido"+service.getUser()));
             /*FacesContext context = FacesContext.getCurrentInstance();
            context.getExternalContext().getSessionMap().put(service.getUser(), service);
            service = (Loginservice) context.getExternalContext().getSessionMap().get("");
            Map<String, Object> map= context.getExternalContext().getSessionMap();
            for(Map.Entry<String, Object> entrySet : map.entrySet()){
                String key= entrySet.getKey();
                System.out.println("Llave"+key);
            }*/
            FacesContext.getCurrentInstance().getExternalContext().redirect("/ProyectoLinea/faces/Comprador.xhtml");
        }else{
            loginSession.setLlave("-1");
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
