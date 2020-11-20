/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.proyectolinea.servic;

import com.mycompany.proyectolinea.conexion.conexion;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.enterprise.context.RequestScoped;
import javax.faces.bean.ViewScoped;
import javax.inject.Named;

/**
 *
 * @author usuario
 */
public class Loginservice {

    //mirar como hacer pruebas porque no sea podido ejecutar
    Connection conect = null;
    Statement st;
    String cor;
    String pass;
    String rol;
     conexion conexion = new conexion();
 
    public String VerDatosComprador(String correo, String password) throws SQLException {
                    st = conexion.conexion().createStatement();
        try {
            ResultSet rs = st.executeQuery("SELECT*FROM comprador where correo='" + correo + "' and password='" + password + "'");
            while (rs.next()) {
                cor = rs.getString("correo");
                pass = rs.getString("password");
                System.out.println(String.format("%s,%s", cor, pass));
            }
            if(cor.equalsIgnoreCase(correo)&& pass.equalsIgnoreCase(password)){
                rol="comprador";
            }
        } catch (Exception ex) {
            try {
                ResultSet rs = st.executeQuery("SELECT*FROM admin where correo='" + correo + "' and password='" + password + "'");
                while (rs.next()) {
                    cor = rs.getString("correo");
                    pass = rs.getString("password");
                    System.out.println(String.format("%s,%s", cor, pass));
                }
                if(cor.equalsIgnoreCase(correo)&& pass.equalsIgnoreCase(password)){
                rol="Admin";
            }
            } catch (Exception ex1) {
                rol=null;
            }
        }
        return rol;
    }
}
