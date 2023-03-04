package Modelo;

/**
 *
 * @author Pamela
 */
public class Clientes {

    public String getCodigoCli() {
        return codigoCli;
    }

    public void setCodigoCli(String codigoCli) {
        this.codigoCli = codigoCli;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }
    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    private String codigoCli;
    private String nombre;
    private String apellido;
    private String documento;
    private String clave;
}
