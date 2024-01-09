/*
 * ComandaPlatoDB
 */
package controlador;

import java.sql.*;
import java.util.Map;
import modelo.Plato;

/**
 *
 * @author dqchen
 */
public class ComandaPlatoDB {

    private static Connection conexion;

    /**
     * Crear las lineas de comanda en la base de datos
     * @param idComanda id de la comanda
     * @param lc map de cada plato con la cantidad
     * @throws MiExcepcion 
     */
    public static void crearLineasComanda(int idComanda, Map<Plato, Integer> lc) throws MiExcepcion {
        try {
            String sql = "insert into comanda_plato values (?, ?, ?)";
            PreparedStatement stm = conexion.prepareStatement(sql);
            for (Plato p : lc.keySet()) {
                int cantidad = lc.get(p);
                if (cantidad > 0) {
                    stm.setInt(1, idComanda);
                    stm.setInt(2, p.getId());
                    stm.setInt(3, cantidad);
                    stm.executeUpdate();
                }
            }
            stm.close();
        } catch (SQLException ex) {
            Utils.procedimientoLog(ex);
            throw new MiExcepcion(107);
        }
    }

    /**
     * Modificar las lineas de comanda en la base de datos
     * @param idComanda id de la comanda
     * @param lc map de cada plato con la cantidad
     * @throws MiExcepcion 
     */
    public static void modificarLineasComanda(int idComanda, Map<Plato, Integer> lc) throws MiExcepcion {
        try {
            // Borramos las lineas de comanda antiguas
            String sql = "delete from comanda_plato where id_comanda = ?";
            PreparedStatement stm = conexion.prepareStatement(sql);
            stm.setInt(1, idComanda);
            stm.executeUpdate();
            stm.close();
            
            // Creamos las nuevas lineas de comanda
            crearLineasComanda(idComanda, lc);
        } catch (SQLException ex) {
            Utils.procedimientoLog(ex);
            throw new MiExcepcion(108);
        }
    }

    public static void setConexion(Connection c) {
        conexion = c;
    }
}
