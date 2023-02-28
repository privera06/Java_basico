package Modelo;

import java.sql.CallableStatement;
import java.sql.SQLException;
import java.sql.Types;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Pamela
 */
public class MetodosEmpleadosSP extends ConexionBD{
   
    public String validarUsuario (Empleados paramEmp) throws SQLException {

        CallableStatement stmt;
        ConexionBD objConexionBD = new ConexionBD();
        objConexionBD.cargarDriver();
        objConexionBD.conectarDB();
        System.out.println("validarUsuario");
        String query  = "{CALL validarUsuarioEmpSP(?,?,?,?)}";
        System.out.println("Despues de callvalidarUsuario");
        try{
            stmt = objConexionBD.con.prepareCall(query);
            System.out.println("paramEmp.getUsuario():"+paramEmp.getUsuario());
            stmt.setString(1, paramEmp.getUsuario());
            System.out.println("paramEmp.getClave():"+paramEmp.getClave());
            stmt.setString(2, paramEmp.getClave());
            System.out.println("paramEmp.getPermisos():"+paramEmp.getPermisos());
            stmt.setString(3, paramEmp.getPermisos());

            stmt.executeQuery(); 
            
            stmt.registerOutParameter(4, Types.VARCHAR);
            
            return stmt.getString("resultadoParamSP");
            
        } catch (SQLException ex) {
            Logger.getLogger(MetodosClientesSP.class.getName()).log(Level.SEVERE, null, ex);
            return "Error";
            
        } finally{
            try{
                objConexionBD.con.close();
            }catch(SQLException ex){
                Logger.getLogger(MetodosClientesSP.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
        
}
