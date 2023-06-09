/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Formas;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.BevelBorder;
import javax.swing.border.Border;

/**
 *
 * @author Jonna
 */
public class Pintar extends javax.swing.JFrame {

    PanelDibujar panelDePelotas;

    public Pintar() {
        initComponents();
        this.setBounds(0, 0, 600, 500);
        this.setLocationRelativeTo(null);
        panelDePelotas = new PanelDibujar();
        this.marcoPelotas.add(panelDePelotas);

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btNuevaPelota = new javax.swing.JButton();
        marcoPelotas = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        btNuevaPelota.setText("Nueva Pelota");
        btNuevaPelota.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btNuevaPelotaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout marcoPelotasLayout = new javax.swing.GroupLayout(marcoPelotas);
        marcoPelotas.setLayout(marcoPelotasLayout);
        marcoPelotasLayout.setHorizontalGroup(
            marcoPelotasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 546, Short.MAX_VALUE)
        );
        marcoPelotasLayout.setVerticalGroup(
            marcoPelotasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(marcoPelotas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(37, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btNuevaPelota, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(208, 208, 208))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(marcoPelotas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(btNuevaPelota, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btNuevaPelotaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btNuevaPelotaActionPerformed
        HiloMoverPelota h1 = new HiloMoverPelota();
        h1.start();

    }//GEN-LAST:event_btNuevaPelotaActionPerformed

    public class HiloMoverPelota extends Thread {

        @Override
        public void run() {
            Pelota pelota = new Pelota();
            //panelDePelotas.add(pelota);

            panelDePelotas.aumentarPelotas(pelota);
            for (int i = 1; i <= 3000; i++) {
                try {
                    Thread.sleep(4);
                } catch (InterruptedException ex) {
                    Logger.getLogger(Pintar.class.getName()).log(Level.SEVERE, null, ex);
                }
                pelota.moverPelota(panelDePelotas.getBounds());
                panelDePelotas.paint(panelDePelotas.getGraphics());

            }
        }
    }

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
            java.util.logging.Logger.getLogger(Pintar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Pintar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Pintar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Pintar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Pintar().setVisible(true);

            }
        });
    }

    public class PanelDibujar extends JPanel {

        private ArrayList<Pelota> pelotas = new ArrayList<Pelota>();

        public PanelDibujar() {
            setBounds(0, 0, marcoPelotas.getWidth(), 354);
            setBackground(new Color(163,228,215));
            setLocationRelativeTo(null);
            this.setBorder(new BevelBorder(BevelBorder.LOWERED));

        }

        public void aumentarPelotas(Pelota p) {
            pelotas.add(p);

        }

        public void paintComponent(Graphics g) {

            super.paintComponent(g);
            g.setColor(Color.red);
            g.setColor(new Color(84,153,199));

            Graphics2D g2 = (Graphics2D) g;

            for (Pelota p : pelotas) {

                g2.fill(p.getShape());
            }

        }

    }

    public class Pelota {

        private static final int TAMX = 15;
        private static final int TAMY = 15;

        private double x = 0.00;
        private double y = 0.00;
        private double dx = 1.00;
        private double dy = 1.00;

        public void moverPelota(Rectangle2D limites) {
            x += dx;
            y += dy;

            if (x < limites.getMinX()) {

                x = limites.getMinX();

                dx = -dx;
            }

            if (x + TAMX >= limites.getMaxX()) {

                x = limites.getMaxX() - TAMX;

                dx = -dx;
            }

            if (y < limites.getMinY()) {

                y = limites.getMinY();

                dy = -dy;
            }

            if (y + TAMY >= limites.getMaxY()) {

                y = limites.getMaxY() - TAMY;

                dy = -dy;

            }

        }

        public Ellipse2D getShape() {

            return new Ellipse2D.Double(x, y, TAMX, TAMY);

        }
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btNuevaPelota;
    private javax.swing.JPanel marcoPelotas;
    // End of variables declaration//GEN-END:variables

}
