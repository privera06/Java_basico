package Controlador;

import Modelo.Productos;
import Modelo.MetodosProductosSP;
import Vistas.VistaEmpleadosPrincipal;
import Vistas.VistaPedidos;
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
public class ControlPedido implements ActionListener {

    /*Clases creadas en Modelo y Vista*/
    private Productos varModProductoPedido;
    private MetodosPedidosSP varMetPed;
    private VistaPedidos varJfrVistaPedPrinc;
    private VistaEmpleadosSecundaria varJfrVistaEmpSec;
    String accion;
    /*Se crea el constructor de la clase y se le pasa el Modelo y la vista creada*/
    public ControlPedido(Productos modProductoPedido, MetodosPedidosSP metPed, VistaPedidos varJfrVistaPedPrinc, VistaEmpleadosSecundaria jfrVistaEmpSec) {

        /*Se setean las variables con los valores recibidos en el Modelo y la Vista*/
        this.varModProductoPedido = modProductoPedido;
        this.varMetPed = metPed;
        this.varJfrVistaPedPrinc = varJfrVistaPedPrinc;
        this.varJfrVistaEmpSec = jfrVistaEmpSec;

        this.varJfrVistaPedPrinc.jbAgregarProd.addActionListener(this);
        this.varJfrVistaPedPrinc.jbEliminarProd.addActionListener(this);
        this.varJfrVistaPedPrinc.jbMostrarProductoPedido.addActionListener(this);        
        this.varJfrVistaEmpSec.jbGuardar.addActionListener(this);
    }

    /*Metodo para iniciar la vista*/
    public void iniciar() {
        varJfrVistaPedPrinc.setTitle("PEDIDOS");
        varJfrVistaPedPrinc.setLocationRelativeTo(null);
    }

    /*Metodo con las acciones que deben realizar los botones*/
    @Override
    public void actionPerformed(ActionEvent ev) {

        if (ev.getSource() == varJfrVistaPedPrinc.jbAgregarProd) {
            DefaultTableModel modelo = new DefaultTableModel();
            varJfrVistaPedPrinc.jtPedido.setModel(modelo);

            varModProductoPedido.setCodigo(varJfrVistaPedPrinc.txtCodigo.getText());

            try {
                if (!varMetPed.mostrarEmpleado(varModProductoPedido, modelo)) {
                    JOptionPane.showMessageDialog(null, "Error al realizar la busqueda");
                }

            } catch (SQLException ex) {
                Logger.getLogger(ControlCliente.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        if (ev.getSource() == varJfrVistaPedPrinc.jbAgregarEmp) {
            accion = "INSERT";
            varJfrVistaEmpSec.setVisible(true);
        }

        if (ev.getSource() == varJfrVistaPedPrinc.jbActualizarEmp) {

            DefaultTableModel modelo = new DefaultTableModel();
            accion = "UPDATE";

            try {
                int filaTabla = varJfrVistaPedPrinc.jtPedido.getSelectedRow();

                varModProductoPedido.setCodigo(varJfrVistaPedPrinc.jtPedido.getValueAt(filaTabla, 0).toString());
                varModProductoPedido.setNombre(varJfrVistaPedPrinc.jtPedido.getValueAt(filaTabla, 1).toString());
                varModProductoPedido.setApellido(varJfrVistaPedPrinc.jtPedido.getValueAt(filaTabla, 2).toString());
                varModProductoPedido.setPermisos(varJfrVistaPedPrinc.jtPedido.getValueAt(filaTabla, 3).toString());
                varModProductoPedido.setUsuario(varJfrVistaPedPrinc.jtPedido.getValueAt(filaTabla, 4).toString());
                varModProductoPedido.setClave(varJfrVistaPedPrinc.jtPedido.getValueAt(filaTabla, 5).toString());

                //varJfrVistaEmpSec.txtCodigo.setText(varModProductoPedido.getCodigoCli()); Codigo no presente en vista
                varJfrVistaEmpSec.txtNombre.setText(varModProductoPedido.getNombre());
                varJfrVistaEmpSec.txtApellido.setText(varModProductoPedido.getApellido());
                varJfrVistaEmpSec.txtUsuario.setText(varModProductoPedido.getUsuario());
                varJfrVistaEmpSec.txtClave.setText(varModProductoPedido.getClave());

                varJfrVistaEmpSec.setVisible(true);

                if (!varMetPed.mostrarEmpleado(varModProductoPedido, modelo)) {
                    JOptionPane.showMessageDialog(null, "Error al realizar la actualizacion");
                }

            } catch (SQLException ex) {
                Logger.getLogger(ControlCliente.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        if (ev.getSource() == varJfrVistaEmpSec.jbGuardar) {
            /*Se setean las variables del Modelo obtenidas de las cajas de texto de la Vista*/
            //varModProductoPedido.setCodigo(varJfrVistaEmpSec.txtCodigo.getText());
            varModProductoPedido.setNombre(varJfrVistaEmpSec.txtNombre.getText());
            varModProductoPedido.setApellido(varJfrVistaEmpSec.txtApellido.getText());
            varModProductoPedido.setUsuario(varJfrVistaEmpSec.txtUsuario.getText());
            varModProductoPedido.setClave(varJfrVistaEmpSec.txtClave.getText());
            varModProductoPedido.setPermisos(varJfrVistaEmpSec.txtClave.getText()); //falta

            try {
                if ("INSERT".equals(accion)) {
                    if (varMetPed.insertarEmpleado(varModProductoPedido)) {
                        JOptionPane.showMessageDialog(null, "Registro exitoso");
                        varJfrVistaEmpSec.dispose();
                    } else {
                        JOptionPane.showMessageDialog(null, "Error al registrar");
                    }
                } else if ("UPDATE".equals(accion)) {
                    if (varMetPed.actualizarEmpleado(varModProductoPedido)) {
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

        if (ev.getSource() == varJfrVistaPedPrinc.jbEliminarEmp) {
            int filaTabla = varJfrVistaPedPrinc.jtPedido.getSelectedRow();
            varModProductoPedido.setCodigo(varJfrVistaPedPrinc.jtPedido.getValueAt(filaTabla, 0).toString());

            try {
                if (varMetPed.eliminarEmpleado(varModProductoPedido)) {
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
