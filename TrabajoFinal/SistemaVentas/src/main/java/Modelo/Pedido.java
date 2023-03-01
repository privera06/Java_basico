/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import java.util.ArrayList;

/**
 *
 * @author crebaza
 */
public class Pedido {

    /**
     * @return the arrProdutos
     */
    public ArrayList<Productos> getArrProdutos() {
        return arrProductos;
    }

    /**
     * @param arrProdutos the arrProdutos to set
     */
    public void setArrProdutos(ArrayList<Productos> arrProdutos) {
        this.arrProductos = arrProdutos;
    }

    /**
     * @return the codigoPed
     */
    public String getCodigoPed() {
        return codigoPed;
    }

    /**
     * @param codigoPed the codigoPed to set
     */
    public void setCodigoPed(String codigoPed) {
        this.codigoPed = codigoPed;
    }

    public void agregarProducto(Productos producto) {
        this.arrProductos.add(producto);
    }

    public void eliminarProducto(Productos producto) {
        int contador = 0;
        for (int i = 0; i < arrProductos.size(); i++) {
            if(producto.getCodigoProd()== arrProductos.get(i).getCodigoProd())
            {
                contador = i;
                break;
            }
        }
        this.arrProductos.remove(contador);
    }

    private String codigoPed;
    private ArrayList<Productos> arrProductos;
}
