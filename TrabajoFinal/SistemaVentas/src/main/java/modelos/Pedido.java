package modelos;

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
    public String getArrProductosString(String cadenaProd) {
        String arrProductosString="";

        arrProductosString = arrProductosString + getArrProductos().get(getArrProductos().size()-1).getCodigoProd()+ ',';
        arrProductosString = arrProductosString + getArrProductos().get(getArrProductos().size()-1).getDescripcion()+ ',';
        arrProductosString = arrProductosString + getArrProductos().get(getArrProductos().size()-1).getPrecioUnitario()+ ',';
        arrProductosString = arrProductosString + getArrProductos().get(getArrProductos().size()-1).getStock();
        arrProductosString= arrProductosString + ';';

        return cadenaProd.concat(arrProductosString);
    }

    /**
     * @param arrProdutos the arrProdutos to set
     */
    public void setArrProductosString(String arrProductosString) {
        ArrayList<Productos> nuevoArrProductos= new ArrayList<Productos>();   
        int ini = 0;
        while (arrProductosString.indexOf(',')>= 0){ //si entra, existe al menos un producto adicional
            Productos varProducto = new Productos();

            if(ini == 0){
                varProducto.setCodigoProd(arrProductosString.substring(0,arrProductosString.indexOf(','))); //obtenemos valor de codigo 
            }else{
                varProducto.setCodigoProd(arrProductosString.substring(1,arrProductosString.indexOf(','))); //obtenemos valor de codigo 
            }
                

            arrProductosString=arrProductosString.substring(arrProductosString.indexOf(',',1)); //avanzamos cadena
            varProducto.setDescripcion(arrProductosString.substring(1,arrProductosString.indexOf(',',1))); //obtenemos valor de descripcion 
            arrProductosString=arrProductosString.substring(arrProductosString.indexOf(',',1)); //avanzamos cadena
            varProducto.setPrecioUnitario(Double.parseDouble(arrProductosString.substring(1,arrProductosString.indexOf(',',1)))); //obtenemos valor de precio 
            arrProductosString=arrProductosString.substring(arrProductosString.indexOf(',',1)); //avanzamos cadena
            varProducto.setStock(Integer.parseInt(arrProductosString.substring(1,arrProductosString.indexOf(';')))); //obtenemos valor de stock 
            arrProductosString=arrProductosString.substring(arrProductosString.indexOf(';')); //avanzamos cadena
          
            ini = 1;
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

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
    
    private String codigoPed;
    private int cantidad;
    private ArrayList<Productos> arrProductos = new ArrayList<>();
}
