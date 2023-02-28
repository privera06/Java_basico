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
        


    }
}