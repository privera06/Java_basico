package Controlador;

import Modelo.Productos;
import Modelo.Pedido;
import Modelo.MetodosPedidosSP;
import Vistas.VistaEmpleadosPrincipal;
import Vistas.VistaPedidosPrincipal;
import Vistas.VistaPedidosSecundaria;
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
    private Pedido varModPedido;
    private Productos varModProductoPedido;
    private MetodosPedidosSP varMetPed;
    private VistaPedidosPrincipal varJfrVistaPedPrinc;
    private VistaPedidosSecundaria varJfrVistaPedSec;
    String accion;

    /*Se crea el constructor de la clase y se le pasa el Modelo y la vista creada*/
    public ControlPedido(Productos modProductoPedido, MetodosPedidosSP metPed, VistaPedidosPrincipal varJfrVistaPedPrinc, VistaPedidosSecundaria varJfrVistaPedSec) {

        /*Se setean las variables con los valores recibidos en el Modelo y la Vista*/
        this.varModProductoPedido = modProductoPedido;
        this.varMetPed = metPed;
        this.varJfrVistaPedPrinc = varJfrVistaPedPrinc;
        this.varJfrVistaPedSec = varJfrVistaPedSec;

        this.varJfrVistaPedPrinc.jbAgregarProdPedido.addActionListener(this);
        this.varJfrVistaPedPrinc.jbEliminarProdPedido.addActionListener(this);
        this.varJfrVistaPedPrinc.jbMostrarPedido.addActionListener(this);
        this.varJfrVistaPedSec.jbCerrar.addActionListener(this);
    }

    /*Metodo para iniciar la vista*/
    public void iniciar() {
        varJfrVistaPedPrinc.setTitle("PEDIDOS");
        varJfrVistaPedPrinc.setLocationRelativeTo(null);
        
        varJfrVistaPedSec.setTitle("VER PEDIDO");
        varJfrVistaPedSec.setLocationRelativeTo(null);
    }

    /*Metodo con las acciones que deben realizar los botones*/
    @Override
    public void actionPerformed(ActionEvent ev) {

        if (ev.getSource() == varJfrVistaPedPrinc.jbAgregarProdPedido) {
            DefaultTableModel modelo = new DefaultTableModel();
            

            int filaTabla = varJfrVistaPedPrinc.jtPedido.getSelectedRow(); //nos retorna un producto
            
            int idPedido = 0;
            varModPedido.setCodigoPed(varJfrVistaPedPrinc.txtIdPedido.getText());
            
            if(varModPedido.getCodigoPed().isEmpty()){
                accion = "INSERT";
            }
            else{
                accion = "UPDATE";
            }
            varModProductoPedido.setCodigoProd(varJfrVistaPedPrinc.jtPedido.getValueAt(filaTabla, 0).toString());
            varModProductoPedido.setDescripcion(varJfrVistaPedPrinc.jtPedido.getValueAt(filaTabla, 1).toString());
            varModProductoPedido.setPrecioUnitario(Double.parseDouble(varJfrVistaPedPrinc.jtPedido.getValueAt(filaTabla, 2).toString()));
            varModProductoPedido.setStock(Integer.parseInt(varJfrVistaPedPrinc.jtPedido.getValueAt(filaTabla, 3).toString()));
            
            varModPedido.agregarProducto(varModProductoPedido);
            
            try {

                if ("INSERT".equals(accion)) {
                    if (varMetPed.insertarPedido(varModPedido)) {
                        JOptionPane.showMessageDialog(null, "Pedido creado: "+idPedido);                        
                    } else {
                        JOptionPane.showMessageDialog(null, "Error al crear pedido");
                    }
                } else if ("UPDATE".equals(accion)) {
                    if (varMetPed.insertarProductoPedido(varModPedido)) {
                        JOptionPane.showMessageDialog(null, "Producto añadido");                        
                    } else {
                        JOptionPane.showMessageDialog(null, "Error al añadir producto");
                    }

                }

            } catch (SQLException ex) {
                Logger.getLogger(ControlCliente.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        if (ev.getSource() == varJfrVistaPedPrinc.jbMostrarPedido) {
            /*Se setean las variables del Modelo obtenidas de las cajas de texto de la Vista*/
            //varModProductoPedido.setCodigo(varJfrVistaEmpSec.txtCodigo.getText());

            DefaultTableModel modelo = new DefaultTableModel();
            varJfrVistaPedPrinc.jtPedido.setModel(modelo);

            varModPedido.setCodigoPed(varJfrVistaPedPrinc.txtIdPedido.getText());
            
            
            varJfrVistaPedSec.txtIdPedido.setText(varModPedido.getCodigoPed());
            varJfrVistaPedSec.setVisible(true);

            try {
                if (!varMetPed.mostrarPedido(varModPedido, modelo)) {
                    JOptionPane.showMessageDialog(null, "Error al realizar la busqueda del pedido");
                }

            } catch (SQLException ex) {
                Logger.getLogger(ControlCliente.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        if (ev.getSource() == varJfrVistaPedPrinc.jbEliminarProdPedido) {
            int filaTabla = varJfrVistaPedPrinc.jtPedido.getSelectedRow();

            varModPedido.setCodigoPed(varJfrVistaPedPrinc.txtIdPedido.getText());

            varModProductoPedido.setCodigoProd(varJfrVistaPedPrinc.jtPedido.getValueAt(filaTabla, 0).toString());

            varModPedido.eliminarProducto(varModProductoPedido);
            
            try {
                if (varMetPed.eliminarProductoPedido(varModPedido)) {
                    JOptionPane.showMessageDialog(null, "Producto eliminado");
                } else {
                    JOptionPane.showMessageDialog(null, "Error al eliminar");
                }
            } catch (SQLException ex) {
                Logger.getLogger(ControlCliente.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
