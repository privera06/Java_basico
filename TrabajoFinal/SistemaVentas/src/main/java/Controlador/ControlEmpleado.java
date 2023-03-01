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
    public void iniciar() {
        varJfrVistaEmpPrinc.setTitle("EMPLEADOS");
        varJfrVistaEmpPrinc.setLocationRelativeTo(null);
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
                Logger.getLogger(ControlCliente.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        if (ev.getSource() == varJfrVistaEmpPrinc.jbAgregarEmp) {
            accion = "INSERT";
            varJfrVistaEmpSec.setVisible(true);
        }

        if (ev.getSource() == varJfrVistaEmpPrinc.jbActualizarEmp) {

            DefaultTableModel modelo = new DefaultTableModel();
            accion = "UPDATE";

            try {
                int filaTabla = varJfrVistaEmpPrinc.jtEmpleados.getSelectedRow();

                varModEmp.setCodigo(varJfrVistaEmpPrinc.jtEmpleados.getValueAt(filaTabla, 0).toString());
                varModEmp.setNombre(varJfrVistaEmpPrinc.jtEmpleados.getValueAt(filaTabla, 1).toString());
                varModEmp.setApellido(varJfrVistaEmpPrinc.jtEmpleados.getValueAt(filaTabla, 2).toString());
                varModEmp.setPermisos(varJfrVistaEmpPrinc.jtEmpleados.getValueAt(filaTabla, 3).toString());
                varModEmp.setUsuario(varJfrVistaEmpPrinc.jtEmpleados.getValueAt(filaTabla, 4).toString());
                varModEmp.setClave(varJfrVistaEmpPrinc.jtEmpleados.getValueAt(filaTabla, 5).toString());

                //varJfrVistaEmpSec.txtCodigo.setText(varModEmp.getCodigoCli()); Codigo no presente en vista
                varJfrVistaEmpSec.txtNombre.setText(varModEmp.getNombre());
                varJfrVistaEmpSec.txtApellido.setText(varModEmp.getApellido());
                varJfrVistaEmpSec.txtUsuario.setText(varModEmp.getUsuario());
                varJfrVistaEmpSec.txtClave.setText(varModEmp.getClave());

                varJfrVistaEmpSec.setVisible(true);

                if (!varMetEmp.mostrarEmpleado(varModEmp, modelo)) {
                    JOptionPane.showMessageDialog(null, "Error al realizar la actualizacion");
                }

            } catch (SQLException ex) {
                Logger.getLogger(ControlCliente.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        if (ev.getSource() == varJfrVistaEmpSec.jbGuardar) {
            /*Se setean las variables del Modelo obtenidas de las cajas de texto de la Vista*/
            //varModEmp.setCodigo(varJfrVistaEmpSec.txtCodigo.getText());
            varModEmp.setNombre(varJfrVistaEmpSec.txtNombre.getText());
            varModEmp.setApellido(varJfrVistaEmpSec.txtApellido.getText());
            varModEmp.setUsuario(varJfrVistaEmpSec.txtUsuario.getText());
            varModEmp.setClave(varJfrVistaEmpSec.txtClave.getText());
            varModEmp.setPermisos(varJfrVistaEmpSec.txtClave.getText()); //falta

            try {
                if ("INSERT".equals(accion)) {
                    if (varMetEmp.insertarEmpleado(varModEmp)) {
                        JOptionPane.showMessageDialog(null, "Registro exitoso");
                        varJfrVistaEmpSec.dispose();
                    } else {
                        JOptionPane.showMessageDialog(null, "Error al registrar");
                    }
                } else if ("UPDATE".equals(accion)) {
                    if (varMetEmp.actualizarEmpleado(varModEmp)) {
                        JOptionPane.showMessageDialog(null, "Actualizacion exitosa");
                        varJfrVistaEmpSec.dispose();
                    } else {
                        JOptionPane.showMessageDialog(null, "Error al actualizar");
                    }

                }

            } catch (SQLException ex) {
                Logger.getLogger(ControlCliente.class.getName()).log(Level.SEVERE, null, ex);
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
                Logger.getLogger(ControlCliente.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }
}
