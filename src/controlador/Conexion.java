/*
 * Clase Conexión
 */
package controlador;

import java.sql.*;

/**
 *
 * @author Di Qi
 */
public class Conexion {
    
    private static final String URL = "jdbc:mysql://localhost:3306/gestion_comandas";
    private static final String USUARIO = "root";
    private static final String PASSWORD = "1234";

    /**
     * Abre una nueva conexión
     * @return conexion
     * @throws MiExcepcion 
     */
    public static Connection getConexion() throws MiExcepcion {
        Connection con = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        }
        catch (ClassNotFoundException e) {
            Utils.procedimientoLog(e);
            throw new MiExcepcion(101);
        }
        try {
            con = DriverManager.getConnection(URL, USUARIO, PASSWORD);
        }
        catch (SQLException e) {
            Utils.procedimientoLog(e);
            throw new MiExcepcion(102);            
        }
        
        return con;
    }

    public static void close(Connection conn) throws MiExcepcion {
        try {
            if (conn != null) {
                conn.close();
            }
        } catch (SQLException e) {
            Utils.procedimientoLog(e);
            throw new MiExcepcion(103);  
        }
    }
}
