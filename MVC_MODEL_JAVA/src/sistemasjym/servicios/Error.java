
package sistemasjym.servicios;


public class Error extends Exception {
    
    private long codigo;
    private String mensaje;

    public Error(long codigo, String mensaje) {
        this.codigo = codigo;
        this.mensaje = mensaje;
    }
    
    public long codigo(){
        return codigo;
    }
    
    public String mensaje(){
        return mensaje;
    }
}
