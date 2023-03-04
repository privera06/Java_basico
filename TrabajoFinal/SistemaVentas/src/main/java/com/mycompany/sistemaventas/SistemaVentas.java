package com.mycompany.sistemaventas;

import control.ControlLogin;
import vista.VistaLoginOpciones;


/**
 *
 * @author Pamela
 */
public class SistemaVentas {

    public static void main(String[] args){

        VistaLoginOpciones objJfrVistaOpc = new VistaLoginOpciones();       
        
        ControlLogin objCtrlLogin = new ControlLogin(objJfrVistaOpc);
        
        objCtrlLogin.iniciar();

    }
}
