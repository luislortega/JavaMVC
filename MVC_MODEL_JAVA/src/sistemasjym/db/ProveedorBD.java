package sistemasjym.db;

import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import sistemasjym.negocio.Proveedor;
import sistemasjym.servicios.ConectarServicio;
import sistemasjym.servicios.Conexion;

public class ProveedorBD {

    private Proveedor p;

    public ProveedorBD(Proveedor p) {
        this.p = p;
    }

    /*Metodo Grabar*/
    public void Grabar() throws ClassNotFoundException,
            InstantiationException,
            IllegalAccessException,
            SQLException {
        Conexion cdb = ConectarServicio.getInstancia().getConexionDb();

        cdb.un_sql = "SELECT ruc FROM proveedor WHERE ruc=" + p.getRuc() + ";";
        cdb.resultado = cdb.us_st.executeQuery(cdb.un_sql);
        if (cdb.resultado != null) {
            cdb.un_sql = "INSERT INTO proveedor  VALUES ('" + p.getRuc() + "','" + p.getRazon_social() + "','" + p.getDireccion() + "','" + p.getTel() + "')";
            cdb.us_st.executeUpdate(cdb.un_sql);
        } else {
            JOptionPane.showMessageDialog(null,"Error al registrar un nuevo proveedor","Error",JOptionPane.ERROR_MESSAGE);
        }
    }

    /*Metodo Modificar*/
    public void Modificar() throws ClassNotFoundException,
            InstantiationException,
            IllegalAccessException,
            SQLException {
        Conexion cdb = ConectarServicio.getInstancia().getConexionDb();

        cdb.un_sql = "SELECT ruc FROM proveedor WHERE ruc=" + p.getRuc() + ";";
        cdb.resultado = cdb.us_st.executeQuery(cdb.un_sql);

        if (cdb.resultado != null) {
            if (cdb.resultado.next()) {
                 cdb.un_sql = "UPDATE proveedor SET razon='" + p.getRazon_social() + "',direccion='" + p.getDireccion() + "',tel=" + p.getTel()+ " WHERE ruc=" + p.getRuc() + ";";
                cdb.us_st.executeUpdate(cdb.un_sql);
            } else {
                /*Generamos nuestro propio error, luego este se activa por el catch quien lo lanza nuevamente*/
                throw new Error("Registro" + p.getRuc() + "No se encuentra en la tabla proveedor Ubicacion'" + this.getClass().getName());
            }
        } else {
            /*Generamos nuestro propio error, luego este se activa por el catch quien lo lanza nuevamente*/
            throw new Error("Modificacion a registro" + p.getRuc() + "Ha devuelto un recordSet null Ubicacion =" + this.getClass().getName());
        }
    }

    /*Metodo Leer*/
    public Proveedor Leer() throws ClassNotFoundException,
            InstantiationException,
            IllegalAccessException,
            SQLException,
            Error {
        Conexion cdb = ConectarServicio.getInstancia().getConexionDb();
        cdb.un_sql = "SELECT * FROM proveedor WHERE ruc='" + p.getRuc() + "'";
        cdb.resultado = cdb.us_st.executeQuery(cdb.un_sql);
        if (cdb.resultado != null) {
            if (cdb.resultado.next()) {
                p.setRuc(cdb.resultado.getString("ruc"));
                p.setRazon_social(cdb.resultado.getString("razon"));
                p.setDireccion(cdb.resultado.getString("direccion"));
                p.setTel(cdb.resultado.getString("tel"));
            } else {
                /*Generamos nuestro propio error, luego este se activa por el catch quien lo lanza nuevamente*/
                throw new Error("Registro " + p.getRuc() + " No se encuentra en la tabla proveedor Ubicacion'" + this.getClass().getName());
            }
        } else {
            /*Generamos nuestro propio error, luego este se activa por el catch quien lo lanza nuevamente*/
            throw new Error("Consulta a registro" + p.getRuc() + "Ha devuelto un recordSet null Ubicacion=" + this.getClass().getName());
        }
        return p;
    }

    /*Metodo Borrar*/
    public void Borrar() throws ClassNotFoundException,
            InstantiationException,
            IllegalAccessException,
            SQLException {
        Conexion cdb = ConectarServicio.getInstancia().getConexionDb();
        cdb.un_sql = "DELETE FROM proveedor WHERE ruc='" + p.getRuc() + "'";
        cdb.us_st.executeUpdate(cdb.un_sql);
    }

    /*Creando el metodo leer y ordenar por proveedor*/
    public  ArrayList<Proveedor> leerTodos() throws ClassNotFoundException,
            InstantiationException,
            IllegalAccessException,
            SQLException, Error {
       
        ArrayList<Proveedor> r = new ArrayList<>();
        Conexion cdb = ConectarServicio.getInstancia().getConexionDb();
        cdb.un_sql = "select * from proveedor";
        cdb.resultado = cdb.us_st.executeQuery(cdb.un_sql);       
        if (cdb.resultado != null) {
            while (cdb.resultado.next()) {
                p=new Proveedor();
                p.setRuc(cdb.resultado.getString("ruc"));
                p.setRazon_social(cdb.resultado.getString("razon"));
                p.setDireccion(cdb.resultado.getString("direccion"));
                p.setTel(cdb.resultado.getString("tel"));   
                r.add(p);
            }                  
        }         
        return r;
    }

    public ArrayList leer(String filtro, String campo) throws ClassNotFoundException,
            InstantiationException,
            IllegalAccessException,
            SQLException {
        ArrayList r;
        Proveedor p;

        Conexion cdb = ConectarServicio.getInstancia().getConexionDb();
        cdb.un_sql = "SELECT * FROM proveedor WHERE" + campo + "LIKE '%" + filtro + "%' ORDER BY razon";
        cdb.resultado = cdb.us_st.executeQuery(cdb.un_sql);

        return null;
    }
}
