/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author andre
 */
public class Conexion {
   

    private static Connection cnx = null;
    static Statement sentencia;
    public static Connection obtener() throws SQLException, ClassNotFoundException {
        if (cnx == null) {
            try {
                Class.forName("com.mysql.jdbc.Driver");
                cnx = DriverManager.getConnection("jdbc:mysql://localhost/parqueadero", "root", "");
                 sentencia = cnx.createStatement();
                 if(cnx != null){
                 System.out.println("Conexion Establecida...");
                 }
            } 
            catch (ClassNotFoundException | SQLException e) {
            System.out.println("Error al Conectarse... " + e);
        }
            
           

        }
        return cnx;

    }

    }
