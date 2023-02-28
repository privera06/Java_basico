/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;

/**
 *
 * @author Pamela
 */
public class MetodosEmpleadosSP extends ConexionBD{
    ResultSet rs;
    CallableStatement stmt;
    
    ConexionBD objConexionBD = new ConexionBD();
    
    public String getUsuarioValidoSP (String usuarioParamMetodo, String claveParamMetodo, String permisosParamMetodo) throws SQLException {
        String query  = "{CALL getUsuarioValido(?,?,?,?)}";
        stmt = objConexionBD.con.prepareCall(query);
        stmt.setString(1, usuarioParamMetodo);
        stmt.setString(2, claveParamMetodo);
        stmt.setString(3, permisosParamMetodo);
        stmt.registerOutParameter(4, Types.VARCHAR);
        rs = stmt.executeQuery();
        
        return stmt.getString("resultadoParamSP");
    }
    
    public void registrarUsuarioSP (String nombreParamMetodo, String apellidoParamMetodo, String permisosParamMetodo, String usuarioParamMetodo, String claveParamMetodo) throws SQLException {
        String query  = "{CALL registrarUsuario(?,?,?,?,?)}";
        stmt = objConexionBD.con.prepareCall(query);
        stmt.setString(1, nombreParamMetodo);
        stmt.setString(2, apellidoParamMetodo);
        stmt.setString(3, permisosParamMetodo);
        stmt.setString(4, usuarioParamMetodo);
        stmt.setString(5, claveParamMetodo);
        rs = stmt.executeQuery();
    }
    
    public void mostrarUsuariosSP (int codigoParamMetodo) throws SQLException {
        String query  = "{CALL mostrarUsuarios(?)}";
        stmt = objConexionBD.con.prepareCall(query);
        stmt.setInt(1, codigoParamMetodo);
        rs = stmt.executeQuery();
    }
    
    public void eliminarUsuariosSP (int codigoParamMetodo) throws SQLException {
        String query  = "{CALL eliminarUsuarios(?)}";
        stmt = objConexionBD.con.prepareCall(query);
        stmt.setInt(1, codigoParamMetodo);
        rs = stmt.executeQuery();
    }    
    
    public void actualizarUsuarioSP (int codigoParamMetodo, String nombreParamMetodo, String apellidoParamMetodo, String permisosParamMetodo, String usuarioParamMetodo, String claveParamMetodo) throws SQLException {
        String query  = "{CALL actualizar(?,?,?,?,?,?)}";
        stmt = objConexionBD.con.prepareCall(query);
        stmt.setInt(1, codigoParamMetodo);
        stmt.setString(2, nombreParamMetodo);
        stmt.setString(3, apellidoParamMetodo);
        stmt.setString(4, permisosParamMetodo);
        stmt.setString(5, usuarioParamMetodo);
        stmt.setString(6, claveParamMetodo);
        rs = stmt.executeQuery();
    }    
    
}
