package control;

import modelos.Clientes;
import modelos.Empleados;
import modelos.MetodosClientesSP;
import modelos.MetodosEmpleadosSP;
import vista.VistaLoginOpciones;
import vista.VistaLoginUserCli;
import vista.VistaLoginUserEmp;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author Pamela
 */
public class ControlLogin  implements ActionListener{
    private VistaLoginOpciones varJfrVistaOpc;
    
    public ControlLogin (VistaLoginOpciones jfrVistaOpc){
        this.varJfrVistaOpc = jfrVistaOpc;
        
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
        
        if(varJfrVistaOpc.jbLoginEmpleados.equals(ev.getSource())){
            varJfrVistaOpc.dispose();
            
            Empleados objModEmp = new Empleados();
            MetodosEmpleadosSP objMetEmp = new MetodosEmpleadosSP();
            VistaLoginUserEmp objJfrVistaEmp = new VistaLoginUserEmp();            
            ControlLoginUserEmp objControlLogEmp = new ControlLoginUserEmp(objModEmp, objMetEmp, objJfrVistaEmp);
            
            objControlLogEmp.iniciar();
        }
        
        if(varJfrVistaOpc.jbLoginCliente.equals(ev.getSource())){
            varJfrVistaOpc.dispose();
            
            Clientes objModCli = new Clientes();
            MetodosClientesSP objMetEmp = new MetodosClientesSP();
            VistaLoginUserCli objJfrVistaCli = new VistaLoginUserCli();            
            ControlLoginUserCli objControlLogCli = new ControlLoginUserCli(objModCli, objMetEmp, objJfrVistaCli);
            
            objControlLogCli.iniciar();
        }
    
    }
    
 
    
}
