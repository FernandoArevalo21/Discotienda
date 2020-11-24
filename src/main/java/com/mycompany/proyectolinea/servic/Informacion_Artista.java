/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.proyectolinea.servic;

import com.mycompany.proyectolinea.conexion.conexion;
import com.mycompany.proyectolinea.pojo.DatosComprador;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.ArrayList;

/**
 *
 * @author usuario
 */
public class Informacion_Artista {
    conexion conexion = new conexion();
    Statement st;
    public void informacionArtista() {
        try {
            st = conexion.conexion().createStatement();
            ResultSet rs = st.executeQuery("SELECT*FROM artista");
            System.out.println("Consulta realizada");
            while (rs.next()) {
                int id_artista = rs.getInt("id_artista");
                String nombre_artista = rs.getString("nombre_artista");
                System.out.println(String.format("%s,%s", id_artista, nombre_artista));

            }
        } catch (SQLException e) {
            e.setNextException(e);
        }
    }
    public List<String> listar(){
        List<String>lista = null;
        try {
            st = conexion.conexion().createStatement();
            ResultSet rs = st.executeQuery("SELECT id_artista, nombre_artista FROM artista");
            System.out.println("Consulta realizada");
            lista = new ArrayList();
            while (rs.next()) {
                lista.add(Integer.toString(rs.getInt("id_artista"))+" "+rs.getString("nombre_artista"));
                //lista.add(rs.getString("nombre_artista"));
            }
        } catch (SQLException e) {
            e.setNextException(e);
        }
        return lista;
    }
    public List<String> listarAlbun() {
        List<String> lista = null;
        try {
            st = conexion.conexion().createStatement();
            ResultSet rs = st.executeQuery("SELECT id_albun, nombre_albun FROM albun");
            System.out.println("Consulta realizada");
            lista = new ArrayList();
            while (rs.next()) {
                lista.add(Integer.toString(rs.getInt("id_albun")) + " " + rs.getString("nombre_albun"));
                //lista.add(rs.getString("nombre_artista"));
            }
        } catch (SQLException e) {
            e.setNextException(e);
        }
        return lista;
    }
    public List<String> listarAdministrador() {
        List<String> lista = null;
        try {
            st = conexion.conexion().createStatement();
            ResultSet rs = st.executeQuery("SELECT username, nombre, correo FROM admin");
            System.out.println("Consulta realizada");
            lista = new ArrayList();
            while (rs.next()) {
                lista.add(rs.getString("nombre") + " " + rs.getString("correo")+" "+rs.getString("username"));
                //lista.add(rs.getString("nombre_artista"));
            }
        } catch (SQLException e) {
            e.setNextException(e);
        }
        return lista;
    }
    public ArrayList<DatosComprador> mostrarInformacion() {
        ArrayList<DatosComprador> lista = new ArrayList<>(); ;
        String nombre, compra, precio;
        try {
            
            st = conexion.conexion().createStatement();
            ResultSet rs = st.executeQuery("SELECT nombre_comprador, compra, precio_compra FROM informes");
            System.out.println("Consulta realizada!!!");
            lista = new ArrayList();
            while (rs.next()) {
                nombre = rs.getString("nombre_comprador");
                compra = rs.getString("compra");
                precio = rs.getString("precio_compra");
                System.out.println(rs.getString("nombre_comprador"));
                System.out.println(rs.getString("compra"));
                System.out.println(rs.getString("precio_compra"));
                lista.add(new DatosComprador(nombre,compra,Integer.parseInt(precio)));
            }
        } catch (SQLException e) {
            e.setNextException(e);
        }
        return lista;
    }
}
