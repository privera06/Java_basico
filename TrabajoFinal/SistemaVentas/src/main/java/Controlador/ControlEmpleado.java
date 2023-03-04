package Controlador;

import Modelo.Empleados;
import Modelo.MetodosEmpleadosSP;
import Vistas.VistaEmpleadosPrincipal;
import Vistas.VistaEmpleadosSecundaria;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Pamela
 */
public class ControlEmpleado implements ActionListener {

    /*Clases creadas en Modelo y Vista*/
    private Empleados varModEmp;
    private MetodosEmpleadosSP varMetEmp;
    private VistaEmpleadosPrincipal varJfrVistaEmpPrinc;
    private VistaEmpleadosSecundaria varJfrVistaEmpSec;
    String accion;
    /*Se crea el constructor de la clase y se le pasa el Modelo y la vista creada*/
    public ControlEmpleado(Empleados modEmp, MetodosEmpleadosSP metEmp, VistaEmpleadosPrincipal varJfrVistaEmpPrinc, VistaEmpleadosSecundaria jfrVistaEmpSec) {

        /*Se setean las variables con los valores recibidos en el Modelo y la Vista*/
        this.varModEmp = modEmp;
        this.varMetEmp = metEmp;
        this.varJfrVistaEmpPrinc = varJfrVistaEmpPrinc;
        this.varJfrVistaEmpSec = jfrVistaEmpSec;

        this.varJfrVistaEmpPrinc.jbAgregarEmp.addActionListener(this);
        this.varJfrVistaEmpPrinc.jbBuscarEmp.addActionListener(this);
        this.varJfrVistaEmpPrinc.jbEliminarEmp.addActionListener(this);
        this.varJfrVistaEmpPrinc.jbActualizarEmp.addActionListener(this);
        this.varJfrVistaEmpSec.jbGuardar.addActionListener(this);
    }

    /*Metodo para iniciar la vista*/
    public void iniciar() throws SQLException {
        varJfrVistaEmpPrinc.setTitle("EMPLEADOS");
        varJfrVistaEmpPrinc.setLocationRelativeTo(null);
        varJfrVistaEmpPrinc.setVisible(true);

        DefaultTableModel modelo = new DefaultTableModel();
        varJfrVistaEmpPrinc.jtEmpleados.setModel(modelo);

        varModEmp.setCodigo("");
        if (!varMetEmp.mostrarEmpleado(varModEmp, modelo))
            JOptionPane.showMessageDialog(null,"Ocurrio un error al mostrar la lista");
    }

