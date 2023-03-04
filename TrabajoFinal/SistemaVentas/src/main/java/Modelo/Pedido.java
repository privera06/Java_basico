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
     * @return the arrProductos
     */
    public ArrayList<Productos> getArrProductos() {
        return arrProductos;
    }

    /**
     * @param arrProductos the arrProductos to set
     */
    public void setArrProductos(ArrayList<Productos> arrProductos) {
        this.arrProductos = arrProductos;
    }

    /**
     * @return the arrProdutos
     */
    public String getArrProductosString() {
        String arrProductosString="";
        for (int i = 0; i < getArrProductos().size(); i++) {
            arrProductosString = arrProductosString + getArrProductos().get(i).getCodigoProd()+ ',';
            arrProductosString = arrProductosString + getArrProductos().get(i).getDescripcion()+ ',';
            arrProductosString = arrProductosString + getArrProductos().get(i).getPrecioUnitario()+ ',';
            arrProductosString = arrProductosString + getArrProductos().get(i).getStock();
            
            arrProductosString= arrProductosString + ';';
        }
        return arrProductosString;
    }

    /**
     * @param arrProdutos the arrProdutos to set
     */
    public void setArrProductosString(String arrProductosString) {
        ArrayList<Productos> nuevoArrProductos= new ArrayList<Productos>();   
        
        while (arrProductosString.indexOf(',')>= 0){ //si entra, existe al menos un producto adicional
            Productos varProducto = new Productos();
            varProducto.setCodigoProd(arrProductosString.substring(0,arrProductosString.indexOf(','))); //obtenemos valor de codigo 
            arrProductosString=arrProductosString.substring(arrProductosString.indexOf(',')); //avanzamos cadena
            
            varProducto.setDescripcion(arrProductosString.substring(0,arrProductosString.indexOf(','))); //obtenemos valor de descripcion 
            arrProductosString=arrProductosString.substring(arrProductosString.indexOf(',')); //avanzamos cadena
            
            varProducto.setPrecioUnitario(Double.parseDouble(arrProductosString.substring(0,arrProductosString.indexOf(',')))); //obtenemos valor de precio 
            arrProductosString=arrProductosString.substring(arrProductosString.indexOf(',')); //avanzamos cadena
            
            varProducto.setStock(Integer.parseInt(arrProductosString.substring(0,arrProductosString.indexOf(';')))); //obtenemos valor de stock 
            arrProductosString=arrProductosString.substring(arrProductosString.indexOf(',')); //avanzamos cadena
            
            nuevoArrProductos.add(varProducto);
        }
        
        this.setArrProductos(nuevoArrProductos);
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
        this.getArrProductos().add(producto);
    }

    public void eliminarProducto(Productos producto) {
        int contador = 0;
        for (int i = 0; i < getArrProductos().size(); i++) {
            if(producto.getCodigoProd().equals(getArrProductos().get(i).getCodigoProd()))
            {
                contador = i;
                break;
            }
        }
        this.getArrProductos().remove(contador);
    }

    private String codigoPed;
    private ArrayList<Productos> arrProductos;
}
