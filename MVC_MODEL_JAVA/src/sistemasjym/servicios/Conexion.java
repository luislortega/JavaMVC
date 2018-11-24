package sistemasjym.servicios;

import java.sql.*;

public class Conexion {

    public Connection conexion = null;
    public Statement us_st = null;
    public DatabaseMetaData dbmt;
    public String s_conexion = null;
    public ResultSet resultado = null;
    public String un_sql = null;
    protected String jdbc;
    protected String driver;
    protected String host;
    protected String database;
    protected String username;
    protected String password;

    public Conexion() throws ClassNotFoundException,
            InstantiationException,
            SQLException,
            IllegalAccessException {
        jdbc = System.getProperty("jdbc");
        driver = System.getProperty("driver");
        host = System.getProperty("host");
        database = System.getProperty("database");
        username = System.getProperty("username");
        password = System.getProperty("password");
        iniciardb();
    }

    public void iniciardb() throws ClassNotFoundException,
            InstantiationException,
            SQLException,
            IllegalAccessException {
        s_conexion = jdbc + host + "/" + database;
        Class.forName(driver).newInstance();
        conexion = DriverManager.getConnection(s_conexion, username, password);
        dbmt = conexion.getMetaData();
        us_st = conexion.createStatement();
    }
}