    /*Metodo con las acciones que deben realizar los botones*/
    @Override
    public void actionPerformed(ActionEvent ev) {

        if (ev.getSource() == varJfrVistaEmpPrinc.jbBuscarEmp) {
            DefaultTableModel modelo = new DefaultTableModel();
            varJfrVistaEmpPrinc.jtEmpleados.setModel(modelo);

            varModEmp.setCodigo(varJfrVistaEmpPrinc.txtCodigo.getText());

            try {
                if (!varMetEmp.mostrarEmpleado(varModEmp, modelo)) {
                    JOptionPane.showMessageDialog(null, "Error al realizar la busqueda");
                }

            } catch (SQLException ex) {
                Logger.getLogger(ControlEmpleado.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        if (ev.getSource() == varJfrVistaEmpPrinc.jbAgregarEmp) {
            
            accion = "INSERT";
            
            varJfrVistaEmpSec.setLocationRelativeTo(null);
            varJfrVistaEmpSec.setVisible(true);

            varJfrVistaEmpSec.txtCodigo.setText("");
            varJfrVistaEmpSec.txtNombre.setText("");
            varJfrVistaEmpSec.txtApellido.setText("");
            varJfrVistaEmpSec.txtUsuario.setText("");
            varJfrVistaEmpSec.txtClave.setText("");            
            varJfrVistaEmpSec.checkboxClientes.setState(false);
            varJfrVistaEmpSec.checkboxEmpleados.setState(false);
            varJfrVistaEmpSec.checkboxProductos.setState(false);
            
        }

        if (ev.getSource() == varJfrVistaEmpPrinc.jbActualizarEmp) {

            accion = "UPDATE";

            int filaTabla = varJfrVistaEmpPrinc.jtEmpleados.getSelectedRow();
            String permisos;

            varModEmp.setCodigo(varJfrVistaEmpPrinc.jtEmpleados.getValueAt(filaTabla, 0).toString());
            varModEmp.setNombre(varJfrVistaEmpPrinc.jtEmpleados.getValueAt(filaTabla, 1).toString());
            varModEmp.setApellido(varJfrVistaEmpPrinc.jtEmpleados.getValueAt(filaTabla, 2).toString());
            varModEmp.setPermisos(varJfrVistaEmpPrinc.jtEmpleados.getValueAt(filaTabla, 3).toString());
            varModEmp.setUsuario(varJfrVistaEmpPrinc.jtEmpleados.getValueAt(filaTabla, 4).toString());
            varModEmp.setClave(varJfrVistaEmpPrinc.jtEmpleados.getValueAt(filaTabla, 5).toString());

            varJfrVistaEmpSec.setLocationRelativeTo(null);
            varJfrVistaEmpSec.setVisible(true);

            varJfrVistaEmpSec.txtCodigo.setText(varModEmp.getCodigo());
            varJfrVistaEmpSec.txtNombre.setText(varModEmp.getNombre());
            varJfrVistaEmpSec.txtApellido.setText(varModEmp.getApellido());
            varJfrVistaEmpSec.txtUsuario.setText(varModEmp.getUsuario());
            varJfrVistaEmpSec.txtClave.setText(varModEmp.getClave());
            permisos = varModEmp.getPermisos();
            
            if(permisos.contains("clientes"))
                varJfrVistaEmpSec.checkboxClientes.setState(true);
            
            if(permisos.contains("empleados"))
                varJfrVistaEmpSec.checkboxEmpleados.setState(true);
            
            if(permisos.contains("productos"))
                varJfrVistaEmpSec.checkboxProductos.setState(true);

        }

        if (ev.getSource() == varJfrVistaEmpSec.jbGuardar) {
            
            String varModEmp_ori = varModEmp.getCodigo();
            
            /*Se setean las variables del Modelo obtenidas de las cajas de texto de la Vista*/
            varModEmp.setCodigo(varJfrVistaEmpSec.txtCodigo.getText());
            varModEmp.setNombre(varJfrVistaEmpSec.txtNombre.getText());
            varModEmp.setApellido(varJfrVistaEmpSec.txtApellido.getText());
            varModEmp.setUsuario(varJfrVistaEmpSec.txtUsuario.getText());
            varModEmp.setClave(varJfrVistaEmpSec.txtClave.getText());
            String permisos = "";
            String separador= ";";

            if(varJfrVistaEmpSec.checkboxClientes.getState()){
                permisos="clientes";
            }
            if(varJfrVistaEmpSec.checkboxEmpleados.getState()){
                if(permisos.isEmpty())
                    permisos="empleados";
                else 
                    permisos=permisos+separador+"empleados";
            }
            if(varJfrVistaEmpSec.checkboxProductos.getState()){
                if(permisos.isEmpty())
                    permisos="productos";
                else 
                    permisos=permisos+separador+"productos";
            }
            
            varModEmp.setPermisos(permisos); 

            try {
                if ("INSERT".equals(accion)) {
                    if (varMetEmp.insertarEmpleado(varModEmp)) {
                        JOptionPane.showMessageDialog(null, "Registro exitoso");
                        varJfrVistaEmpSec.dispose();
                    } else {
                        JOptionPane.showMessageDialog(null, "Error al registrar");
                    }
                } else if ("UPDATE".equals(accion)) {
                    if (varMetEmp.actualizarEmpleado(varModEmp_ori, varModEmp)) {
                        JOptionPane.showMessageDialog(null, "Actualizacion exitosa");
                        varJfrVistaEmpSec.dispose();
                    } else {
                        JOptionPane.showMessageDialog(null, "Error al actualizar");
                    }

                }

            } catch (SQLException ex) {
                Logger.getLogger(ControlEmpleado.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        if (ev.getSource() == varJfrVistaEmpPrinc.jbEliminarEmp) {
            
            int filaTabla = varJfrVistaEmpPrinc.jtEmpleados.getSelectedRow();
            varModEmp.setCodigo(varJfrVistaEmpPrinc.jtEmpleados.getValueAt(filaTabla, 0).toString());

            try {
                if (varMetEmp.eliminarEmpleado(varModEmp)) {
                    JOptionPane.showMessageDialog(null, "Registro eliminado");
                } else {
                    JOptionPane.showMessageDialog(null, "Error al registrar");
                }
            } catch (SQLException ex) {
                Logger.getLogger(ControlEmpleado.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }
}
