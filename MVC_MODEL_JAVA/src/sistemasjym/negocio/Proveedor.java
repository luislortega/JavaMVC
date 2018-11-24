
package sistemasjym.negocio;

import java.sql.SQLException;
import java.util.ArrayList;
import sistemasjym.db.ProveedorBD;


public class Proveedor {
    
   private String razon_social;
   private String ruc;
   private String direccion;
   private String tel;

    public Proveedor() {
    }

    public Proveedor(String ruc) {
        this.ruc = ruc;
    }
    
    public Proveedor( String ruc,String razon_social, String direccion, String tel) {      
        this.ruc = ruc;
        this.razon_social = razon_social;
        this.direccion = direccion;
        this.tel = tel;
    }  
    
    public String getRazon_social() {
        return razon_social;
    }

    public void setRazon_social(String razon_social) {
        this.razon_social = razon_social;
    }

    public String getRuc() {
        return ruc;
    }

    public void setRuc(String ruc) {
        this.ruc = ruc;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }
    
     public String toString() {
        return "[Ruc: "+this.getRuc()+"] [Nombre: "+this.getRazon_social()+"] [Direccion: "+this.getDireccion()+"] [Tel: "+this.getTel()+"]";
    }
   
    /*Instanciando nuestro metodos creados en el paquete db*/
    
    /*Este metodo me permite instanciar la clase proveedordb y llamar al metodo grabar para hacer uso de el*/
    public void grabar() throws ClassNotFoundException, 
                                InstantiationException,
                                IllegalAccessException, 
                                SQLException
    {
        ProveedorBD pdb= new ProveedorBD(this);
        pdb.Grabar();
    }
    
    public void actualizar() throws ClassNotFoundException, 
                                InstantiationException,
                                IllegalAccessException, 
                                SQLException
    {
        ProveedorBD pdb= new ProveedorBD(this);
        pdb.Modificar();
    }

    /*Este metodo me permite instanciar la clase proveedordb y llamar al metodo borrar para hacer uso de el*/
    public void borrar() throws ClassNotFoundException, 
                                InstantiationException, 
                                IllegalAccessException, 
                                SQLException
    {        
        ProveedorBD pdb= new ProveedorBD(this);
        pdb.Borrar();
    }
    
    /*Este metodo retorna un conjunto de datos de la clase proveedor*/
    public Proveedor lee() throws ClassNotFoundException, 
                                  InstantiationException, 
                                  IllegalAccessException,
                                  SQLException
    {
        ProveedorBD pdb= new ProveedorBD(this);       
        return pdb.Leer();
    }
       
    /*Este metodo lee todos los datos de la tabla proveedor*/
    public  ArrayList<Proveedor> LeerDatos() throws ClassNotFoundException, 
                                        InstantiationException, 
                                        IllegalAccessException,
                                        SQLException
    {
        ProveedorBD pdb= new ProveedorBD(this);
        return pdb.leerTodos();
    }
    
    /*Este metodo busca un proveedor indicando el ruc y porque campo se va a filtrar*/
    public ArrayList LeerEspecifico(String filtro,String campo) throws 
                                        ClassNotFoundException, 
                                        InstantiationException, 
                                        IllegalAccessException,
                                        SQLException
    {
        ProveedorBD pdb= new ProveedorBD(this);
        return pdb.leer(filtro,campo);
    }
    
}
