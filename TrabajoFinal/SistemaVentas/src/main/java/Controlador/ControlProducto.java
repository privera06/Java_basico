package Controlador;

import Modelo.MetodosProductosSP;
import Modelo.Productos;
import Vistas.VistaProductosPrincipal;
import Vistas.VistaProductosSecundaria;
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
public class ControlProducto implements ActionListener {
    /*Clases creadas en Modelo y Vista*/
    private Productos varModProd;
    private MetodosProductosSP varMetProd;
    private VistaProductosPrincipal varJfrVistaProd;
    private VistaProductosSecundaria varJfrVistaProdSec;
    String accion;
    /*Se crea el constructor de la clase y se le pasa el Modelo y la vista creada*/
    public ControlProducto(Productos modProd, MetodosProductosSP metProd, VistaProductosPrincipal jfrVistaProd, VistaProductosSecundaria jfrVistaProdSec){
        
        /*Se setean las variables con los valores recibidos en el Modelo y la Vista*/
        this.varModProd = modProd;
        this.varMetProd = metProd;
        this.varJfrVistaProd = jfrVistaProd;
        this.varJfrVistaProdSec = jfrVistaProdSec;
        
        this.varJfrVistaProd.jbAgregarProd.addActionListener(this);
        this.varJfrVistaProd.jbBuscarProd.addActionListener(this);
        this.varJfrVistaProd.jbEliminarProd.addActionListener(this);
        this.varJfrVistaProd.jbActualizarProd.addActionListener(this);
        this.varJfrVistaProdSec.jbGuardar.addActionListener(this);
    }
    /*Metodo para iniciar la vista*/
    public void iniciar(){
        varJfrVistaProd.setTitle("PRODUCTOS");
        varJfrVistaProd.setLocationRelativeTo(null);
        varJfrVistaProd.setVisible(true);
    }
    
    /*Metodo con las acciones que deben realizar los botones*/
    @Override
    public void actionPerformed(ActionEvent ev ){
        
        if(ev.getSource() == varJfrVistaProd.jbBuscarProd){
            DefaultTableModel modelo = new DefaultTableModel();
            varJfrVistaProd.jtProductos.setModel(modelo);
            
            varModProd.setCodigoProd(varJfrVistaProd.jtCodigo.getText());
            
            try {
                if(!varMetProd.mostrarProducto(varModProd, modelo))
                    JOptionPane.showMessageDialog(null,"Error al realizar la busqueda");
                
            } catch (SQLException ex) {
                Logger.getLogger(ControlProducto.class.getName()).log(Level.SEVERE, null, ex);
            }        
        }
    
        if(ev.getSource() == varJfrVistaProd.jbAgregarProd){
            accion = "INSERT";
            varJfrVistaProdSec.setVisible(true);
        }

        if(ev.getSource() == varJfrVistaProd.jbActualizarProd){

            DefaultTableModel modelo = new DefaultTableModel();
            accion = "UPDATE";

            try {
                int filaTabla = varJfrVistaProd.jtProductos.getSelectedRow();   

                varModProd.setCodigoProd(varJfrVistaProd.jtProductos.getValueAt(filaTabla, 0).toString());                
                varModProd.setDescripcion(varJfrVistaProd.jtProductos.getValueAt(filaTabla, 1).toString()); 
                varModProd.setPrecioUnitario(Double.parseDouble(varJfrVistaProd.jtProductos.getValueAt(filaTabla, 2).toString()));
                varModProd.setStock(Integer.parseInt(varJfrVistaProd.jtProductos.getValueAt(filaTabla, 3).toString()));
                
                varJfrVistaProdSec.txtCodProd.setText(varModProd.getCodigoProd());
                varJfrVistaProdSec.txtDescripcion.setText(varModProd.getDescripcion());
                varJfrVistaProdSec.txtPrecio.setText(Double.toString(varModProd.getPrecioUnitario()));
                varJfrVistaProdSec.txtStock.setText(String.valueOf(varModProd.getStock()));
                
                varJfrVistaProdSec.setVisible(true);
                
                if(!varMetProd.mostrarProducto(varModProd,modelo)){
                    JOptionPane.showMessageDialog(null,"Error al realizar la actualizacion");
                }
                    
            }catch (SQLException ex) {
                Logger.getLogger(ControlProducto.class.getName()).log(Level.SEVERE, null, ex);
            }
        }        
        
        if(ev.getSource() == varJfrVistaProdSec.jbGuardar){
            /*Se setean las variables del Modelo obtenidas de las cajas de texto de la Vista*/
            varModProd.setCodigoProd(varJfrVistaProdSec.txtCodProd.getText());
            varModProd.setDescripcion(varJfrVistaProdSec.txtDescripcion.getText());
            varModProd.setPrecioUnitario(Double.parseDouble(varJfrVistaProdSec.txtPrecio.getText()));
            varModProd.setStock(Integer.parseInt(varJfrVistaProdSec.txtStock.getText()));
            
            try {
                if("INSERT".equals(accion)){
                    if(varMetProd.insertarProducto(varModProd)){
                        JOptionPane.showMessageDialog(null,"Registro exitoso");
                        varJfrVistaProdSec.dispose();
                    }else
                        JOptionPane.showMessageDialog(null,"Error al registrar");
                }
                else if("UPDATE".equals(accion)){
                    if(varMetProd.actualizarProducto(varModProd)){
                        JOptionPane.showMessageDialog(null,"Actualizacion exitosa");
                        varJfrVistaProdSec.dispose();
                    }else
                        JOptionPane.showMessageDialog(null,"Error al actualizar");
                    
                }
                    
            } catch (SQLException ex) {
                Logger.getLogger(ControlProducto.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        if(ev.getSource() == varJfrVistaProd.jbEliminarProd){
            int filaTabla = varJfrVistaProd.jtProductos.getSelectedRow();
            varModProd.setCodigoProd(varJfrVistaProd.jtProductos.getValueAt(filaTabla, 0).toString());

            try {
                if(varMetProd.eliminarProducto(varModProd)){
                    JOptionPane.showMessageDialog(null,"Registro eliminado");
                }else
                    JOptionPane.showMessageDialog(null,"Error al registrar");
            } catch (SQLException ex) {
                Logger.getLogger(ControlProducto.class.getName()).log(Level.SEVERE, null, ex);
            }
        }  
    }
}
