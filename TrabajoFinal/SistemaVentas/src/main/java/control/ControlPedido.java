package control;

import modelos.Productos;
import modelos.Pedido;
import modelos.MetodosPedidosSP;
import modelos.MetodosProductosSP;
import vista.VistaPedidosPrincipal;
import vista.VistaPedidosSecundaria;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.security.SecureRandom;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Pamela
 */
public class ControlPedido implements ActionListener {

    /*Clases creadas en Modelo y Vista*/
    private Productos varModProd;
    private Pedido varModPedido;
    private MetodosProductosSP varMetProd;
    private VistaPedidosPrincipal varJfrVistaPedPrinc;
    private VistaPedidosSecundaria varJfrVistaPedSec;

    int flag = 0;
    Double total = 0.0; 
    int[] num1 = new int[6];
    double[] num2 = new double[6];

    /*Se crea el constructor de la clase y se le pasa el Modelo y la vista creada*/
    public ControlPedido(Productos modProd, Pedido modPed, MetodosProductosSP metProd, MetodosPedidosSP metPed, VistaPedidosPrincipal jfrVistaPedPrinc, VistaPedidosSecundaria jfrVistaPedSec) {

        /*Se setean las variables con los valores recibidos en el Modelo y la Vista*/
        this.varModProd = modProd;
        this.varModPedido = modPed;
        this.varMetProd = metProd;
        this.varJfrVistaPedPrinc = jfrVistaPedPrinc;
        this.varJfrVistaPedSec = jfrVistaPedSec;

        this.varJfrVistaPedPrinc.jbAgregarProdPedido.addActionListener(this);
        this.varJfrVistaPedPrinc.jbVerPedido.addActionListener(this);
        this.varJfrVistaPedSec.jbCerrar.addActionListener(this);
    }
    
    /*Metodo para iniciar la vista*/
    public void iniciar() throws SQLException {
        varJfrVistaPedPrinc.setTitle("PEDIDOS");
        varJfrVistaPedPrinc.setLocationRelativeTo(null);
        varJfrVistaPedPrinc.setVisible(true);
        
        DefaultTableModel modelo = new DefaultTableModel();
        varJfrVistaPedPrinc.jtPedido.setModel(modelo);
        
        varModProd.setCodigoProd("");  
        if(!varMetProd.mostrarProducto(varModProd, modelo))
            JOptionPane.showMessageDialog(null,"Ocurrio un error al mostrar la lista");
        
        if(flag == 0)
        {
            //Random numAleatorio = new Random();
            SecureRandom numAleatorio = new SecureRandom(); // Compliant for security-sensitive use cases
            byte bytes[] = new byte[20];
            numAleatorio.nextBytes(bytes);
            varModPedido.setCodigoPed(String.valueOf(numAleatorio.nextInt(10000)));
        }
        varJfrVistaPedPrinc.txtIdPedido.setText(varModPedido.getCodigoPed());
        varJfrVistaPedPrinc.txtCantidad.setText("0");
        varJfrVistaPedPrinc.txtProducto.setText("");
        varJfrVistaPedPrinc.txtTotal.setText("0.0");
        varJfrVistaPedSec.txtTotal.setText("0.0");
        varJfrVistaPedSec.txtPrecProd_1.setText("0.0");
        varJfrVistaPedSec.txtPrecProd_2.setText("0.0");
        varJfrVistaPedSec.txtPrecProd_3.setText("0.0");
        varJfrVistaPedSec.txtPrecProd_4.setText("0.0");
        varJfrVistaPedSec.txtPrecProd_5.setText("0.0");
    }


