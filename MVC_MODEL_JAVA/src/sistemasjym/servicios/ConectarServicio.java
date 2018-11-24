package sistemasjym.servicios;

public class ConectarServicio {

    private Conexion cbd;
    private static ConectarServicio instancia;

    public ConectarServicio() {
    }

    public static synchronized ConectarServicio getInstancia() {
        if (instancia == null) {
            instancia = new ConectarServicio();
        }
        return instancia;
    }
     
    public Conexion getConexionDb() throws ClassNotFoundException, 
                                           InstantiationException, 
                                           IllegalAccessException{       
        if(cbd==null){
            String nombreClase = System.getProperty("databaseclass");
            cbd= (Conexion) Class.forName(nombreClase).newInstance();
        }
        return cbd;
    }
}
