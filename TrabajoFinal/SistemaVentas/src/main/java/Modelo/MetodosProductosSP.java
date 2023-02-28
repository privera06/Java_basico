package Modelo;

import java.sql.ResultSet;
import java.sql.CallableStatement;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Pamela
 */
public class MetodosProductosSP extends ConexionBD{
    
    public int cantidadColumnas;
    public DefaultTableModel modelo = new DefaultTableModel();
    
    public boolean insertarProducto (Productos paramProd) throws SQLException {

        CallableStatement stmt;
        ConexionBD objConexionBD = new ConexionBD();
        objConexionBD.cargarDriver();
        objConexionBD.conectarDB();
        
        String query  = "{CALL insertarProductoSP(?,?,?,?)}";

        try{
            stmt = objConexionBD.con.prepareCall(query);
            stmt.setString(1, paramProd.getCodigoProd());
            stmt.setString(2, paramProd.getDescripcion());
            stmt.setDouble(3, paramProd.getPrecioUnitario());
            stmt.setInt(4, paramProd.getStock());

            stmt.executeQuery(); 
            
            return true;
            
        } catch (SQLException ex) {
            Logger.getLogger(MetodosProductosSP.class.getName()).log(Level.SEVERE, null, ex);
            
            return false;
            
        } finally{
            try{
                objConexionBD.con.close();
            }catch(SQLException ex){
                Logger.getLogger(MetodosProductosSP.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    public boolean actualizarProducto (Productos paramProd) throws SQLException {

        CallableStatement stmt;
        ConexionBD objConexionBD = new ConexionBD();
        objConexionBD.cargarDriver();
        objConexionBD.conectarDB();
                
        String query  = "{CALL actualizarProductoSP(?,?,?,?,?)}";
        
        try{
            stmt = objConexionBD.con.prepareCall(query);
            stmt.setString(1, paramProd.getCodigoProd());
            stmt.setString(2, paramProd.getCodigoProd());
            stmt.setString(3, paramProd.getDescripcion());
            stmt.setDouble(4, paramProd.getPrecioUnitario());
            stmt.setInt(5, paramProd.getStock());

            stmt.executeQuery(); 
            
            return true;
            
        } catch (SQLException ex) {
            Logger.getLogger(MetodosProductosSP.class.getName()).log(Level.SEVERE, null, ex);
            
            return false;
            
        } finally{
            try{
                objConexionBD.con.close();
            }catch(SQLException ex){
                Logger.getLogger(MetodosProductosSP.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    public boolean mostrarProducto (Productos paramProd) throws SQLException {
        ResultSet rs;
        CallableStatement stmt;
        ConexionBD objConexionBD = new ConexionBD();
        objConexionBD.cargarDriver();
        objConexionBD.conectarDB();
        
        String query  = "{CALL mostrarProductoSP(?)}";
        
        try{
            System.out.println("Antes0 executeQuery()");
            stmt = objConexionBD.con.prepareCall(query);
            System.out.println("Antes1 executeQuery()");
            stmt.setString(1, paramProd.getCodigoProd());
            System.out.println("Antes2 executeQuery()");
            rs = stmt.executeQuery(); 
            System.out.println("Paso executeQuery()");
            ResultSetMetaData rsMd = rs.getMetaData();
            cantidadColumnas = rsMd.getColumnCount();
            
            while(rs.next()){
                paramProd.setCodigoProd(rs.getString("codigo_prod"));
                paramProd.setDescripcion(rs.getString("descripcion"));
                paramProd.setPrecioUnitario(rs.getDouble("preciounitario"));
                paramProd.setStock(rs.getInt("stock"));

                modelo.addColumn("CodigoProd");
                modelo.addColumn("Descripcion");
                modelo.addColumn("PrecioUnitario");
                modelo.addColumn("Stock");

                Object[] filas = new Object[cantidadColumnas];

                for(int i=0 ; i< cantidadColumnas ; i++){
                    filas[i] = rs.getObject(i+1);
                    System.out.println("filas[i]"+filas[i]);
                }
                modelo.addRow(filas);
            }
            
            return true;
            
        } catch (SQLException ex) {
            Logger.getLogger(MetodosProductosSP.class.getName()).log(Level.SEVERE, null, ex);
            
            return false;
            
        } finally{
            try{
                objConexionBD.con.close();
            }catch(SQLException ex){
                Logger.getLogger(MetodosProductosSP.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    public boolean eliminarProducto (Productos paramProd) throws SQLException {

        CallableStatement stmt;
        ConexionBD objConexionBD = new ConexionBD();
        objConexionBD.cargarDriver();
        objConexionBD.conectarDB();
        
        String query  = "{CALL eliminarProductoSP(?)}";
        
        try{
            stmt = objConexionBD.con.prepareCall(query);
            stmt.setString(1, paramProd.getCodigoProd());

            stmt.executeQuery(); 
            
            return true;
            
        } catch (SQLException ex) {
            Logger.getLogger(MetodosProductosSP.class.getName()).log(Level.SEVERE, null, ex);
            
            return false;
            
        } finally{
            try{
                objConexionBD.con.close();
            }catch(SQLException ex){
                Logger.getLogger(MetodosProductosSP.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
