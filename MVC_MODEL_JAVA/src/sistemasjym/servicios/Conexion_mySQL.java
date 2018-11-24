package sistemasjym.servicios;

import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion_mySQL extends Conexion {

    private String opciones;

    public Conexion_mySQL() throws ClassNotFoundException,
            InstantiationException,
            SQLException,
            IllegalAccessException {
        opciones = System.getProperty("options");
        iniciardb();
    }

    @Override
    public void iniciardb() throws ClassNotFoundException,
            InstantiationException,
            SQLException,
            IllegalAccessException {
        s_conexion = jdbc + host + "/" + database + "?" + opciones;
        Class.forName(driver).newInstance();
        conexion = DriverManager.getConnection(s_conexion, username, password);       
        dbmt = conexion.getMetaData();
        us_st = conexion.createStatement();
    }
}
