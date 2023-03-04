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

    public boolean insertarPedido(Pedido paramPedido) throws SQLException {

        CallableStatement stmt;
        ConexionBD objConexionBD = new ConexionBD();
        objConexionBD.cargarDriver();
        objConexionBD.conectarDB();

        String query = "{CALL , insertarPedidoSP(?,?)}";

        try {
            stmt = objConexionBD.con.prepareCall(query);
            stmt.setString(1, paramPedido.getCodigoPed());
            stmt.setString(2, paramPedido.getArrProductosString());

            stmt.executeQuery();

            return true;

        } catch (SQLException ex) {
            Logger.getLogger(MetodosProductosSP.class.getName()).log(Level.SEVERE, null, ex);

            return false;

        } finally {
            try {
                objConexionBD.con.close();
            } catch (SQLException ex) {
                Logger.getLogger(MetodosProductosSP.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public boolean insertarProductoPedido(Pedido paramPedido) throws SQLException {

        CallableStatement stmt;
        ConexionBD objConexionBD = new ConexionBD();
        objConexionBD.cargarDriver();
        objConexionBD.conectarDB();

        String query = "{CALL actualizarPedidoSP(?,?)}";

        try {
            stmt = objConexionBD.con.prepareCall(query);
            stmt.setString(1, paramPedido.getCodigoPed());
            stmt.setString(2, paramPedido.getArrProductosString());

            stmt.executeQuery();

            return true;

        } catch (SQLException ex) {
            Logger.getLogger(MetodosProductosSP.class.getName()).log(Level.SEVERE, null, ex);

            return false;

        } finally {
            try {
                objConexionBD.con.close();
            } catch (SQLException ex) {
                Logger.getLogger(MetodosProductosSP.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public boolean mostrarPedido(Pedido paramPedido, DefaultTableModel modelo) throws SQLException {
        ResultSet rs;
        CallableStatement stmt;
        ConexionBD objConexionBD = new ConexionBD();
        objConexionBD.cargarDriver();
        objConexionBD.conectarDB();
        int cantidadColumnas = 4;
        String query = "{CALL mostrarProductoSP(?)}";

        try {
            stmt = objConexionBD.con.prepareCall(query);
            stmt.setString(1, paramPedido.getCodigoPed());
            rs = stmt.executeQuery();

            paramPedido.setCodigoPed(rs.getString("codigo_ped"));
            paramPedido.setArrProductosString(rs.getString("lista_productos"));

            //ResultSetMetaData rsMd = rs.getMetaData();
            

            Object[] filas = new Object[paramPedido.getArrProductos().size()];

            modelo.addColumn("Codigo_Producto");
            modelo.addColumn("Descripcion");
            modelo.addColumn("Precio unitario");
            modelo.addColumn("Stock");
            

            for (int i = 0; i < paramPedido.getArrProductos().size(); i++) {
                
                filas[0] = paramPedido.getArrProductos().get(i).getCodigoProd();
                filas[1] = paramPedido.getArrProductos().get(i).getDescripcion();
                filas[2] = paramPedido.getArrProductos().get(i).getPrecioUnitario();
                filas[3] = paramPedido.getArrProductos().get(i).getStock();
                modelo.addRow(filas);
            }

            return true;

        } catch (SQLException ex) {
            Logger.getLogger(MetodosProductosSP.class.getName()).log(Level.SEVERE, null, ex);

            return false;

        } finally {
            try {
                objConexionBD.con.close();
            } catch (SQLException ex) {
                Logger.getLogger(MetodosProductosSP.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public boolean eliminarProductoPedido(Pedido paramPedido) throws SQLException {

        CallableStatement stmt;
        ConexionBD objConexionBD = new ConexionBD();
        objConexionBD.cargarDriver();
        objConexionBD.conectarDB();

        String query = "{CALL actualizarPedidoSP(?,?)}";

        try {
            stmt = objConexionBD.con.prepareCall(query);
            stmt.setString(1, paramPedido.getCodigoPed());
            stmt.setString(2, paramPedido.getArrProductosString());
            stmt.executeQuery();

            return true;

        } catch (SQLException ex) {
            Logger.getLogger(MetodosProductosSP.class.getName()).log(Level.SEVERE, null, ex);

            return false;

        } finally {
            try {
                objConexionBD.con.close();
            } catch (SQLException ex) {
                Logger.getLogger(MetodosProductosSP.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
