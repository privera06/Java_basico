package Controlador;

import Modelo.Clientes;
import Modelo.Empleados;
import Modelo.MetodosClientesSP;
import Modelo.MetodosEmpleadosSP;
import Vistas.VistaLoginOpciones;
import Vistas.VistaLoginUserCli;
import Vistas.VistaLoginUserEmp;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author Pamela
 */
public class ControlLogin  implements ActionListener{
    private VistaLoginOpciones varJfrVistaOpc;
    private VistaLoginUserEmp varJfrVistaLogEmp;
    private VistaLoginUserCli varJfrVistaLogCli;

    
    public ControlLogin (VistaLoginOpciones jfrVistaOpc, VistaLoginUserEmp jfrVistaLogEmp, VistaLoginUserCli jfrVistaLogCli){
        this.varJfrVistaOpc = jfrVistaOpc;
        this.varJfrVistaLogEmp = jfrVistaLogEmp;
        this.varJfrVistaLogCli = jfrVistaLogCli;
        
        this.varJfrVistaOpc.jbLoginEmpleados.addActionListener(this);
        this.varJfrVistaOpc.jbLoginCliente.addActionListener(this);
    }
    
    /*Metodo para iniciar la vista*/
    public void iniciar(){
        varJfrVistaOpc.setTitle("LOGIN PRINCIPAL");
        varJfrVistaOpc.setLocationRelativeTo(null);
        varJfrVistaOpc.setVisible(true);
    }
    
    /*Metodo con las acciones que deben realizar los botones*/
    @Override
    public void actionPerformed(ActionEvent ev ){
        
        if(ev.getSource() == varJfrVistaOpc.jbLoginEmpleados){
            varJfrVistaOpc.dispose();
            
            Empleados objModEmp = new Empleados();
            MetodosEmpleadosSP objMetEmp = new MetodosEmpleadosSP();
            VistaLoginUserEmp objJfrVistaEmp = new VistaLoginUserEmp();            
            ControlLoginUserEmp objControlLogEmp = new ControlLoginUserEmp(objModEmp, objMetEmp, objJfrVistaEmp);
            
            objControlLogEmp.iniciar();
        }
        
        if(ev.getSource() == varJfrVistaOpc.jbLoginCliente){
            varJfrVistaOpc.dispose();
            
            Clientes objModCli = new Clientes();
            MetodosClientesSP objMetEmp = new MetodosClientesSP();
            VistaLoginUserCli objJfrVistaCli = new VistaLoginUserCli();            
            ControlLoginUserCli objControlLogCli = new ControlLoginUserCli(objModCli, objMetEmp, objJfrVistaCli);
            
            objControlLogCli.iniciar();
        }
    
    }
    
 
    
}
