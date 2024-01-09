/*
 * ComandaDB
 */
package controlador;

import java.sql.*;
import java.util.HashMap;
import java.util.Map;
import modelo.Comanda;
import modelo.Plato;

/**
 *
 * @author Di Qi
 */
public class PlatoDB {

    private static Connection conexion;

    /**
     * Obtener las lineas de comanda
     * @param comanda comanda
     * @return Map con el plato y la cantidad
     * @throws MiExcepcion 
     */
    public static Map<Plato, Integer> getLineasComanda(Comanda comanda) throws MiExcepcion {
        Map<Plato, Integer> res = new HashMap<>();

        String sql = "select p.*, cp.cantidad from plato p, comanda_plato "
                + "cp where p.id = cp.id_plato and cp.id_comanda = ?";

        try {
            PreparedStatement stm = conexion.prepareStatement(sql);
            stm.setInt(1, comanda.getId());

            ResultSet rs = stm.executeQuery();

            while (rs.next()) {
                res.put(
                        new Plato(rs.getInt(1), rs.getString(2), rs.getFloat(3)),
                        rs.getInt(4)
                );
            }

            rs.close();
            stm.close();
        } catch (SQLException ex) {
            Utils.procedimientoLog(ex);
            throw new MiExcepcion(104);
        }

        return res;
    }
    
    /**
     * Obtener lineas de comanda nueva
     * @return Map con los platos y la cantidad por defecto 0
     * @throws MiExcepcion 
     */
    public static Map<Plato, Integer> getLineasComandaNueva() throws MiExcepcion {
        Map<Plato, Integer> res = new HashMap<>();

        String sql = "select * from plato";

        try {
            PreparedStatement stm = conexion.prepareStatement(sql);

            ResultSet rs = stm.executeQuery();

            while (rs.next()) {
                res.put(
                        new Plato(rs.getInt(1), rs.getString(2), rs.getFloat(3)),
                        0
                );
            }

            rs.close();
            stm.close();
        } catch (SQLException ex) {
            Utils.procedimientoLog(ex);
            throw new MiExcepcion(104);
        }

        return res;
    }

    public static void setConexion(Connection c) {
        conexion = c;
    }
    
}
