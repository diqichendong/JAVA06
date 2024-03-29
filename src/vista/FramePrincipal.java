/*
 * FramePrincipal
 */
package vista;

import controlador.ComandaDB;
import controlador.Conexion;
import controlador.MiError;
import controlador.MiExcepcion;
import java.sql.*;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import modelo.Empleado;

/**
 *
 * @author Di Qi
 */
public class FramePrincipal extends javax.swing.JFrame {

    private Connection conexion;
    private Empleado empleado;

    /**
     * Creates new form FramePrincipal
     */
    public FramePrincipal() {
        initComponents();
        cambiarPanel(new PanelInicio());
    }

    /**
     * Cambiar el panel del frame
     *
     * @param panel Panel a mostrar
     */
    public void cambiarPanel(JPanel panel) {
        this.setContentPane(panel);
        this.pack();
    }

    public Connection getConexion() {
        return this.conexion;
    }

    public void setConexion(Connection conexion) {
        this.conexion = conexion;
    }

    public Empleado getEmpleado() {
        return this.empleado;
    }

    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }

    public JMenuItem getItemIniciarSesion() {
        return itemIniciarSesion;
    }

    public JMenuItem getItemCerrar() {
        return itemCerrar;
    }

    public JMenu getMenuVista() {
        return menuVista;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        menuBar = new javax.swing.JMenuBar();
        menuInicio = new javax.swing.JMenu();
        itemIniciarSesion = new javax.swing.JMenuItem();
        itemCerrar = new javax.swing.JMenuItem();
        menuVista = new javax.swing.JMenu();
        itemEmpleado = new javax.swing.JMenuItem();
        itemComandasIndividual = new javax.swing.JMenuItem();
        itemComandasTabla = new javax.swing.JMenuItem();
        menuAcercaDe = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Gestión de comandas");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        menuInicio.setText("Inicio");
        menuInicio.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        itemIniciarSesion.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        itemIniciarSesion.setText("Iniciar sesión");
        itemIniciarSesion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemIniciarSesionActionPerformed(evt);
            }
        });
        menuInicio.add(itemIniciarSesion);

        itemCerrar.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        itemCerrar.setText("Cerrar");
        itemCerrar.setEnabled(false);
        itemCerrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemCerrarActionPerformed(evt);
            }
        });
        menuInicio.add(itemCerrar);

        menuBar.add(menuInicio);

        menuVista.setText("Vista");
        menuVista.setEnabled(false);
        menuVista.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        itemEmpleado.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        itemEmpleado.setText("Empleado");
        itemEmpleado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemEmpleadoActionPerformed(evt);
            }
        });
        menuVista.add(itemEmpleado);

        itemComandasIndividual.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        itemComandasIndividual.setText("Comandas (Individual)");
        itemComandasIndividual.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemComandasIndividualActionPerformed(evt);
            }
        });
        menuVista.add(itemComandasIndividual);

        itemComandasTabla.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        itemComandasTabla.setText("Comandas (Tabla)");
        itemComandasTabla.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemComandasTablaActionPerformed(evt);
            }
        });
        menuVista.add(itemComandasTabla);

        menuBar.add(menuVista);

        menuAcercaDe.setText("Acerca de");
        menuAcercaDe.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        menuAcercaDe.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                menuAcercaDeMouseClicked(evt);
            }
        });
        menuBar.add(menuAcercaDe);

        setJMenuBar(menuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 576, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 377, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void itemIniciarSesionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemIniciarSesionActionPerformed
        JPanel panel;

        try {
            panel = new PanelIniciarSesion(this);
            this.itemIniciarSesion.setEnabled(false);
        } catch (MiExcepcion ex) {
            panel = new PanelInicio();
            JOptionPane.showMessageDialog(this, MiError.getMensaje(ex.getCodigo()));
        }

        cambiarPanel(panel);
    }//GEN-LAST:event_itemIniciarSesionActionPerformed

    private void itemCerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemCerrarActionPerformed
        cambiarPanel(new PanelInicio());
        try {
            ComandaDB.finalizar();
            Conexion.close(conexion);
        } catch (MiExcepcion ex) {
            JOptionPane.showMessageDialog(this, MiError.getMensaje(ex.getCodigo()));
        }
        itemIniciarSesion.setEnabled(true);
        itemCerrar.setEnabled(false);
        menuVista.setEnabled(false);
    }//GEN-LAST:event_itemCerrarActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        try {
            ComandaDB.finalizar();
            Conexion.close(conexion);
        } catch (MiExcepcion ex) {
            JOptionPane.showMessageDialog(this, MiError.getMensaje(ex.getCodigo()));
        }
    }//GEN-LAST:event_formWindowClosing

    private void itemEmpleadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemEmpleadoActionPerformed
        cambiarPanel(new PanelEmpleado(this));
        try {
            ComandaDB.finalizar();
        } catch (MiExcepcion ex) {
            JOptionPane.showMessageDialog(this, MiError.getMensaje(ex.getCodigo()));
        }
    }//GEN-LAST:event_itemEmpleadoActionPerformed

    private void itemComandasIndividualActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemComandasIndividualActionPerformed
        JPanel panel;

        try {
            ComandaDB.finalizar();
            panel = new PanelComandasIndividual(this);
        } catch (MiExcepcion ex) {
            panel = new PanelEmpleado(this);
            JOptionPane.showMessageDialog(this, MiError.getMensaje(ex.getCodigo()));
        }

        cambiarPanel(panel);
    }//GEN-LAST:event_itemComandasIndividualActionPerformed

    private void itemComandasTablaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemComandasTablaActionPerformed
        JPanel panel;

        try {
            panel = new PanelComandasTabla(this);
            ComandaDB.finalizar();
        } catch (MiExcepcion ex) {
            panel = new PanelEmpleado(this);
            JOptionPane.showMessageDialog(this, MiError.getMensaje(ex.getCodigo()));
        }

        cambiarPanel(panel);
    }//GEN-LAST:event_itemComandasTablaActionPerformed

    private void menuAcercaDeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menuAcercaDeMouseClicked
        new DialogAcercaDe(this, true).setVisible(true);
    }//GEN-LAST:event_menuAcercaDeMouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FramePrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FramePrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FramePrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FramePrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FramePrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem itemCerrar;
    private javax.swing.JMenuItem itemComandasIndividual;
    private javax.swing.JMenuItem itemComandasTabla;
    private javax.swing.JMenuItem itemEmpleado;
    private javax.swing.JMenuItem itemIniciarSesion;
    private javax.swing.JMenu menuAcercaDe;
    private javax.swing.JMenuBar menuBar;
    private javax.swing.JMenu menuInicio;
    private javax.swing.JMenu menuVista;
    // End of variables declaration//GEN-END:variables
}
