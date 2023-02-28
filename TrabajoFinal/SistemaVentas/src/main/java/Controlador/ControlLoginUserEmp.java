package Controlador;

import Modelo.Empleados;
import Modelo.MetodosEmpleadosSP;
import Vistas.VistaLoginUserEmp;
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

                switch (resultado) {
                    case "ENCONTRADO_CP" -> JOptionPane.showMessageDialog(null,"Loggin succesfull..!!!");
                    case "ENCONTRADO_SP" -> JOptionPane.showMessageDialog(null,"User found no permissions..!!!");
                    default -> JOptionPane.showMessageDialog(null,"User not found or incorrect credentials..!!!");
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
