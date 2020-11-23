package com.mycompany.proyectolinea.pojo;

/**
 *
 * @author Johan
 */
public class DatosComprador {
    private String nombreComprador;
    private String compra;
    private int precioCompra;

    public DatosComprador() {
    }

    public DatosComprador(String nombreComprador, String compra, int precioCompra) {
        this.nombreComprador = nombreComprador;
        this.compra = compra;
        this.precioCompra = precioCompra;
    }
    
    public String getNombreComprador() {
        return nombreComprador;
    }

    public void setNombreComprador(String nombreComprador) {
        this.nombreComprador = nombreComprador;
    }

    public String getCompra() {
        return compra;
    }

    public void setCompra(String compra) {
        this.compra = compra;
    }

    public int getPrecioCompra() {
        return precioCompra;
    }

    public void setPrecioCompra(int precioCompra) {
        this.precioCompra = precioCompra;
    }
    
}
