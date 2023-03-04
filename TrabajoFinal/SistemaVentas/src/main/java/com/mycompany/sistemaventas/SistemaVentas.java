package com.mycompany.sistemaventas;

import Controlador.ControlLogin;
import Controlador.ControlPedido;
import Modelo.Clientes;
import Modelo.MetodosPedidosSP;
import Modelo.MetodosProductosSP;
import Modelo.Pedido;
import Modelo.Productos;
import Vistas.VistaLoginOpciones;
import Vistas.VistaLoginUserCli;
import Vistas.VistaLoginUserEmp;
import Vistas.VistaPedidosPrincipal;
import Vistas.VistaPedidosSecundaria;
import java.sql.SQLException;

/**
 *
 * @author Pamela
 */
public class SistemaVentas {

    public static void main(String[] args) throws SQLException {

       /* VistaLoginOpciones objJfrVistaOpc = new VistaLoginOpciones();
        VistaLoginUserEmp objJfrVistaLogEmp = new VistaLoginUserEmp();
        VistaLoginUserCli objJfrVistaLogCli = new VistaLoginUserCli();        
        
        ControlLogin objCtrlLogin = new ControlLogin(objJfrVistaOpc, objJfrVistaLogEmp, objJfrVistaLogCli);
        
        objCtrlLogin.iniciar();
        
        */
        Productos objProductos = new Productos();
        Pedido objPedido = new Pedido();
        MetodosProductosSP metProd = new MetodosProductosSP();
        MetodosPedidosSP metPed = new MetodosPedidosSP();
        VistaPedidosPrincipal objVistaPedPrinc=new VistaPedidosPrincipal();
        VistaPedidosSecundaria objVistaPedSec =new VistaPedidosSecundaria();
        
        ControlPedido objControlPedido = new ControlPedido(objProductos,objPedido,metProd,metPed,objVistaPedPrinc,objVistaPedSec);
        
        objControlPedido.iniciar();

    }
}
