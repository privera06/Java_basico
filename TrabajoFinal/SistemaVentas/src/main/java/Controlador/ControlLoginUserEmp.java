package Controlador;

import Modelo.ConexionBD;
import Modelo.MetodosEmpleadosSP;
import Vistas.VistaLoginUserEmp;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Pamela
 */
public class ControlLoginUserEmp {
    
    ConexionBD objConexionBD = new ConexionBD();
    VistaLoginUserEmp objVistaLoginUser = new VistaLoginUserEmp();
    
    private 
    
    public void mostrarVistaLogin(){
        objVistaLoginUser.setVisible(true);
    }

    public void getDatosVistaLogin(VistaLoginUserEmp parametroLU){
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
            Logger.getLogger(ControlLoginUserEmp.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    
    /*public void Login(){
        objMetodoSP.getUsuarioValidoSP(usuarioParamMetodo, claveParamMetodo, permisosParamMetodo);
    }*/


    
}
