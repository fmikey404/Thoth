package juego;

import admin.Manejador;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;

public class Juego extends javax.swing.JFrame {
    public static int ataqueSlimes;
    public static int ataqueFantasmas;
    public static int ataqueDinos;
    public static int ataqueMagos;
    private static int puntajeAnterior = 0;
    Random randomSlimes = new Random();
    Random randomFantasmas = new Random();
    Random randomDinos = new Random();
    Random randomMagos = new Random();
    static int puntos = 0;
    static Runnable datos;
    static Thread hilo;

    public Juego() throws InterruptedException {
        initComponents();
        this.setLocationRelativeTo(null);
        Niveles.guardarImg();
        Timer timer = new Timer(200, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    puntos = Integer.parseInt(Juego.puntajeLabel.getText().trim());
                } catch (NumberFormatException numberFormatException) {
                }
                if (puntos != puntajeAnterior){
                    ataqueSlimes = randomSlimes.nextInt(4);
                    ataqueFantasmas = randomFantasmas.nextInt(4);
                    ataqueDinos = randomDinos.nextInt(16);
                    ataqueMagos = randomMagos.nextInt(27);
                    puntajeAnterior = puntos;
                }
                datos = new Manejador();
                hilo = new Thread(datos);
                hilo.start();
            }
        });
        timer.start();
        timer.stop();
        timer.restart();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        info = new javax.swing.JLabel();
        instruccion = new javax.swing.JLabel();
        puntajeLabel = new javax.swing.JLabel();
        ptsLabel = new javax.swing.JLabel();
        enemy = new javax.swing.JLabel();
        player = new javax.swing.JLabel();
        back = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setLocation(new java.awt.Point(0, 0));
        setSize(new java.awt.Dimension(1080, 720));

        jPanel1.setPreferredSize(new java.awt.Dimension(1080, 720));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        info.setFont(new java.awt.Font("Franklin Gothic Book", 1, 18)); // NOI18N
        info.setForeground(new java.awt.Color(136, 0, 21));
        info.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        info.setText("*DESARROLLADO CON FINES EDUCATIVOS*");
        jPanel1.add(info, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, 1080, -1));

        instruccion.setHorizontalAlignment(SwingConstants.CENTER);
        jPanel1.add(instruccion, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 250, 1080, -1));

        puntajeLabel.setFont(new java.awt.Font("Franklin Gothic Book", 1, 24)); // NOI18N
        puntajeLabel.setForeground(new java.awt.Color(136, 0, 21));
        puntajeLabel.setText("-");
        jPanel1.add(puntajeLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 10, -1, -1));

        ptsLabel.setFont(new java.awt.Font("Franklin Gothic Book", 1, 24)); // NOI18N
        ptsLabel.setForeground(new java.awt.Color(136, 0, 21));
        ptsLabel.setText("Puntaje:");
        jPanel1.add(ptsLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        jPanel1.add(enemy, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 490, -1, -1));

        jPanel1.add(player, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 490, -1, -1));

        jPanel1.add(back, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public static void main(String args[]) throws InterruptedException {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new Juego().setVisible(true);
                } catch (InterruptedException ex) {
                    Logger.getLogger(Juego.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JLabel back;
    public static javax.swing.JLabel enemy;
    private javax.swing.JLabel info;
    public static javax.swing.JLabel instruccion;
    private javax.swing.JPanel jPanel1;
    public static javax.swing.JLabel player;
    public static javax.swing.JLabel ptsLabel;
    public static javax.swing.JLabel puntajeLabel;
    // End of variables declaration//GEN-END:variables
}
