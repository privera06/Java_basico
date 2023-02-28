package com.mycompany.sistemaventas;

import Controlador.ControlLoginUserEmp;
import Controlador.ControlProducto;
import Modelo.Empleados;
import Modelo.MetodosEmpleadosSP;
import Modelo.MetodosProductosSP;
import Modelo.Productos;
import Vistas.VistaEmpleadosPrincipal;
import Vistas.VistaEmpleadosSecundaria;
import Vistas.VistaLoginUserEmp;
import Vistas.VistaProductosPrincipal;
import Vistas.VistaProductosSecundaria;

/**
 *
 * @author Pamela
 */
public class SistemaVentas {

    public static void main(String[] args) {

        Empleados objModEmp = new Empleados();
        MetodosEmpleadosSP objMetEmp = new MetodosEmpleadosSP();
        VistaLoginUserEmp objJfrVistaEmp = new VistaLoginUserEmp();
        
        ControlLoginUserEmp objControlLogEmp = new ControlLoginUserEmp(objModEmp, objMetEmp, objJfrVistaEmp);
        objControlLogEmp.iniciar();
        objJfrVistaEmp.setVisible(true);

        
        /*Productos objModProd = new Productos();
        MetodosProductosSP objMetProd = new MetodosProductosSP();
        VistaProductosPrincipal objJfrVistaProd = new VistaProductosPrincipal();
        VistaProductosSecundaria objJfrVistaProdSec = new VistaProductosSecundaria();
        
        ControlProducto objControlProducto = new ControlProducto(objModProd, objMetProd, objJfrVistaProd, objJfrVistaProdSec);
        objControlProducto.iniciar();
        objJfrVistaProd.setVisible(true);
        */
        
        
    }
}
