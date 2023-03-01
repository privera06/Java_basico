/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Modelo.Clientes;
import Modelo.MetodosClientesSP;
import Vistas.VistaLoginUserCli;
import Vistas.VistaPedidos;
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
public class ControlLoginUserCli implements ActionListener {
    /*Clases creadas en Modelo y Vista*/
    private Clientes varModCli;
    private MetodosClientesSP varMetCli;
    private VistaLoginUserCli varJfrVistaLogCli;
    
    /*Se crea el constructor de la clase y se le pasa el Modelo y la vista creada*/
    public ControlLoginUserCli(Clientes modCli, MetodosClientesSP metCli, VistaLoginUserCli jfrVistaLogCli){
        
        /*Se setean las variables con los valores recibidos en el Modelo y la Vista*/
        this.varModCli = modCli;
        this.varMetCli = metCli;
        this.varJfrVistaLogCli = jfrVistaLogCli;

        this.varJfrVistaLogCli.jbIngresar.addActionListener(this);
        this.varJfrVistaLogCli.jbCancelar.addActionListener(this);

    }
    /*Metodo para iniciar la vista*/
    public void iniciar(){
        varJfrVistaLogCli.setTitle("LOGIN CLIENTES");
        varJfrVistaLogCli.setLocationRelativeTo(null);
        varJfrVistaLogCli.setVisible(true);
    }    
    
    /*Metodo con las acciones que deben realizar los botones*/
    @Override
    public void actionPerformed(ActionEvent ev ){

        if(ev.getSource() == varJfrVistaLogCli.jbIngresar){
            /*Se setean las variables del Modelo obtenidas de las cajas de texto de la Vista*/
            varModCli.setDocumento(varJfrVistaLogCli.txtDocumento.getText());
            varModCli.setClave(varJfrVistaLogCli.txtClave.getText());

            try {
                String resultado = varMetCli.validarUsuario(varModCli);

                switch (resultado) {
                    case "ENCONTRADO_CINV" -> JOptionPane.showMessageDialog(null,"Loggin succesfull..!!!");
                    case "ENCONTRADO_CVAL" -> {JOptionPane.showMessageDialog(null,"Invalid password..!!!");
                                                /*VistaPedidos objVistaPed = new VistaPedidos();
                                                objVistaPed.*/
                    }
                    default -> JOptionPane.showMessageDialog(null,"User not found..!!!");
                }
                
                

            } catch (SQLException ex) {
                Logger.getLogger(ControlLoginUserEmp.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        if(ev.getSource() == varJfrVistaLogCli.jbCancelar){
            varJfrVistaLogCli.dispose();
        }
    }

}