    /*Metodo con las acciones que deben realizar los botones*/
    @Override
    public void actionPerformed(ActionEvent ev) {
       

        if (varJfrVistaPedPrinc.jbAgregarProdPedido.equals(ev.getSource())) {

            int filaTabla = varJfrVistaPedPrinc.jtPedido.getSelectedRow(); //nos retorna un producto     

            varModPedido.setCantidad(Integer.parseInt(varJfrVistaPedPrinc.txtCantidad.getText()));
             varModProd.setPrecioUnitario(filaTabla);
            varModProd.setCodigoProd(varJfrVistaPedPrinc.jtPedido.getValueAt(filaTabla, 0).toString());
            varModProd.setPrecioUnitario(Double.parseDouble(varJfrVistaPedPrinc.jtPedido.getValueAt(filaTabla, 2).toString()));

            varJfrVistaPedPrinc.setVisible(true);

            varJfrVistaPedPrinc.jtPedido.setValueAt(varModPedido.getCantidad(), filaTabla, 0);
            
            switch (varJfrVistaPedPrinc.txtProducto.getText()) {
                case "PRD0001" -> {
                    num1[0]=varModPedido.getCantidad();
                    varJfrVistaPedSec.txtCantProd_1.setText(String.valueOf(varModPedido.getCantidad()));
                    num2[0]=num1[0]*varModProd.getPrecioUnitario();
                    total = total + num2[0];
                    varJfrVistaPedSec.txtPrecProd_1.setText(String.valueOf(num2[0]));
                }
                case "PRD0002" -> {
                    num1[1]=varModPedido.getCantidad();
                    varJfrVistaPedSec.txtCantProd_2.setText(String.valueOf(varModPedido.getCantidad()));
                    num2[1]=num1[1]*varModProd.getPrecioUnitario();
                    total = total + num2[1];
                    varJfrVistaPedSec.txtPrecProd_2.setText(String.valueOf(num2[1]));
                }
                case "PRD0003" -> {
                    num1[2]=varModPedido.getCantidad();
                    varJfrVistaPedSec.txtCantProd_3.setText(String.valueOf(varModPedido.getCantidad()));
                    num2[2]=num1[2]*varModProd.getPrecioUnitario();
                    total = total + num2[2];
                    varJfrVistaPedSec.txtPrecProd_3.setText(String.valueOf(num2[2]));
                }
                case "PRD0004" -> {
                    num1[3]=varModPedido.getCantidad();
                    varJfrVistaPedSec.txtCantProd_4.setText(String.valueOf(varModPedido.getCantidad()));
                    num2[3]=num1[3]*varModProd.getPrecioUnitario();
                    total = total + num2[3];
                    varJfrVistaPedSec.txtPrecProd_4.setText(String.valueOf(num2[3]));
                }
                case "PRD0005" -> {
                    num1[4]=varModPedido.getCantidad();
                    varJfrVistaPedSec.txtCantProd_5.setText(String.valueOf(varModPedido.getCantidad()));
                    num2[4]=num1[4]*varModProd.getPrecioUnitario();
                    total = total + num2[4];
                    varJfrVistaPedSec.txtPrecProd_5.setText(String.valueOf(num2[4]));
                }
                default -> {}//Caso default
            }
            
            varJfrVistaPedPrinc.txtTotal.setText(String.valueOf(total));
                          
            JOptionPane.showMessageDialog(null, "Producto agregado: "+varModPedido.getCodigoPed());                        

        }

        if (varJfrVistaPedPrinc.jbVerPedido.equals(ev.getSource())) {

            varModPedido.setCodigoPed(varJfrVistaPedPrinc.txtIdPedido.getText());

            varJfrVistaPedSec.txtIdPedido.setText(varModPedido.getCodigoPed());
            varJfrVistaPedSec.txtCantProd_1.setText(String.valueOf(num1[0]));
            varJfrVistaPedSec.txtCantProd_2.setText(String.valueOf(num1[1]));
            varJfrVistaPedSec.txtCantProd_3.setText(String.valueOf(num1[2]));
            varJfrVistaPedSec.txtCantProd_4.setText(String.valueOf(num1[3]));
            varJfrVistaPedSec.txtCantProd_5.setText(String.valueOf(num1[4]));
            
            varJfrVistaPedSec.txtPrecProd_1.getText();
            varJfrVistaPedSec.txtPrecProd_2.getText();
            varJfrVistaPedSec.txtPrecProd_3.getText();
            varJfrVistaPedSec.txtPrecProd_4.getText();
            varJfrVistaPedSec.txtPrecProd_5.getText();
                    
            varJfrVistaPedSec.txtTotal.setText(String.valueOf(total));
            
            varJfrVistaPedSec.setVisible(true);
        }

        if(varJfrVistaPedSec.jbCerrar.equals(ev.getSource())){
            varJfrVistaPedSec.dispose();
            flag = 1;
            try {
                iniciar();
            } catch (SQLException ex) {
                Logger.getLogger(ControlPedido.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        

    }
}
