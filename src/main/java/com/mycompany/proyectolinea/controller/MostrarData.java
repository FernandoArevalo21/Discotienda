package com.mycompany.proyectolinea.controller;
import com.mycompany.proyectolinea.pojo.DatosComprador;
import com.mycompany.proyectolinea.servic.Informacion_Artista;
import java.util.List;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
/**
 *
 * @author Johan
 */
@Named(value = "mostrarData")
@RequestScoped
public class MostrarData {
    private DatosComprador comprador = new DatosComprador();
    private List<DatosComprador> datos;

    /**
     * Creates a new instance of MostrarData
     */
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
