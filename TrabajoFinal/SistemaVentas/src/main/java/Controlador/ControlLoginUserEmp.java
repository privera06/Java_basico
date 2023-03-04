package Controlador;

import Modelo.Clientes;
import Modelo.Empleados;
import Modelo.MetodosClientesSP;
import Modelo.MetodosEmpleadosSP;
import Modelo.MetodosProductosSP;
import Modelo.Productos;
import Vistas.VistaClientesPrincipal;
import Vistas.VistaClientesSecundaria;
import Vistas.VistaEmpleadosPrincipal;
import Vistas.VistaEmpleadosSecundaria;
import Vistas.VistaLoginUserEmp;
import Vistas.VistaProductosPrincipal;
import Vistas.VistaProductosSecundaria;
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
public class ControlLoginUserEmp implements ActionListener{
    
    /*Clases creadas en Modelo y Vista*/
    private Empleados varModEmp;
    private MetodosEmpleadosSP varMetEmp;
    private VistaLoginUserEmp varJfrVistaLogEmp;

    /*Se crea el constructor de la clase y se le pasa el Modelo y la vista creada*/
    public ControlLoginUserEmp(Empleados modEmp, MetodosEmpleadosSP metEmp, VistaLoginUserEmp jfrVistaLogEmp){
        
        /*Se setean las variables con los valores recibidos en el Modelo y la Vista*/
        this.varModEmp = modEmp;
        this.varMetEmp = metEmp;
        this.varJfrVistaLogEmp = jfrVistaLogEmp;

        this.varJfrVistaLogEmp.jcListaTablas.addActionListener(this);
        this.varJfrVistaLogEmp.jbIngresar.addActionListener(this);
        this.varJfrVistaLogEmp.jbCancelar.addActionListener(this);

    }
    /*Metodo para iniciar la vista*/
    public void iniciar(){
        varJfrVistaLogEmp.setTitle("LOGIN EMPLEADOS");
        varJfrVistaLogEmp.setLocationRelativeTo(null);
        varJfrVistaLogEmp.setVisible(true);
    }    
    
    /*Metodo con las acciones que deben realizar los botones*/
    @Override
    public void actionPerformed(ActionEvent ev ){

        if(ev.getSource() == varJfrVistaLogEmp.jbIngresar){
            String permisoTabla;
            /*Se setean las variables del Modelo obtenidas de las cajas de texto de la Vista*/
            varModEmp.setUsuario(varJfrVistaLogEmp.txtUsuario.getText());
            varModEmp.setClave(varJfrVistaLogEmp.txtClave.getText());
            
            String listaNomTabla = (String) varJfrVistaLogEmp.jcListaTablas.getSelectedItem();
            permisoTabla = switch (listaNomTabla) {
                case "Lista de clientes" -> "clientes";
                case "Lista de productos" -> "productos";
                case "Lista de empleados" -> "empleados";
                default -> "invalido";
            };
            
            varModEmp.setPermisos(permisoTabla);
            
            try {
                String resultado = varMetEmp.validarUsuario(varModEmp);
                int login = -1;

                switch (resultado) {
                    case "ENCONTRADO_CP" -> {
                        login = 1;
                        JOptionPane.showMessageDialog(null,"Loggin succesfull..!!!"); 
                        varJfrVistaLogEmp.dispose();
                    }
                    case "ENCONTRADO_SP" -> {
                        login = 0;
                        JOptionPane.showMessageDialog(null,"User found no permissions..!!!");
                                            
                    }
                    default -> JOptionPane.showMessageDialog(null,"User not found or incorrect credentials..!!!");
                }
                
                if(login ==  1){
                    switch(permisoTabla){
                        case "clientes" ->{
                            Clientes objModCli = new Clientes();
                            MetodosClientesSP objMetCli = new MetodosClientesSP();
                            VistaClientesPrincipal objJfrVistaCliPrinc = new VistaClientesPrincipal();
                            VistaClientesSecundaria objJfrVistaCliSec = new VistaClientesSecundaria();                            
                            ControlCliente objCtrlCli = new ControlCliente(objModCli, objMetCli, objJfrVistaCliPrinc,objJfrVistaCliSec );
                            
                            objCtrlCli.iniciar();
                        }
                        case "productos" ->{
                            Productos objModProd = new Productos();
                            MetodosProductosSP objMetProd = new MetodosProductosSP();
                            VistaProductosPrincipal objJfrVistaProdPrinc = new VistaProductosPrincipal();  
                            VistaProductosSecundaria objJfrVistaProdSec = new VistaProductosSecundaria();                            
                            ControlProducto objCtrlProd = new ControlProducto(objModProd, objMetProd, objJfrVistaProdPrinc,objJfrVistaProdSec );
                            
                            objCtrlProd.iniciar();
                        }

                        case "empleados" ->{
                            Empleados objModEmp = new Empleados();
                            MetodosEmpleadosSP objMetEmp = new MetodosEmpleadosSP();
                            VistaEmpleadosPrincipal objJfrVistaEmpPrinc = new VistaEmpleadosPrincipal();
                            VistaEmpleadosSecundaria objJfrVistaEmpSec = new VistaEmpleadosSecundaria();                            
                            ControlEmpleado objCtrlEmp = new ControlEmpleado(objModEmp, objMetEmp, objJfrVistaEmpPrinc,objJfrVistaEmpSec );
                            
                            objCtrlEmp.iniciar();
                        }                        
                    }
                }
            } catch (SQLException ex) {
                Logger.getLogger(ControlLoginUserEmp.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        if(ev.getSource() == varJfrVistaLogEmp.jbCancelar){
            varJfrVistaLogEmp.dispose();
        }
    }

}
