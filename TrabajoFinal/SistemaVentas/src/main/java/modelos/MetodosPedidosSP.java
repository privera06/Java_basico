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
public class MetodosPedidosSP extends ConexionBD {

    public boolean insertarPedido(Pedido paramPedido, String cad) throws SQLException {

        CallableStatement stmt;
        ConexionBD objConexionBD = new ConexionBD();
        objConexionBD.cargarDriver();
        objConexionBD.conectarDB();

        String query = "{CALL insertarPedidoSP(?,?)}";

        try {
            stmt = objConexionBD.con.prepareCall(query);
            stmt.setString(1, paramPedido.getCodigoPed());
            stmt.setString(2, paramPedido.getArrProductosString(cad));
            
          stmt.executeQuery();

            return true;

        } catch (SQLException ex) {
            Logger.getLogger(MetodosPedidosSP.class.getName()).log(Level.SEVERE, null, ex);

            return false;

        } finally {
            try {
                objConexionBD.con.close();
            } catch (SQLException ex) {
                Logger.getLogger(MetodosPedidosSP.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public boolean insertarProductoPedido(Pedido paramPedido, String cadProducto) throws SQLException {

        CallableStatement stmt;
        ConexionBD objConexionBD = new ConexionBD();
        objConexionBD.cargarDriver();
        objConexionBD.conectarDB();

        String query = "{CALL actualizarPedidoSP(?,?)}";
        
        try {
            stmt = objConexionBD.con.prepareCall(query);

            stmt.setString(1, paramPedido.getCodigoPed());
            stmt.setString(2, paramPedido.getArrProductosString(cadProducto));

            stmt.executeQuery();
            
            return true;

        } catch (SQLException ex) {
            Logger.getLogger(MetodosPedidosSP.class.getName()).log(Level.SEVERE, null, ex);

            return false;

        } finally {
            try {
                objConexionBD.con.close();
            } catch (SQLException ex) {
                Logger.getLogger(MetodosPedidosSP.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public boolean mostrarPedido(Pedido paramPedido, DefaultTableModel modelo, String cadena) throws SQLException {
        ResultSet rs;
        CallableStatement stmt;
        ConexionBD objConexionBD = new ConexionBD();
        objConexionBD.cargarDriver();
        objConexionBD.conectarDB();
        int cantidadColumnas;
        String query = "{CALL mostrarPedidoSP(?)}";

        try {
            stmt = objConexionBD.con.prepareCall(query);
            stmt.setString(1, paramPedido.getCodigoPed());

            rs = stmt.executeQuery();
            
            ResultSetMetaData rsMd = rs.getMetaData();
            cantidadColumnas = rsMd.getColumnCount();

            Object[] filas = new Object[cantidadColumnas];
         
            
            while(rs.next()){
                paramPedido.setCodigoPed(rs.getString("codigo_ped"));
                paramPedido.setArrProductosString(cadena);
                          
            for (int i = 0; i < cantidadColumnas; i++) {
                filas[0] = paramPedido.getArrProductos().get(cantidadColumnas).getCodigoProd();
                filas[1] = paramPedido.getArrProductos().get(cantidadColumnas).getDescripcion();
                filas[2] = paramPedido.getArrProductos().get(cantidadColumnas).getPrecioUnitario();
                filas[3] = paramPedido.getArrProductos().get(cantidadColumnas).getStock();
                
                modelo.addRow(filas);
                }
            
            }

            return true;

        } catch (SQLException ex) {
            Logger.getLogger(MetodosPedidosSP.class.getName()).log(Level.SEVERE, null, ex);

            return false;

        } finally {
            try {
                objConexionBD.con.close();
            } catch (SQLException ex) {
                Logger.getLogger(MetodosPedidosSP.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public boolean eliminarProductoPedido(Pedido paramPedido, String cadProducto) throws SQLException {

        CallableStatement stmt;
        ConexionBD objConexionBD = new ConexionBD();
        objConexionBD.cargarDriver();
        objConexionBD.conectarDB();

        String query = "{CALL actualizarPedidoSP(?,?)}";

        try {
            stmt = objConexionBD.con.prepareCall(query);
            stmt.setString(1, paramPedido.getCodigoPed());
            stmt.setString(2, paramPedido.getArrProductosString(cadProducto));
            stmt.executeQuery();

            return true;

        } catch (SQLException ex) {
            Logger.getLogger(MetodosPedidosSP.class.getName()).log(Level.SEVERE, null, ex);

            return false;

        } finally {
            try {
                objConexionBD.con.close();
            } catch (SQLException ex) {
                Logger.getLogger(MetodosPedidosSP.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
