/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;

/**
 *
 * @author Pamela
 */
public class ConexionBD {
    ResourceBundle messages = ResourceBundle.getBundle("conexion");
    Connection con;
    
    public void cargarDriver() {
        try { 
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void conectarDB() throws SQLException {
        con = DriverManager.getConnection(messages.getString("url"), messages.getString("usuario"),messages.getString("clave"));
    }
    
}
