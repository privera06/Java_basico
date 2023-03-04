package modelos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javax.swing.JOptionPane;

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
            JOptionPane.showMessageDialog(null,e);
        }
    }
    
    public void conectarDB() throws SQLException {
        con = DriverManager.getConnection(messages.getString("url"), messages.getString("usuario"),messages.getString("clave"));
    }
    
}
