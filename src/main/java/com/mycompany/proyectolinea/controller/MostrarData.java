package com.mycompany.proyectolinea.controller;
import com.mycompany.proyectolinea.pojo.DatosComprador;
import com.mycompany.proyectolinea.servic.Informacion_Artista;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
/**
 *
 * @author Johan
 */
@Named(value = "mostrarData")
@RequestScoped
public class MostrarData {
       @Inject
   private LoginSession loginSession;
    private DatosComprador comprador = new DatosComprador();
    private List<DatosComprador> datos;

    /**
     * Creates a new instance of MostrarData
     */
     @PostConstruct
      void init(){
          if(loginSession.getLlave()==null){
           try {
               FacesContext.getCurrentInstance().getExternalContext().redirect("/ProyectoLinea/faces/index.xhtml");
           } catch (IOException ex) {
               Logger.getLogger(MostrarData.class.getName()).log(Level.SEVERE, null, ex);
           }
          }
      }
    public MostrarData() {
        Informacion_Artista artista = new Informacion_Artista();
        datos = artista.mostrarInformacion();

    }
    public DatosComprador getComprador() {
        return comprador;
    }

    public void setComprador(DatosComprador comprador) {
        this.comprador = comprador;
    }

    public List<DatosComprador> getDatos() {
        return datos;
    }

    public void setDatos(List<DatosComprador> datos) {
        this.datos = datos;
    }

}
