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
            
            //System.out.println("MetodosPedidosSP -getArrProductosString = " + paramPedido.getArrProductosString(cad));
            cad=paramPedido.getArrProductosString(cad);
            //System.out.println("MetodosPedidosSP -cad = " + cad);
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
            //System.out.println(" MetodosPedidosSP.JAVA-insertarProductoPedido");

            stmt.setString(1, paramPedido.getCodigoPed());
            //System.out.println("MetodosPedidosSP.JAVA-insertarProductoPedido paramPedido.getArrProductosString(cadProducto)"+paramPedido.getArrProductosString(cadProducto));
            stmt.setString(2, paramPedido.getArrProductosString(cadProducto));
            //System.out.println("MetodosPedidosSP.JAVA-insertarProductoPedido-getArrProductosString = " + paramPedido.getArrProductosString(cadProducto));
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
            System.out.println(" paramPedido.getCodigoPed() "+paramPedido.getCodigoPed());
            rs = stmt.executeQuery();
            
            ResultSetMetaData rsMd = rs.getMetaData();
            cantidadColumnas = rsMd.getColumnCount();
            System.out.println(" cantidadColumnas "+cantidadColumnas);
            System.out.println(" MetodosPedidosSP.JAVA-mostrarPedido");
            Object[] filas = new Object[cantidadColumnas];
            //System.out.println(" paso filas");
            modelo.addColumn("Cod. Producto");
            modelo.addColumn("Descripcion");
            modelo.addColumn("Precio unitario");
            modelo.addColumn("Cantidad");
            
            
            while(rs.next()){
                paramPedido.setCodigoPed(rs.getString("codigo_ped"));
                /*System.out.println(" paramPedido.getCodigoPed()"+paramPedido.getCodigoPed());
                System.out.println(" cadena"+cadena);*/
                paramPedido.setArrProductosString(cadena);
                System.out.println(" paramPedido.getArrProductosString()"+ paramPedido.getArrProductosString(cadena));
                
            System.out.println(" MetodosPedidosSP.JAVA");
        /*System.out.println("agregarProducto = "+getArrProductos().get(0).getCodigoProd());
        System.out.println("agregarProducto = "+getArrProductos().get(0).getDescripcion());
        System.out.println("agregarProducto = "+getArrProductos().get(0).getPrecioUnitario());
          */  

            System.out.println(" MetodosPedidosSP.JAVA");
            System.out.println(" paramPedido.getArrProductos().size()"+paramPedido.getArrProductos().size());
            
            for (int i = 0; i < cantidadColumnas; i++) {
                System.out.println(" filas[0]..... ");
                filas[0] = paramPedido.getArrProductos().get(cantidadColumnas).getCodigoProd();
                System.out.println(" filas[0] "+filas[0]);
                filas[1] = paramPedido.getArrProductos().get(cantidadColumnas).getDescripcion();
                System.out.println(" filas[1] "+filas[1]);
                filas[2] = paramPedido.getArrProductos().get(cantidadColumnas).getPrecioUnitario();
                System.out.println(" filas[2] "+filas[2]);
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
