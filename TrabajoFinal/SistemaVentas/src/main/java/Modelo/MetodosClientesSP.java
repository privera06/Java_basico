package Modelo;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Types;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Pamela
 */
public class MetodosClientesSP {
    
    public String validarUsuario (Clientes paramCli) throws SQLException {

        CallableStatement stmt;
        ConexionBD objConexionBD = new ConexionBD();
        objConexionBD.cargarDriver();
        objConexionBD.conectarDB();

        String query  = "{CALL validarUsuarioCliSP(?,?,?)}";

        try{
            stmt = objConexionBD.con.prepareCall(query);
            stmt.setString(1, paramCli.getDocumento());
            stmt.setString(2, paramCli.getClave());

            stmt.executeQuery(); 
            
            stmt.registerOutParameter(3, Types.VARCHAR);
            
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
        
    public boolean insertarCliente (Clientes paramCli) throws SQLException {

        CallableStatement stmt;
        ConexionBD objConexionBD = new ConexionBD();
        objConexionBD.cargarDriver();
        objConexionBD.conectarDB();
        
        String query  = "{CALL insertarClienteSP(?,?,?,?,?)}";

        try{
            stmt = objConexionBD.con.prepareCall(query);
            stmt.setString(1, paramCli.getCodigoCli());
            stmt.setString(2, paramCli.getNombre());
            stmt.setString(3, paramCli.getApellido());
            stmt.setString(4, paramCli.getDocumento());
            stmt.setString(5, paramCli.getClave());
            
            stmt.executeQuery(); 
            
            return true;
            
        } catch (SQLException ex) {
            Logger.getLogger(MetodosClientesSP.class.getName()).log(Level.SEVERE, null, ex);
            
            return false;
            
        } finally{
            try{
                objConexionBD.con.close();
            }catch(SQLException ex){
                Logger.getLogger(MetodosClientesSP.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    public boolean actualizarCliente (String paramCli_ori, Clientes paramCli_new) throws SQLException {

        CallableStatement stmt;
        ConexionBD objConexionBD = new ConexionBD();
        objConexionBD.cargarDriver();
        objConexionBD.conectarDB();
                
        String query  = "{CALL actualizarClienteSP(?,?,?,?,?,?)}";
        
        try{
            stmt = objConexionBD.con.prepareCall(query);
            stmt.setString(1, paramCli_ori);
            stmt.setString(2, paramCli_new.getCodigoCli());
            stmt.setString(3, paramCli_new.getNombre());
            stmt.setString(4, paramCli_new.getApellido());
            stmt.setString(5, paramCli_new.getDocumento());
            stmt.setString(6, paramCli_new.getClave());

            stmt.executeQuery(); 
            
            return true;
            
        } catch (SQLException ex) {
            Logger.getLogger(MetodosClientesSP.class.getName()).log(Level.SEVERE, null, ex);
            
            return false;
            
        } finally{
            try{
                objConexionBD.con.close();
            }catch(SQLException ex){
                Logger.getLogger(MetodosClientesSP.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    public boolean mostrarCliente (Clientes paramCli, DefaultTableModel modelo) throws SQLException {
        ResultSet rs;
        CallableStatement stmt;
        ConexionBD objConexionBD = new ConexionBD();
        objConexionBD.cargarDriver();
        objConexionBD.conectarDB();
        int cantidadColumnas;
        String query  = "{CALL mostrarClienteSP(?)}";
        
        try{
            stmt = objConexionBD.con.prepareCall(query);
            stmt.setString(1, paramCli.getCodigoCli());
            rs = stmt.executeQuery(); 
            
            ResultSetMetaData rsMd = rs.getMetaData();
            cantidadColumnas = rsMd.getColumnCount();
            
            Object[] filas = new Object[cantidadColumnas];
            
            for(int i=1; i<=cantidadColumnas; i++ ){
                modelo.addColumn(rsMd.getColumnLabel(i));
            }

            while(rs.next()){
                paramCli.setCodigoCli(rs.getString("codigo_cli"));
                paramCli.setNombre(rs.getString("nombre"));
                paramCli.setApellido(rs.getString("apellido"));
                paramCli.setDocumento(rs.getString("documento"));
                paramCli.setClave(rs.getString("clave"));

                for(int i=0 ; i< cantidadColumnas ; i++){
                    filas[i] = rs.getObject(i+1);
                }
                modelo.addRow(filas);
            }
            
            return true;
            
        } catch (SQLException ex) {
            Logger.getLogger(MetodosClientesSP.class.getName()).log(Level.SEVERE, null, ex);
            
            return false;
            
        } finally{
            try{
                objConexionBD.con.close();
            }catch(SQLException ex){
                Logger.getLogger(MetodosClientesSP.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    public boolean eliminarCliente (Clientes paramCli) throws SQLException {

        CallableStatement stmt;
        ConexionBD objConexionBD = new ConexionBD();
        objConexionBD.cargarDriver();
        objConexionBD.conectarDB();
        
        String query  = "{CALL eliminarClienteSP(?)}";
        
        try{
            stmt = objConexionBD.con.prepareCall(query);
            stmt.setString(1, paramCli.getCodigoCli());

            stmt.executeQuery(); 
            
            return true;
            
        } catch (SQLException ex) {
            Logger.getLogger(MetodosClientesSP.class.getName()).log(Level.SEVERE, null, ex);
            
            return false;
            
        } finally{
            try{
                objConexionBD.con.close();
            }catch(SQLException ex){
                Logger.getLogger(MetodosClientesSP.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
