package modelos;

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
    
    public boolean actualizarProducto (String paramProd_ori, Productos paramProd_new) throws SQLException {

        CallableStatement stmt;
        ConexionBD objConexionBD = new ConexionBD();
        objConexionBD.cargarDriver();
        objConexionBD.conectarDB();

        String query  = "{CALL actualizarProductoSP(?,?,?,?,?)}";
 
        try{
            stmt = objConexionBD.con.prepareCall(query);

            stmt.setString(1, paramProd_ori);
            stmt.setString(2, paramProd_new.getCodigoProd());
            stmt.setString(3, paramProd_new.getDescripcion());
            stmt.setDouble(4, paramProd_new.getPrecioUnitario());
            stmt.setInt(5, paramProd_new.getStock());

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
    
    public boolean mostrarProducto (Productos paramProd, DefaultTableModel modelo) throws SQLException {
        ResultSet rs;
        CallableStatement stmt;
        ConexionBD objConexionBD = new ConexionBD();
        objConexionBD.cargarDriver();
        objConexionBD.conectarDB();
        int cantidadColumnas;
        String query  = "{CALL mostrarProductoSP(?)}";
        
        try{
            stmt = objConexionBD.con.prepareCall(query);
            stmt.setString(1, paramProd.getCodigoProd());
            rs = stmt.executeQuery(); 
            
            ResultSetMetaData rsMd = rs.getMetaData();
            cantidadColumnas = rsMd.getColumnCount();
            
            Object[] filas = new Object[cantidadColumnas];
            
            for(int i=1; i<=cantidadColumnas; i++ ){
                modelo.addColumn(rsMd.getColumnLabel(i));
            }

            while(rs.next()){
                paramProd.setCodigoProd(rs.getString("codigo_prod"));
                paramProd.setDescripcion(rs.getString("descripcion"));
                paramProd.setPrecioUnitario(rs.getDouble("preciounitario"));
                paramProd.setStock(rs.getInt("stock"));

                for(int i=0 ; i< cantidadColumnas ; i++){
                    filas[i] = rs.getObject(i+1);
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
