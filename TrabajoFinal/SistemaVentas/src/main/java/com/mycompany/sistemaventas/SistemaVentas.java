/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.mycompany.sistemaventas;

import Controlador.ControlProducto;
import Modelo.MetodosProductosSP;
import Modelo.Productos;
import Vistas.VistaProductos;
import Vistas.VistaProductosSecundaria;

/**
 *
 * @author Pamela
 */
public class SistemaVentas {

    public static void main(String[] args) {
        
        Productos objModProd = new Productos();
        MetodosProductosSP objMetProd = new MetodosProductosSP();
        VistaProductos objJfrVistaProd = new VistaProductos();
        VistaProductosSecundaria objJfrVistaProdSec = new VistaProductosSecundaria();
        
        ControlProducto objControlProducto = new ControlProducto(objModProd, objMetProd, objJfrVistaProd, objJfrVistaProdSec);
        objControlProducto.iniciar();
        objJfrVistaProd.setVisible(true);
    }
}
