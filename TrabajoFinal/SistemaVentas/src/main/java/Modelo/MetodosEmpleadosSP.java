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
public class MetodosEmpleadosSP extends ConexionBD {

    public String validarUsuario(Empleados paramEmp) throws SQLException {

        CallableStatement stmt;
        ConexionBD objConexionBD = new ConexionBD();
        objConexionBD.cargarDriver();
        objConexionBD.conectarDB();
        System.out.println("validarUsuario");
        String query = "{CALL validarUsuarioEmpSP(?,?,?,?)}";
        System.out.println("Despues de callvalidarUsuario");
        try {
            stmt = objConexionBD.con.prepareCall(query);
            System.out.println("paramEmp.getUsuario():" + paramEmp.getUsuario());
            stmt.setString(1, paramEmp.getUsuario());
            System.out.println("paramEmp.getClave():" + paramEmp.getClave());
            stmt.setString(2, paramEmp.getClave());
            System.out.println("paramEmp.getPermisos():" + paramEmp.getPermisos());
            stmt.setString(3, paramEmp.getPermisos());

            stmt.executeQuery();

            stmt.registerOutParameter(4, Types.VARCHAR);

            return stmt.getString("resultadoParamSP");

        } catch (SQLException ex) {
            Logger.getLogger(MetodosEmpleadosSP.class.getName()).log(Level.SEVERE, null, ex);
            return "Error";

        } finally {
            try {
                objConexionBD.con.close();
            } catch (SQLException ex) {
                Logger.getLogger(MetodosEmpleadosSP.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public boolean insertarEmpleado(Empleados paramEmp) throws SQLException {

        CallableStatement stmt;
        ConexionBD objConexionBD = new ConexionBD();
        objConexionBD.cargarDriver();
        objConexionBD.conectarDB();

        String query = "{CALL insertarEmpleadoSP(?,?,?,?,?,?)}";

        try {
            stmt = objConexionBD.con.prepareCall(query);
            stmt.setString(1, paramEmp.getCodigo());
            stmt.setString(2, paramEmp.getNombre());
            stmt.setString(3, paramEmp.getApellido());
            stmt.setString(4, paramEmp.getPermisos()); 
            stmt.setString(5, paramEmp.getUsuario());
            stmt.setString(6, paramEmp.getClave());

            stmt.executeQuery();

            return true;

        } catch (SQLException ex) {
            Logger.getLogger(MetodosEmpleadosSP.class.getName()).log(Level.SEVERE, null, ex);

            return false;

        } finally {
            try {
                objConexionBD.con.close();
            } catch (SQLException ex) {
                Logger.getLogger(MetodosEmpleadosSP.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public boolean actualizarEmpleado(Empleados paramEmp) throws SQLException {

        CallableStatement stmt;
        ConexionBD objConexionBD = new ConexionBD();
        objConexionBD.cargarDriver();
        objConexionBD.conectarDB();

        String query = "{CALL actualizarEmpleadoSP(?,?,?,?,?,?)}";

        try {
            stmt = objConexionBD.con.prepareCall(query);
            stmt.setString(1, paramEmp.getCodigo());
            stmt.setString(2, paramEmp.getNombre());
            stmt.setString(3, paramEmp.getApellido());
            stmt.setString(4, paramEmp.getPermisos());
            stmt.setString(5, paramEmp.getUsuario());
            stmt.setString(6, paramEmp.getClave());

            stmt.executeQuery();

            return true;

        } catch (SQLException ex) {
            Logger.getLogger(MetodosEmpleadosSP.class.getName()).log(Level.SEVERE, null, ex);

            return false;

        } finally {
            try {
                objConexionBD.con.close();
            } catch (SQLException ex) {
                Logger.getLogger(MetodosEmpleadosSP.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public boolean mostrarEmpleado(Empleados paramEmp, DefaultTableModel modelo) throws SQLException {
        ResultSet rs;
        CallableStatement stmt;
        ConexionBD objConexionBD = new ConexionBD();
        objConexionBD.cargarDriver();
        objConexionBD.conectarDB();
        int cantidadColumnas;
        String query = "{CALL mostrarEmpleadoSP(?)}";

        try {
            stmt = objConexionBD.con.prepareCall(query);
            stmt.setString(1, paramEmp.getCodigo());
            rs = stmt.executeQuery();

            ResultSetMetaData rsMd = rs.getMetaData();
            cantidadColumnas = rsMd.getColumnCount();

            Object[] filas = new Object[cantidadColumnas];

            for (int i = 1; i <= cantidadColumnas; i++) {
                modelo.addColumn(rsMd.getColumnLabel(i));
            }

            while (rs.next()) {
                paramEmp.setCodigo(rs.getString("codigo"));
                paramEmp.setNombre(rs.getString("nombre"));
                paramEmp.setApellido(rs.getString("apellido"));
                paramEmp.setPermisos(rs.getString("permisos"));
                paramEmp.setUsuario(rs.getString("usuario"));
                paramEmp.setClave(rs.getString("clave"));

                for (int i = 0; i < cantidadColumnas; i++) {
                    filas[i] = rs.getObject(i + 1);
                }
                modelo.addRow(filas);
            }

            return true;

        } catch (SQLException ex) {
            Logger.getLogger(MetodosEmpleadosSP.class.getName()).log(Level.SEVERE, null, ex);

            return false;

        } finally {
            try {
                objConexionBD.con.close();
            } catch (SQLException ex) {
                Logger.getLogger(MetodosEmpleadosSP.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public boolean eliminarEmpleado(Empleados paramEmp) throws SQLException {

        CallableStatement stmt;
        ConexionBD objConexionBD = new ConexionBD();
        objConexionBD.cargarDriver();
        objConexionBD.conectarDB();

        String query = "{CALL eliminarEmpleadoSP(?)}";

        try {
            stmt = objConexionBD.con.prepareCall(query);
            stmt.setString(1, paramEmp.getCodigo());

            stmt.executeQuery();

            return true;

        } catch (SQLException ex) {
            Logger.getLogger(MetodosEmpleadosSP.class.getName()).log(Level.SEVERE, null, ex);

            return false;

        } finally {
            try {
                objConexionBD.con.close();
            } catch (SQLException ex) {
                Logger.getLogger(MetodosEmpleadosSP.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
