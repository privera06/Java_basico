package com.mycompany.sistemaventas;

import Controlador.ControlProducto;
import Modelo.MetodosProductosSP;
import Modelo.Productos;
import Vistas.VistaProductosPrincipal;
import Vistas.VistaProductosSecundaria;

/**
 *
 * @author Pamela
 */
public class SistemaVentas {

    public static void main(String[] args) {
        
        Productos objModProd = new Productos();
        MetodosProductosSP objMetProd = new MetodosProductosSP();
        VistaProductosPrincipal objJfrVistaProd = new VistaProductosPrincipal();
        VistaProductosSecundaria objJfrVistaProdSec = new VistaProductosSecundaria();
        
        ControlProducto objControlProducto = new ControlProducto(objModProd, objMetProd, objJfrVistaProd, objJfrVistaProdSec);
        objControlProducto.iniciar();
        objJfrVistaProd.setVisible(true);
    }
}
