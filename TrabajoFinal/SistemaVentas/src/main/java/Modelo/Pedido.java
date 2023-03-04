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
    public String getArrProductosString(String cadenaProd) {
        String arrProductosString="";
        System.out.println(" PEDIDO.JAVA");
        System.out.println(" cadenaProd="+cadenaProd);
        System.out.println(" getArrProductos().size()="+getArrProductos().size());
        //for (int i = 0; i < getArrProductos().size(); i++) {
            System.out.println(" PEDIDO.JAVA arrProductosString");
            arrProductosString = arrProductosString + getArrProductos().get(getArrProductos().size()-1).getCodigoProd()+ ',';
            arrProductosString = arrProductosString + getArrProductos().get(getArrProductos().size()-1).getDescripcion()+ ',';
            arrProductosString = arrProductosString + getArrProductos().get(getArrProductos().size()-1).getPrecioUnitario()+ ',';
            arrProductosString = arrProductosString + getArrProductos().get(getArrProductos().size()-1).getStock();
            arrProductosString= arrProductosString + ';';
        //}
        System.out.println(" PEDIDO.JAVA arrProductosString" + arrProductosString);
        System.out.println(" PEDIDO.JAVA cadenaProd.concat(arrProductosString)" + cadenaProd.concat(arrProductosString));
        return cadenaProd.concat(arrProductosString);
    }

    /**
     * @param arrProdutos the arrProdutos to set
     */
    public void setArrProductosString(String arrProductosString) {
        ArrayList<Productos> nuevoArrProductos= new ArrayList<Productos>();   
        System.out.println(" PEDIDO.JAVA - setArrProductosString");
        int ini = 0;
        while (arrProductosString.indexOf(',')>= 0){ //si entra, existe al menos un producto adicional
            Productos varProducto = new Productos();

            if(ini == 0){
                System.out.println("INICIO WHILE 0 arrProductosString = " + arrProductosString);
                varProducto.setCodigoProd(arrProductosString.substring(0,arrProductosString.indexOf(','))); //obtenemos valor de codigo 
                System.out.println(" PEDIDO.JAVA - varProducto.getCodigoProd ="+ varProducto.getCodigoProd());                
            }else{
                System.out.println("INICIO WHILE 1 arrProductosString = " + arrProductosString);
                varProducto.setCodigoProd(arrProductosString.substring(1,arrProductosString.indexOf(','))); //obtenemos valor de codigo 
                System.out.println(" PEDIDO.JAVA - varProducto.getCodigoProd ="+ varProducto.getCodigoProd());                
            }
                
            System.out.println("------------------ " );
            System.out.println(" arrProductosString = " + arrProductosString);
            arrProductosString=arrProductosString.substring(arrProductosString.indexOf(',',1)); //avanzamos cadena
            System.out.println(" arrProductosString.indexOf(',',1) = " + arrProductosString.indexOf(',',1));
            System.out.println("------------------ " );
            System.out.println(" arrProductosString = " + arrProductosString);           
            varProducto.setDescripcion(arrProductosString.substring(1,arrProductosString.indexOf(',',1))); //obtenemos valor de descripcion 
            System.out.println(" PEDIDO.JAVA - varProducto.getDescripcion ="+ varProducto.getDescripcion());
            System.out.println("------------------ " );
            System.out.println(" arrProductosString = " + arrProductosString);
            arrProductosString=arrProductosString.substring(arrProductosString.indexOf(',',1)); //avanzamos cadena
            System.out.println(" arrProductosString.indexOf(',',1) = " + arrProductosString.indexOf(',',1));
            System.out.println("------------------ " );
            System.out.println(" arrProductosString = " + arrProductosString);
            varProducto.setPrecioUnitario(Double.parseDouble(arrProductosString.substring(1,arrProductosString.indexOf(',',1)))); //obtenemos valor de precio 
            System.out.println(" PEDIDO.JAVA - varProducto.getPrecioUnitario ="+ varProducto.getPrecioUnitario());
            System.out.println("------------------ " );
            System.out.println(" arrProductosString = " + arrProductosString);
            arrProductosString=arrProductosString.substring(arrProductosString.indexOf(',',1)); //avanzamos cadena
            System.out.println(" arrProductosString.indexOf(',',1) = " + arrProductosString.indexOf(',',1));
            System.out.println("------------------ " );
            System.out.println(" arrProductosString = " + arrProductosString);
            varProducto.setStock(Integer.parseInt(arrProductosString.substring(1,arrProductosString.indexOf(';')))); //obtenemos valor de stock 
            System.out.println(" PEDIDO.JAVA - varProducto.getStock ="+ varProducto.getStock());
            System.out.println("------------------ " );
            System.out.println(" arrProductosString = " + arrProductosString);
            arrProductosString=arrProductosString.substring(arrProductosString.indexOf(';')); //avanzamos cadena
            System.out.println(" arrProductosString = " + arrProductosString);
            
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
        System.out.println(" PEDIDO.JAVA");
        System.out.println("agregarProducto");
        this.getArrProductos().add(producto);
        System.out.println("agregarProducto = "+getArrProductos().get(0).getCodigoProd());
        System.out.println("agregarProducto = "+getArrProductos().get(0).getDescripcion());
        System.out.println("agregarProducto = "+getArrProductos().get(0).getPrecioUnitario());
        System.out.println("getArrProductos().size() = "+getArrProductos().listIterator(0));
        
        System.out.println(" PEDIDO.JAVA");
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
