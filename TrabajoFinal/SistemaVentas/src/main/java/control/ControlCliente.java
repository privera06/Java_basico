package control;

import modelos.Clientes;
import modelos.MetodosClientesSP;
import vista.VistaClientesPrincipal;
import vista.VistaClientesSecundaria;
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
    private Clientes varmodcli;
    private MetodosClientesSP varMetCli;
    private VistaClientesPrincipal varJfrVistaCliPrinc;
    private VistaClientesSecundaria varJfrVistaCliSec;
    String accion;
    
    /*Se crea el constructor de la clase y se le pasa el Modelo y la vista creada*/
    public ControlCliente(Clientes modCli, MetodosClientesSP metCli, VistaClientesPrincipal jfrVistaCli, VistaClientesSecundaria jfrVistaCliSec){
        
        /*Se setean las variables con los valores recibidos en el Modelo y la Vista*/
        this.varmodcli = modCli;
        this.varMetCli = metCli;
        this.varJfrVistaCliPrinc = jfrVistaCli;
        this.varJfrVistaCliSec = jfrVistaCliSec;
        
        this.varJfrVistaCliPrinc.jbAgregarCli.addActionListener(this);
        this.varJfrVistaCliPrinc.jbBuscarCli.addActionListener(this);
        this.varJfrVistaCliPrinc.jbEliminarCli.addActionListener(this);
        this.varJfrVistaCliPrinc.jbActualizarCli.addActionListener(this);
        this.varJfrVistaCliSec.jbGuardar.addActionListener(this);
        this.varJfrVistaCliSec.jbCancelar.addActionListener(this);
    }
    /*Metodo para iniciar la vista*/
    public void iniciar() throws SQLException{
        varJfrVistaCliPrinc.setTitle("CLIENTES");
        varJfrVistaCliPrinc.setLocationRelativeTo(null);
        varJfrVistaCliPrinc.setVisible(true);
        
        DefaultTableModel modelo = new DefaultTableModel();
        varJfrVistaCliPrinc.jtClientes.setModel(modelo); 
        
        varmodcli.setCodigoCli("");
        if(!varMetCli.mostrarCliente(varmodcli, modelo))
            JOptionPane.showMessageDialog(null,"Ocurrio un error al mostrar la lista");
            
    }
    
    /*Metodo con las acciones que deben realizar los botones*/
    @Override
    public void actionPerformed(ActionEvent ev ){
            
        if(varJfrVistaCliPrinc.jbBuscarCli.equals(ev.getSource())){
            
            DefaultTableModel modelo = new DefaultTableModel();
            varJfrVistaCliPrinc.jtClientes.setModel(modelo);
            
            varmodcli.setCodigoCli(varJfrVistaCliPrinc.txtCodigo.getText());
            
            try {
                if(!varMetCli.mostrarCliente(varmodcli, modelo))
                    JOptionPane.showMessageDialog(null,"Error al realizar la busqueda");
                
            } catch (SQLException ex) {
                Logger.getLogger(ControlCliente.class.getName()).log(Level.SEVERE, null, ex);
            }        
        }
    
        if(varJfrVistaCliPrinc.jbAgregarCli.equals(ev.getSource())){
            
            accion = "INSERT";
            
            varJfrVistaCliSec.setLocationRelativeTo(null);
            varJfrVistaCliSec.setVisible(true);
            varJfrVistaCliSec.txtCodigo.setText("");
            varJfrVistaCliSec.txtNombre.setText("");
            varJfrVistaCliSec.txtApellido.setText("");
            varJfrVistaCliSec.txtDocumento.setText("");
            varJfrVistaCliSec.txtClave.setText("");            
        }

        if(varJfrVistaCliPrinc.jbActualizarCli.equals(ev.getSource())){

            accion = "UPDATE";

            int filaTabla = varJfrVistaCliPrinc.jtClientes.getSelectedRow();
            varmodcli.setCodigoCli(varJfrVistaCliPrinc.jtClientes.getValueAt(filaTabla, 0).toString());
            varmodcli.setNombre(varJfrVistaCliPrinc.jtClientes.getValueAt(filaTabla, 1).toString());
            varmodcli.setApellido(varJfrVistaCliPrinc.jtClientes.getValueAt(filaTabla, 2).toString());
            varmodcli.setDocumento(varJfrVistaCliPrinc.jtClientes.getValueAt(filaTabla, 3).toString());
            varmodcli.setClave(varJfrVistaCliPrinc.jtClientes.getValueAt(filaTabla, 4).toString());
            
            varJfrVistaCliSec.setLocationRelativeTo(null);
            varJfrVistaCliSec.setVisible(true);
            
            varJfrVistaCliSec.txtCodigo.setText(varmodcli.getCodigoCli());
            varJfrVistaCliSec.txtNombre.setText(varmodcli.getNombre());
            varJfrVistaCliSec.txtApellido.setText(varmodcli.getApellido());
            varJfrVistaCliSec.txtDocumento.setText(varmodcli.getDocumento());
            varJfrVistaCliSec.txtClave.setText(varmodcli.getClave());
            
        }        
        
        if(varJfrVistaCliPrinc.jbEliminarCli.equals(ev.getSource())){
            
            int filaTabla = varJfrVistaCliPrinc.jtClientes.getSelectedRow();
            varmodcli.setCodigoCli(varJfrVistaCliPrinc.jtClientes.getValueAt(filaTabla, 0).toString());

            try {
                if(varMetCli.eliminarCliente(varmodcli)){
                    JOptionPane.showMessageDialog(null,"Registro eliminado");
                }else
                    JOptionPane.showMessageDialog(null,"Error al registrar");
            } catch (SQLException ex) {
                Logger.getLogger(ControlCliente.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        if(varJfrVistaCliSec.jbGuardar.equals(ev.getSource())){
            
            String varmodcliori = varmodcli.getCodigoCli();

            /*Se setean las variables del Modelo obtenidas de las cajas de texto de la Vista*/
            varmodcli.setCodigoCli(varJfrVistaCliSec.txtCodigo.getText());
            varmodcli.setNombre(varJfrVistaCliSec.txtNombre.getText());
            varmodcli.setApellido(varJfrVistaCliSec.txtApellido.getText());
            varmodcli.setDocumento(varJfrVistaCliSec.txtDocumento.getText());
            varmodcli.setClave(varJfrVistaCliSec.txtClave.getText());
            
            try {
                if("INSERT".equals(accion)){
                    if(varMetCli.insertarCliente(varmodcli)){
                        JOptionPane.showMessageDialog(null,"Registro exitoso");
                        varJfrVistaCliSec.dispose();
                    }else
                        JOptionPane.showMessageDialog(null,"Error al registrar");
                }
                else if("UPDATE".equals(accion)){
                    if(varMetCli.actualizarCliente(varmodcliori, varmodcli)){
                        JOptionPane.showMessageDialog(null,"Actualizacion exitosa");
                        varJfrVistaCliSec.dispose();
                    }else
                        JOptionPane.showMessageDialog(null,"Error al actualizar");
                    
                }
                    
            } catch (SQLException ex) {
                Logger.getLogger(ControlCliente.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        if(varJfrVistaCliSec.jbCancelar.equals(ev.getSource())){
            
            varJfrVistaCliSec.dispose();
        }
    }
}
