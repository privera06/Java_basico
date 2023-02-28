/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Modelo.ConexionBD;
import Modelo.MetodosEmpleadosSP;
import Vistas.VistaLoginUser;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Pamela
 */
public class ControladorLogin {
    
    ConexionBD objConexionBD = new ConexionBD();
    VistaLoginUser objVistaLoginUser = new VistaLoginUser();
    
    private 
    
    public void mostrarVistaLogin(){
        objVistaLoginUser.setVisible(true);
    }

    public void getDatosVistaLogin(VistaLoginUser parametroLU){
        String usuario = parametroLU.txtUsuario.toString();
        String clave = parametroLU.txtClave.toString();
    }
        
    public void logicaVistaLogin(MetodosEmpleadosSP parametroSP){
        try {
            System.out.println("INICIO obtenerDatosLogin");
            objConexionBD.cargarDriver();
            objConexionBD.conectarDB();
            parametroSP.getUsuarioValidoSP(usuario,clave);
            System.out.println("FIN obtenerDatosLogin");
        } catch (SQLException ex) {
            Logger.getLogger(ControladorLogin.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    
    /*public void Login(){
        objMetodoSP.getUsuarioValidoSP(usuarioParamMetodo, claveParamMetodo, permisosParamMetodo);
    }*/


    
}
