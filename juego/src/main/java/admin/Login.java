package admin;

import juego.Juego;
import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.firestore.Firestore;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.cloud.FirestoreClient;
import com.google.firebase.database.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.IOException;
import javax.swing.*;

public class Login extends javax.swing.JFrame {

    static Firestore fbLogin;
    public int idRecibido;
    public static int idDigitado;
    public static String passDigitado;
    public static FirebaseDatabase db;
    public String passRecibido;

    public static void conectar() throws IOException {
        FileInputStream serviceAccount
                = new FileInputStream("llaveFirebase.json");

        FirebaseOptions options = new FirebaseOptions.Builder()
                .setCredentials(GoogleCredentials.fromStream(serviceAccount))
                .setDatabaseUrl("https://semilleroumb-ae38e-default-rtdb.firebaseio.com")
                .build();

        FirebaseApp.initializeApp(options);
        fbLogin = FirestoreClient.getFirestore();
        System.out.println("Conectada con Exito");
    }

    public Login() {
        initComponents();
        this.errorLabel.setVisible(false);
        this.setLocationRelativeTo(null);
        try {
            conectar();
        } catch (IOException e) {
            System.out.println("Algo falló en la conexión");
        }
        Timer timer = new Timer(1500, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    validarUsuario();
                    try {
                        idDigitado = Integer.parseInt(Login.idTextBox.getText().trim());
                        passDigitado = Login.passTextBox.getText();
                    } catch (NullPointerException | NumberFormatException ignored){
                    }
                } catch (InterruptedException ex) {
                    ex.printStackTrace();
                }
            }
        });
        timer.start();
        timer.stop();
        timer.restart();
    }

    public void validarUsuario() throws InterruptedException {
        db = FirebaseDatabase.getInstance();
        DatabaseReference id = db.getReference(idDigitado + "/Datos/User");
        id.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                idRecibido = dataSnapshot.getValue(int.class);
            }
            
            @Override
            public void onCancelled(DatabaseError databaseError) {
                System.out.println("The read failed: " + databaseError.getCode());
            }
        });
        DatabaseReference pass = db.getReference(idDigitado + "/Datos/Password");
        pass.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                passRecibido = dataSnapshot.getValue(String.class);
            }
            
            @Override
            public void onCancelled(DatabaseError databaseError) {
                System.out.println("The read failed: " + databaseError.getCode());
            }
        });
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        loginPanel = new javax.swing.JPanel();
        info = new javax.swing.JLabel();
        nameLabel = new javax.swing.JLabel();
        idLabel = new javax.swing.JLabel();
        idTextBox = new javax.swing.JTextField();
        errorLabel = new javax.swing.JLabel();
        passTextBox = new javax.swing.JPasswordField();
        nextBtn = new javax.swing.JToggleButton();
        passLabel1 = new javax.swing.JLabel();
        playerLogin = new javax.swing.JLabel();
        enemyDinoLogin = new javax.swing.JLabel();
        fondo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(1080, 720));

        loginPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        info.setFont(new java.awt.Font("Franklin Gothic Book", 1, 18)); // NOI18N
        info.setForeground(new java.awt.Color(153, 0, 0));
        info.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        info.setText("*DESARROLLADO CON FINES EDUCATIVOS*");
        loginPanel.add(info, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, 1080, -1));

        nameLabel.setFont(new java.awt.Font("Franklin Gothic Book", 1, 48)); // NOI18N
        nameLabel.setForeground(new java.awt.Color(255, 255, 255));
        nameLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        nameLabel.setText("THOTH");
        nameLabel.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        loginPanel.add(nameLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 170, 580, -1));

        idLabel.setFont(new java.awt.Font("Franklin Gothic Book", 1, 36)); // NOI18N
        idLabel.setForeground(new java.awt.Color(255, 255, 255));
        idLabel.setText("ID");
        loginPanel.add(idLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 360, -1, 30));

        idTextBox.setBackground(new java.awt.Color(51, 51, 51));
        idTextBox.setFont(new java.awt.Font("Franklin Gothic Book", 1, 36)); // NOI18N
        idTextBox.setForeground(new java.awt.Color(255, 255, 255));
        loginPanel.add(idTextBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 350, 290, 50));

        errorLabel.setFont(new java.awt.Font("Franklin Gothic Book", 1, 13)); // NOI18N
        errorLabel.setForeground(new java.awt.Color(255, 0, 0));
        errorLabel.setText("ID y/o Contraseña Incorrectos");
        errorLabel.setRequestFocusEnabled(false);
        loginPanel.add(errorLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 570, 200, 30));

        passTextBox.setBackground(new java.awt.Color(51, 51, 51));
        passTextBox.setFont(new java.awt.Font("Franklin Gothic Book", 1, 36)); // NOI18N
        passTextBox.setForeground(new java.awt.Color(255, 255, 255));
        loginPanel.add(passTextBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 500, 290, 50));

        nextBtn.setBackground(new java.awt.Color(51, 51, 51));
        nextBtn.setFont(new java.awt.Font("Franklin Gothic Book", 1, 24)); // NOI18N
        nextBtn.setForeground(new java.awt.Color(255, 255, 255));
        nextBtn.setLabel("CONTINUAR");
        nextBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nextBtnActionPerformed(evt);
            }
        });
        loginPanel.add(nextBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 610, 180, 50));

        passLabel1.setFont(new java.awt.Font("Franklin Gothic Book", 1, 36)); // NOI18N
        passLabel1.setForeground(new java.awt.Color(255, 255, 255));
        passLabel1.setText("CONTRASEÑA");
        loginPanel.add(passLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(265, 500, 240, 50));

        playerLogin.setIcon(new javax.swing.ImageIcon("src/main/java/resources/Player/PWalking.gif")); // NOI18N
        loginPanel.add(playerLogin, new org.netbeans.lib.awtextra.AbsoluteConstraints(930, 540, 130, 140));

        enemyDinoLogin.setIcon(new javax.swing.ImageIcon("src/main/java/resources/Niveles/Dinos/Enemigos/dinosaurio_rojo.gif")); // NOI18N
        loginPanel.add(enemyDinoLogin, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 130, 140));

        fondo.setIcon(new javax.swing.ImageIcon("src/main/java/resources/Fondos/Login.jpg")); // NOI18N
        fondo.setAlignmentY(0.0F);
        loginPanel.add(fondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(loginPanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(loginPanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void nextBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nextBtnActionPerformed
        // TODO add your handling code here:
        if (idDigitado == idRecibido && passDigitado.equals(passRecibido)) {
            try {
                Juego iniciar = new Juego();
                iniciar.setVisible(true);
                this.dispose();
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        } else {
            this.errorLabel.setVisible(true);
        }
    }//GEN-LAST:event_nextBtnActionPerformed

    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(() -> {
            new Login().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel enemyDinoLogin;
    private javax.swing.JLabel errorLabel;
    private javax.swing.JLabel fondo;
    private javax.swing.JLabel idLabel;
    public static javax.swing.JTextField idTextBox;
    private javax.swing.JLabel info;
    private javax.swing.JPanel loginPanel;
    private javax.swing.JLabel nameLabel;
    private javax.swing.JToggleButton nextBtn;
    private javax.swing.JLabel passLabel1;
    public static javax.swing.JPasswordField passTextBox;
    private javax.swing.JLabel playerLogin;
    // End of variables declaration//GEN-END:variables
}
