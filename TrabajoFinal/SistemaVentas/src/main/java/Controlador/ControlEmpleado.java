/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
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

/**
 *
 * @author Pamela
 */
public class ControlEmpleado implements ActionListener{
    /*Clases creadas en Modelo y Vista*/
    private Empleados varModEmp;
    private MetodosEmpleadosSP varMetEmp;
    private VistaEmpleadosPrincipal varJfrVistaEmpPrinc;
    private VistaEmpleadosSecundaria varJfrVistaEmpSec;
    
    /*Se crea el constructor de la clase y se le pasa el Modelo y la vista creada*/
    public ControlEmpleado(Empleados modEmp, MetodosEmpleadosSP metEmp, VistaEmpleadosPrincipal jfrVistaEmpPrinc, VistaEmpleadosSecundaria jfrVistaEmpSec){
        
        /*Se setean las variables con los valores recibidos en el Modelo y la Vista*/
        this.varModEmp = modEmp;
        this.varMetEmp = metEmp;
        this.varJfrVistaEmpPrinc = jfrVistaEmpPrinc;
        this.varJfrVistaEmpSec = jfrVistaEmpSec;
        
        this.varJfrVistaEmpPrinc.jbAgregarUsuario.addActionListener(this);
        this.varJfrVistaEmpPrinc.jbBuscarUsuario.addActionListener(this);
        this.varJfrVistaEmpPrinc.jbEliminarUsuario.addActionListener(this);
        this.varJfrVistaEmpPrinc.jbActualizarUsuario.addActionListener(this);
        this.varJfrVistaEmpSec.jbGuardar.addActionListener(this);
    }
    
    /*Metodo para iniciar la vista*/
    public void iniciar(){
        varJfrVistaEmpPrinc.setTitle("EMPLEADOS");
        varJfrVistaEmpPrinc.setLocationRelativeTo(null);
    }
    
        /*Metodo con las acciones que deben realizar los botones*/
    @Override
    public void actionPerformed(ActionEvent ev ){
        
        String accion="";
        
        if(ev.getSource() == varJfrVistaEmpPrinc.jbBuscarUsuario){
            varModEmp.setCodigoProd(varJfrVistaEmpPrinc.jtCodigo.getText());
            
            System.out.println("varModProd.getCodigoProd()"+varModEmp.getCodigoProd());
            try {
                if(varMetEmp.mostrarProducto(varModEmp)){
                    System.out.println("Paso varModProd.mostrarProducto()");
                    varJfrVistaEmpPrinc.jtEmpleados.setModel(varMetEmp.modelo);
                    
                    
                }
            } catch (SQLException ex) {
                Logger.getLogger(ControlProducto.class.getName()).log(Level.SEVERE, null, ex);
            }        
        }
    
        if(ev.getSource() == varJfrVistaProd.jbAgregarProd){
            accion = "INSERT";
            varJfrVistaProdSec.setVisible(true);
        }

        if(ev.getSource() == varJfrVistaProd.jbActualizarProd){
            
            accion = "UPDATE";
            String codigoOriginal;
            try {
                int filaTabla = varJfrVistaProd.jtProductos.getSelectedRow();                    
                varModProd.setCodigoProd(varJfrVistaProd.jtProductos.getValueAt(filaTabla, 0).toString());
                
                while(varMetProd.mostrarProducto(varModProd)){
                    
                    varJfrVistaProdSec.txtCodProd.setText(varModProd.getCodigoProd());
                    varJfrVistaProdSec.txtDescripcion.setText(varModProd.getDescripcion());
                    varJfrVistaProdSec.txtPrecio.setText(Double.toString(varModProd.getPrecioUnitario()));
                    varJfrVistaProdSec.txtStock.setText(String.valueOf(varModProd.getStock()));
                    
                    codigoOriginal = varModProd.getCodigoProd();
                    
                    varJfrVistaProdSec.setVisible(true);
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
                    }else
                        JOptionPane.showMessageDialog(null,"Error al registrar");
                }
                else if("UPDATE".equals(accion)){
                    if(varMetProd.actualizarProducto(varModProd)){
                        JOptionPane.showMessageDialog(null,"Actualizacion exitosa");
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
