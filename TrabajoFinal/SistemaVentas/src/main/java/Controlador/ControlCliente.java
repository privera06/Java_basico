package Controlador;

import Modelo.Clientes;
import Modelo.MetodosClientesSP;
import Vistas.VistaClientesPrincipal;
import Vistas.VistaClientesSecundaria;
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
public class ControlCliente  implements ActionListener{
    /*Clases creadas en Modelo y Vista*/
    private Clientes varModCli;
    private MetodosClientesSP varMetCli;
    private VistaClientesPrincipal varJfrVistaCliPrinc;
    private VistaClientesSecundaria varJfrVistaCliSec;
    String accion;
    /*Se crea el constructor de la clase y se le pasa el Modelo y la vista creada*/
    public ControlCliente(Clientes modCli, MetodosClientesSP metCli, VistaClientesPrincipal jfrVistaCli, VistaClientesSecundaria jfrVistaCliSec){
        
        /*Se setean las variables con los valores recibidos en el Modelo y la Vista*/
        this.varModCli = modCli;
        this.varMetCli = metCli;
        this.varJfrVistaCliPrinc = jfrVistaCli;
        this.varJfrVistaCliSec = jfrVistaCliSec;
        
        this.varJfrVistaCliPrinc.jbAgregarCli.addActionListener(this);
        this.varJfrVistaCliPrinc.jbBuscarCli.addActionListener(this);
        this.varJfrVistaCliPrinc.jbEliminarCli.addActionListener(this);
        this.varJfrVistaCliPrinc.jbActualizarCli.addActionListener(this);
        this.varJfrVistaCliSec.jbGuardar.addActionListener(this);
    }
    /*Metodo para iniciar la vista*/
    public void iniciar(){
        varJfrVistaCliPrinc.setTitle("CLIENTES");
        varJfrVistaCliPrinc.setLocationRelativeTo(null);
    }
    
    /*Metodo con las acciones que deben realizar los botones*/
    @Override
    public void actionPerformed(ActionEvent ev ){
        
        
        
        if(ev.getSource() == varJfrVistaCliPrinc.jbBuscarCli){
            DefaultTableModel modelo = new DefaultTableModel();
            varJfrVistaCliPrinc.jtClientes.setModel(modelo);
            
            varModCli.setCodigoCli(varJfrVistaCliPrinc.txtCodigo.getText());
            
            try {
                if(!varMetCli.mostrarCliente(varModCli, modelo))
                    JOptionPane.showMessageDialog(null,"Error al realizar la busqueda");
                
            } catch (SQLException ex) {
                Logger.getLogger(ControlCliente.class.getName()).log(Level.SEVERE, null, ex);
            }        
        }
    
        if(ev.getSource() == varJfrVistaCliPrinc.jbAgregarCli){
            accion = "INSERT";
            varJfrVistaCliSec.setVisible(true);
        }

        if(ev.getSource() == varJfrVistaCliPrinc.jbActualizarCli){

            DefaultTableModel modelo = new DefaultTableModel();
            accion = "UPDATE";

            try {
                int filaTabla = varJfrVistaCliPrinc.jtClientes.getSelectedRow();   

                varModCli.setCodigoCli(varJfrVistaCliPrinc.jtClientes.getValueAt(filaTabla, 0).toString());  
                varModCli.setNombre(varJfrVistaCliPrinc.jtClientes.getValueAt(filaTabla, 1).toString());
                varModCli.setApellido(varJfrVistaCliPrinc.jtClientes.getValueAt(filaTabla, 2).toString());
                varModCli.setDocumento(varJfrVistaCliPrinc.jtClientes.getValueAt(filaTabla, 3).toString());
                varModCli.setClave(varJfrVistaCliPrinc.jtClientes.getValueAt(filaTabla, 4).toString());
                
                varJfrVistaCliSec.txtCodigo.setText(varModCli.getCodigoCli());
                varJfrVistaCliSec.txtNombre.setText(varModCli.getNombre());
                varJfrVistaCliSec.txtApellido.setText(varModCli.getApellido());
                varJfrVistaCliSec.txtDocumento.setText(varModCli.getDocumento());
                varJfrVistaCliSec.txtClave.setText(varModCli.getClave());
                
                varJfrVistaCliSec.setVisible(true);
                
                if(!varMetCli.mostrarCliente(varModCli,modelo)){
                    JOptionPane.showMessageDialog(null,"Error al realizar la actualizacion");
                }
                    
            }catch (SQLException ex) {
                Logger.getLogger(ControlCliente.class.getName()).log(Level.SEVERE, null, ex);
            }
        }        
        
        if(ev.getSource() == varJfrVistaCliSec.jbGuardar){
            /*Se setean las variables del Modelo obtenidas de las cajas de texto de la Vista*/
            varModCli.setCodigoCli(varJfrVistaCliSec.txtCodigo.getText());
            varModCli.setNombre(varJfrVistaCliSec.txtNombre.getText());
            varModCli.setApellido(varJfrVistaCliSec.txtApellido.getText());
            varModCli.setDocumento(varJfrVistaCliSec.txtDocumento.getText());
            varModCli.setClave(varJfrVistaCliSec.txtClave.getText());
            
            try {
                if("INSERT".equals(accion)){
                    if(varMetCli.insertarCliente(varModCli)){
                        JOptionPane.showMessageDialog(null,"Registro exitoso");
                        varJfrVistaCliSec.dispose();
                    }else
                        JOptionPane.showMessageDialog(null,"Error al registrar");
                }
                else if("UPDATE".equals(accion)){
                    if(varMetCli.actualizarCliente(varModCli)){
                        JOptionPane.showMessageDialog(null,"Actualizacion exitosa");
                        varJfrVistaCliSec.dispose();
                    }else
                        JOptionPane.showMessageDialog(null,"Error al actualizar");
                    
                }
                    
            } catch (SQLException ex) {
                Logger.getLogger(ControlCliente.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        if(ev.getSource() == varJfrVistaCliPrinc.jbEliminarCli){
            int filaTabla = varJfrVistaCliPrinc.jtClientes.getSelectedRow();
            varModCli.setCodigoCli(varJfrVistaCliPrinc.jtClientes.getValueAt(filaTabla, 0).toString());

            try {
                if(varMetCli.eliminarCliente(varModCli)){
                    JOptionPane.showMessageDialog(null,"Registro eliminado");
                }else
                    JOptionPane.showMessageDialog(null,"Error al registrar");
            } catch (SQLException ex) {
                Logger.getLogger(ControlCliente.class.getName()).log(Level.SEVERE, null, ex);
            }
        }  
    }
}
