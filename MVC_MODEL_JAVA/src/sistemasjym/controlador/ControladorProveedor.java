
package sistemasjym.controlador;

import java.sql.SQLException;
import java.util.ArrayList;
import sistemasjym.negocio.Proveedor;


public class ControladorProveedor {
    
    /*Metodo para buscar un proveedor indicando el campo y el valor */
    public ArrayList buscarProveedor(String filtro,
                                    String campo) throws 
                                        ClassNotFoundException, 
                                        InstantiationException, 
                                        IllegalAccessException, 
                                        SQLException
    {      
        Proveedor prov;
        prov= new Proveedor();
        return prov.LeerEspecifico(filtro, campo);
        
    }
      /*Metodo para agregar un nuevo proveedor*/
    public void agregarProveedor(String ruc,
                                 String razon_social,
                                 String direccion,
                                 String tel) 
                                 throws
                                 ClassNotFoundException, 
                                 InstantiationException,
                                 IllegalAccessException, 
                                 SQLException
    {      
        Proveedor prov = new Proveedor(ruc,razon_social,direccion,tel);
        prov.grabar();        
    }
     /*Metodo para modificar un proveedor*/
    public void modificarProveedor(String ruc,
                                 String razon_social,                              
                                 String direccion,
                                 String tel) 
                                 throws
                                 ClassNotFoundException, 
                                 InstantiationException,
                                 IllegalAccessException, 
                                 SQLException
    {      
        Proveedor prov = new Proveedor(ruc,razon_social,direccion,tel);    
        prov.actualizar();
    }
    
     /*Metodo para borrar un proveedor*/   
    public void eliminarProveedor(String ruc)
                                 throws
                                 ClassNotFoundException, 
                                 InstantiationException,
                                 IllegalAccessException, 
                                 SQLException
    {
        Proveedor prov;
        prov= new Proveedor(ruc); 
        prov.borrar();
    }
    
    /*Metodo para recargar proveedores*/      
    public ArrayList<Proveedor> recargarProveedores()
                                throws 
                                ClassNotFoundException, 
                                InstantiationException, 
                                IllegalAccessException,
                                SQLException
    {
        Proveedor prov = new Proveedor(); 
        return prov.LeerDatos();
    }
}
