/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.proyectolinea.conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author usuario
 */

public class conexion {
     Connection conect = null;
    public Connection conexion() throws SQLException  {
        System.out.println("conexión"+conect);
         try {
                //Cargamos el Driver MySQL
                Class.forName("com.mysql.jdbc.Driver");
                //Se hace la conexión con el localhost y con la base de datos creada que en éste caso se llamí agata y "root" que por lo general es el usuario de ingreso
                conect = DriverManager.getConnection("jdbc:mysql://localhost/disco_tienda","root","");
              System.out.println("conexion establecida");
            } catch (ClassNotFoundException | SQLException e) {
                System.out.println("error de conexion");
            }
            return conect;
            
    }

    public Connection getConect() {
        return conect;
    }

    public void setConect(Connection conect) {
        this.conect = conect;
    }
    
}
