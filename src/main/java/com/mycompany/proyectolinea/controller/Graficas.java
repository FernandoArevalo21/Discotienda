package com.mycompany.proyectolinea.controller;
import com.mycompany.proyectolinea.pojo.DatosComprador;
import com.mycompany.proyectolinea.servic.Informacion_Artista;
import java.io.IOException;
import java.io.Serializable;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import org.primefaces.model.chart.PieChartModel;
/**
 *
 * @author Johan
 */
@Named(value = "graficas")
@RequestScoped
public class Graficas {
    @Inject
private LoginSession loginSession;

    private PieChartModel pieModel;
    private List<DatosComprador> datos;
    @PostConstruct
    void init(){
        if(loginSession.getLlave()==null){
        try {
            FacesContext.getCurrentInstance().getExternalContext().redirect("/ProyectoLinea/faces/index.xhtml");
        } catch (IOException ex) {
            Logger.getLogger(Graficas.class.getName()).log(Level.SEVERE, null, ex);
        }
        }
    }
    public Graficas() {
        Informacion_Artista artista = new Informacion_Artista();
        datos = artista.mostrarInformacion();
        graficar(datos);
    }
    private void graficar(List<DatosComprador>datos){
        pieModel = new PieChartModel();
        for(DatosComprador comprador : datos){
            pieModel.set(comprador.getCompra(),comprador.getPrecioCompra());
            System.out.println("Los datos son:"+datos);
        }
        pieModel.setTitle("Precios");
        pieModel.setLegendPosition("e");
        pieModel.setFill(false);
        pieModel.setShowDataLabels(true);
        pieModel.setDiameter(150);
    }
    public PieChartModel getPieModel() {
        return pieModel;
    }

    public void setPieModel(PieChartModel pieModel) {
        this.pieModel = pieModel;
    }

    public List<DatosComprador> getDatos() {
        return datos;
    }

    public void setDatos(List<DatosComprador> datos) {
        this.datos = datos;
    }
    
}
