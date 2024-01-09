/*
 * Utils
 */
package controlador;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DecimalFormat;
import java.time.LocalDateTime;

/**
 *
 * @author Di Qi
 */
public class Utils {

    public static void procedimientoLog(Exception e) {
        System.err.println(e);
        e.printStackTrace();
        LocalDateTime dt = LocalDateTime.now();
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter("log.txt", true));
            bw.write(dt.toString() + " >>> " + e.getMessage() + "\n");
            bw.close();
        } catch (IOException ex) {
            System.err.println(ex);
        }
    }
    
    public static String precioStr(float f) {
        DecimalFormat df = new DecimalFormat("#.00");
        return df.format(f) + " €";
    }
}
