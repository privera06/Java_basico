package com.mycompany.sistemaventas;

import Controlador.ControlLogin;
import Vistas.VistaLoginOpciones;
import Vistas.VistaLoginUserCli;
import Vistas.VistaLoginUserEmp;

/**
 *
 * @author Pamela
 */
public class SistemaVentas {

    public static void main(String[] args) {

        VistaLoginOpciones objJfrVistaOpc = new VistaLoginOpciones();
        VistaLoginUserEmp varJfrVistaLogEmp = new VistaLoginUserEmp();
        VistaLoginUserCli varJfrVistaLogCli = new VistaLoginUserCli();        
        
        ControlLogin objCtrlLogin = new ControlLogin(objJfrVistaOpc, varJfrVistaLogEmp, varJfrVistaLogCli);
        
        objCtrlLogin.iniciar();

    }
}
