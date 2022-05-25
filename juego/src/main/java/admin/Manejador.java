package admin;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.ValueEventListener;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import juego.Juego;
import juego.Niveles;
import javax.swing.*;

public class Manejador implements Runnable {

    private static int puntajeAGuardar = 0;
    public static HashMap<String, Integer> control = new HashMap<>();

    public Manejador() {
    }

    public void run() {
        try {
            calcularPuntos();
            leerControl();
            insertarNiveles();
            pasarNiveles();
        } catch (InterruptedException ex) {
            Logger.getLogger(Manejador.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void calcularPuntos() throws InterruptedException {
        try {
            DatabaseReference points = Login.db.getReference(Login.idDigitado + "/Datos/Puntaje");
            points.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    puntajeAGuardar = dataSnapshot.getValue(int.class);
                }

                @Override
                public void onCancelled(DatabaseError databaseError) {
                    System.out.println("The read failed: " + databaseError.getCode());
                }
            });
            Juego.puntajeLabel.setText(String.valueOf(puntajeAGuardar));
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static void insertarNiveles() {
        //FONDO
        if (puntajeAGuardar >= 0 && puntajeAGuardar < 8) {
            Juego.back.setIcon(new javax.swing.ImageIcon(Niveles.fondos[0]));
        } else if (puntajeAGuardar >= 8 && puntajeAGuardar < 32) {
            Juego.back.setIcon(new javax.swing.ImageIcon(Niveles.fondos[1]));
        } else if (puntajeAGuardar >= 32 && puntajeAGuardar < 72) {
            Juego.back.setIcon(new javax.swing.ImageIcon(Niveles.fondos[2]));
        } else if (puntajeAGuardar >= 72 && puntajeAGuardar < 120) {
            Juego.back.setIcon(new javax.swing.ImageIcon(Niveles.fondos[3]));
        } else if (puntajeAGuardar > 120) {
            Juego.back.setIcon(new javax.swing.ImageIcon(Niveles.fondos[5]));
            Juego.player.setVisible(false);
            Juego.enemy.setVisible(false);
            Juego.puntajeLabel.setVisible(false);
            Juego.instruccion.setVisible(false);
            Juego.ptsLabel.setVisible(false);
        }
        //PERSONAJE
        Juego.player.setIcon(new javax.swing.ImageIcon(Niveles.player[0]));

        //ENEMIGO
        if (puntajeAGuardar >= 0 && puntajeAGuardar < 2) {
            Juego.enemy.setIcon(new javax.swing.ImageIcon(Niveles.slimes[0]));
        } else if (puntajeAGuardar >= 2 && puntajeAGuardar < 4) {
            Juego.enemy.setIcon(new javax.swing.ImageIcon(Niveles.slimes[2]));
        } else if (puntajeAGuardar >= 4 && puntajeAGuardar < 6) {
            Juego.enemy.setIcon(new javax.swing.ImageIcon(Niveles.slimes[4]));
        } else if (puntajeAGuardar >= 6 && puntajeAGuardar < 8) {
            Juego.enemy.setIcon(new javax.swing.ImageIcon(Niveles.slimes[6]));
        } else if (puntajeAGuardar >= 8 && puntajeAGuardar < 14) {
            Juego.enemy.setIcon(new javax.swing.ImageIcon(Niveles.fantasmas[0]));
        } else if (puntajeAGuardar >= 14 && puntajeAGuardar < 20) {
            Juego.enemy.setIcon(new javax.swing.ImageIcon(Niveles.fantasmas[2]));
        } else if (puntajeAGuardar >= 20 && puntajeAGuardar < 26) {
            Juego.enemy.setIcon(new javax.swing.ImageIcon(Niveles.fantasmas[4]));
        } else if (puntajeAGuardar >= 26 && puntajeAGuardar < 32) {
            Juego.enemy.setIcon(new javax.swing.ImageIcon(Niveles.fantasmas[6]));
        } else if (puntajeAGuardar >= 32 && puntajeAGuardar < 42) {
            Juego.enemy.setIcon(new javax.swing.ImageIcon(Niveles.dinos[0]));
        } else if (puntajeAGuardar >= 42 && puntajeAGuardar < 52) {
            Juego.enemy.setIcon(new javax.swing.ImageIcon(Niveles.dinos[2]));
        } else if (puntajeAGuardar >= 52 && puntajeAGuardar < 62) {
            Juego.enemy.setIcon(new javax.swing.ImageIcon(Niveles.dinos[4]));
        } else if (puntajeAGuardar >= 62 && puntajeAGuardar < 72) {
            Juego.enemy.setIcon(new javax.swing.ImageIcon(Niveles.dinos[6]));
        } else if (puntajeAGuardar >= 72 && puntajeAGuardar < 88) {
            Juego.enemy.setIcon(new javax.swing.ImageIcon(Niveles.magos[0]));
        } else if (puntajeAGuardar >= 88 && puntajeAGuardar < 104) {
            Juego.enemy.setIcon(new javax.swing.ImageIcon(Niveles.magos[2]));
        } else if (puntajeAGuardar >= 104 && puntajeAGuardar < 120) {
            Juego.enemy.setIcon(new javax.swing.ImageIcon(Niveles.magos[4]));
        } else if (puntajeAGuardar >= 120) {
            Juego.enemy.setIcon(new javax.swing.ImageIcon(Niveles.magos[6]));
        }

        //ACCION
        if (Niveles.fondos[0].equals(Juego.back.getIcon().toString())) {
            Juego.instruccion.setIcon(new ImageIcon(Niveles.slimesAtack[Juego.ataqueSlimes]));
        } else if (Niveles.fondos[1].equals(Juego.back.getIcon().toString())) {
            Juego.instruccion.setIcon(new ImageIcon(Niveles.fantasmasAtack[Juego.ataqueFantasmas]));
        } else if (Niveles.fondos[2].equals(Juego.back.getIcon().toString())) {
            Juego.instruccion.setIcon(new ImageIcon(Niveles.dinosAtack[Juego.ataqueDinos]));
        } else if (Niveles.fondos[3].equals(Juego.back.getIcon().toString())) {
            Juego.instruccion.setIcon(new ImageIcon(Niveles.magoAtack[Juego.ataqueMagos]));
        }
    }

    public static void leerControl() throws InterruptedException {
        try {
            DatabaseReference colorRojo = Login.db.getReference(Login.idDigitado + "/Juego/Colores/Rojo");
            colorRojo.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    control.put("btnRojo", dataSnapshot.getValue(int.class));
                }

                @Override
                public void onCancelled(DatabaseError databaseError) {
                    System.out.println("The read failed: " + databaseError.getCode());
                }
            });
            DatabaseReference colorVerde = Login.db.getReference(Login.idDigitado + "/Juego/Colores/Verde");
            colorVerde.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    control.put("btnVerde", dataSnapshot.getValue(int.class));
                }

                @Override
                public void onCancelled(DatabaseError databaseError) {
                    System.out.println("The read failed: " + databaseError.getCode());
                }
            });
            DatabaseReference colorAzul = Login.db.getReference(Login.idDigitado + "/Juego/Colores/Azul");
            colorAzul.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    control.put("btnAzul", dataSnapshot.getValue(int.class));
                }

                @Override
                public void onCancelled(DatabaseError databaseError) {
                    System.out.println("The read failed: " + databaseError.getCode());
                }
            });
            DatabaseReference btnJstkDer = Login.db.getReference(Login.idDigitado + "/Juego/JoystickDer/Btn");
            btnJstkDer.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    control.put("btnJoystickDer", dataSnapshot.getValue(int.class));
                }

                @Override
                public void onCancelled(DatabaseError databaseError) {
                    System.out.println("The read failed: " + databaseError.getCode());
                }
            });
            DatabaseReference xJstkDer = Login.db.getReference(Login.idDigitado + "/Juego/JoystickDer/X");
            xJstkDer.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    control.put("xJoystickDer", dataSnapshot.getValue(int.class));
                }

                @Override
                public void onCancelled(DatabaseError databaseError) {
                    System.out.println("The read failed: " + databaseError.getCode());
                }
            });
            DatabaseReference yJstkDer = Login.db.getReference(Login.idDigitado + "/Juego/JoystickDer/Y");
            yJstkDer.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    control.put("yJoystickDer", dataSnapshot.getValue(int.class));
                }

                @Override
                public void onCancelled(DatabaseError databaseError) {
                    System.out.println("The read failed: " + databaseError.getCode());
                }
            });
            DatabaseReference btnJstkIzq = Login.db.getReference(Login.idDigitado + "/Juego/JoystickIzq/Btn");
            btnJstkIzq.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    control.put("btnJoystickIzq", dataSnapshot.getValue(int.class));
                }

                @Override
                public void onCancelled(DatabaseError databaseError) {
                    System.out.println("The read failed: " + databaseError.getCode());
                }
            });
            DatabaseReference xJstkIzq = Login.db.getReference(Login.idDigitado + "/Juego/JoystickIzq/X");
            xJstkIzq.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    control.put("xJoystickIzq", dataSnapshot.getValue(int.class));
                }

                @Override
                public void onCancelled(DatabaseError databaseError) {
                    System.out.println("The read failed: " + databaseError.getCode());
                }
            });
            DatabaseReference yJstkIzq = Login.db.getReference(Login.idDigitado + "/Juego/JoystickIzq/Y");
            yJstkIzq.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    control.put("yJoystickIzq", dataSnapshot.getValue(int.class));
                }

                @Override
                public void onCancelled(DatabaseError databaseError) {
                    System.out.println("The read failed: " + databaseError.getCode());
                }
            });
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    /*AUN ESTÁ EN PRUEBAS*/
    public static void pasarNiveles() throws NullPointerException, InterruptedException {
        if (Niveles.fondos[0].equals(Juego.back.getIcon().toString())) {
            int bien = 0;
            if (Niveles.slimesAtack[0].equals(Juego.instruccion.getIcon().toString())) {
                if (bien == control.get("btnAzul")) {
                    puntajeAGuardar = puntajeAGuardar + 1;
                    DatabaseReference led = Login.db.getReference(Login.idDigitado + "/Datos");
                    Map<String, Object> actualizarPuntos = new HashMap<>();
                    actualizarPuntos.put("Puntaje", puntajeAGuardar);
                    led.updateChildrenAsync(actualizarPuntos);
                    Thread.sleep(1000);
                }
            } else if (Niveles.slimesAtack[1].equals(Juego.instruccion.getIcon().toString())) {
                if (bien == control.get("btnJoystickIzq") || bien == control.get("btnJoystickDer")) {
                    puntajeAGuardar = puntajeAGuardar + 1;
                    DatabaseReference led = Login.db.getReference(Login.idDigitado + "/Datos");
                    Map<String, Object> actualizarPuntos = new HashMap<>();
                    actualizarPuntos.put("Puntaje", puntajeAGuardar);
                    led.updateChildrenAsync(actualizarPuntos);
                    Thread.sleep(1000);
                }
            } else if (Niveles.slimesAtack[2].equals(Juego.instruccion.getIcon().toString())) {
                if (bien == control.get("btnRojo")) {
                    puntajeAGuardar = puntajeAGuardar + 1;
                    DatabaseReference led = Login.db.getReference(Login.idDigitado + "/Datos");
                    Map<String, Object> actualizarPuntos = new HashMap<>();
                    actualizarPuntos.put("Puntaje", puntajeAGuardar);
                    led.updateChildrenAsync(actualizarPuntos);
                    Thread.sleep(1000);
                }
            } else if (Niveles.slimesAtack[3].equals(Juego.instruccion.getIcon().toString())) {
                if (bien == control.get("btnVerde")) {
                    puntajeAGuardar = puntajeAGuardar + 1;
                    DatabaseReference led = Login.db.getReference(Login.idDigitado + "/Datos");
                    Map<String, Object> actualizarPuntos = new HashMap<>();
                    actualizarPuntos.put("Puntaje", puntajeAGuardar);
                    led.updateChildrenAsync(actualizarPuntos);
                    Thread.sleep(1000);
                }
            }
        }
        else if (Niveles.fondos[1].equals(Juego.back.getIcon().toString())) {
            if (Niveles.fantasmasAtack[0].equals(Juego.instruccion.getIcon().toString())) {
                int bien = 2;
                if (bien == control.get("yJoystickDer") || bien == control.get("yJoystickIzq")) {
                    puntajeAGuardar = puntajeAGuardar + 3;
                    DatabaseReference led = Login.db.getReference(Login.idDigitado + "/Datos");
                    Map<String, Object> actualizarPuntos = new HashMap<>();
                    actualizarPuntos.put("Puntaje", puntajeAGuardar);
                    led.updateChildrenAsync(actualizarPuntos);
                    Thread.sleep(1000);
                }
            } else if (Niveles.fantasmasAtack[1].equals(Juego.instruccion.getIcon().toString())) {
                int bien = 0;
                if (bien == control.get("yJoystickDer") || bien == control.get("yJoystickIzq")) {
                    puntajeAGuardar = puntajeAGuardar + 3;
                    DatabaseReference led = Login.db.getReference(Login.idDigitado + "/Datos");
                    Map<String, Object> actualizarPuntos = new HashMap<>();
                    actualizarPuntos.put("Puntaje", puntajeAGuardar);
                    led.updateChildrenAsync(actualizarPuntos);
                    Thread.sleep(1000);
                }
            } else if (Niveles.fantasmasAtack[2].equals(Juego.instruccion.getIcon().toString())) {
                int bien = 2;
                if (bien == control.get("xJoystickDer") || bien == control.get("xJoystickIzq")) {
                    puntajeAGuardar = puntajeAGuardar + 3;
                    DatabaseReference led = Login.db.getReference(Login.idDigitado + "/Datos");
                    Map<String, Object> actualizarPuntos = new HashMap<>();
                    actualizarPuntos.put("Puntaje", puntajeAGuardar);
                    led.updateChildrenAsync(actualizarPuntos);
                    Thread.sleep(1000);
                }
            } else if (Niveles.fantasmasAtack[3].equals(Juego.instruccion.getIcon().toString())) {
                int bien = 0;
                if (bien == control.get("xJoystickDer") || bien == control.get("xJoystickIzq")) {
                    puntajeAGuardar = puntajeAGuardar + 3;
                    DatabaseReference led = Login.db.getReference(Login.idDigitado + "/Datos");
                    Map<String, Object> actualizarPuntos = new HashMap<>();
                    actualizarPuntos.put("Puntaje", puntajeAGuardar);
                    led.updateChildrenAsync(actualizarPuntos);
                    Thread.sleep(1000);
                }
            }
        }
        else if (Niveles.fondos[2].equals(Juego.back.getIcon().toString())) {
            if (Niveles.dinosAtack[0].equals(Juego.instruccion.getIcon().toString())) {
                int bienIzq = 2, bienDer = 2;
                if (bienIzq == control.get("yJoystickIzq") && bienDer == control.get("yJoystickDer")) {
                    puntajeAGuardar = puntajeAGuardar + 5;
                    DatabaseReference led = Login.db.getReference(Login.idDigitado + "/Datos");
                    Map<String, Object> actualizarPuntos = new HashMap<>();
                    actualizarPuntos.put("Puntaje", puntajeAGuardar);
                    led.updateChildrenAsync(actualizarPuntos);
                    Thread.sleep(1000);
                }
            } else if (Niveles.dinosAtack[1].equals(Juego.instruccion.getIcon().toString())) {
                int bienIzq = 2, bienDer = 0;
                if (bienIzq == control.get("yJoystickIzq") && bienDer == control.get("yJoystickDer")) {
                    puntajeAGuardar = puntajeAGuardar + 5;
                    DatabaseReference led = Login.db.getReference(Login.idDigitado + "/Datos");
                    Map<String, Object> actualizarPuntos = new HashMap<>();
                    actualizarPuntos.put("Puntaje", puntajeAGuardar);
                    led.updateChildrenAsync(actualizarPuntos);
                    Thread.sleep(1000);
                }
            } else if (Niveles.dinosAtack[2].equals(Juego.instruccion.getIcon().toString())) {
                int bienIzq = 2, bienDer = 2;
                if (bienIzq == control.get("yJoystickIzq") && bienDer == control.get("xJoystickDer")) {
                    puntajeAGuardar = puntajeAGuardar + 5;
                    DatabaseReference led = Login.db.getReference(Login.idDigitado + "/Datos");
                    Map<String, Object> actualizarPuntos = new HashMap<>();
                    actualizarPuntos.put("Puntaje", puntajeAGuardar);
                    led.updateChildrenAsync(actualizarPuntos);
                    Thread.sleep(1000);
                }
            } else if (Niveles.dinosAtack[3].equals(Juego.instruccion.getIcon().toString())) {
                int bienIzq = 2, bienDer = 0;
                if (bienIzq == control.get("yJoystickIzq") && bienDer == control.get("xJoystickDer")) {
                    puntajeAGuardar = puntajeAGuardar + 5;
                    DatabaseReference led = Login.db.getReference(Login.idDigitado + "/Datos");
                    Map<String, Object> actualizarPuntos = new HashMap<>();
                    actualizarPuntos.put("Puntaje", puntajeAGuardar);
                    led.updateChildrenAsync(actualizarPuntos);
                    Thread.sleep(1000);
                }
            } else if (Niveles.dinosAtack[4].equals(Juego.instruccion.getIcon().toString())) {
                int bienIzq = 0, bienDer = 2;
                if (bienIzq == control.get("yJoystickIzq") && bienDer == control.get("yJoystickDer")) {
                    puntajeAGuardar = puntajeAGuardar + 5;
                    DatabaseReference led = Login.db.getReference(Login.idDigitado + "/Datos");
                    Map<String, Object> actualizarPuntos = new HashMap<>();
                    actualizarPuntos.put("Puntaje", puntajeAGuardar);
                    led.updateChildrenAsync(actualizarPuntos);
                    Thread.sleep(1000);
                }
            } else if (Niveles.dinosAtack[5].equals(Juego.instruccion.getIcon().toString())) {
                int bienIzq = 0, bienDer = 0;
                if (bienIzq == control.get("yJoystickIzq") && bienDer == control.get("yJoystickDer")) {
                    puntajeAGuardar = puntajeAGuardar + 5;
                    DatabaseReference led = Login.db.getReference(Login.idDigitado + "/Datos");
                    Map<String, Object> actualizarPuntos = new HashMap<>();
                    actualizarPuntos.put("Puntaje", puntajeAGuardar);
                    led.updateChildrenAsync(actualizarPuntos);
                    Thread.sleep(1000);
                }
            } else if (Niveles.dinosAtack[6].equals(Juego.instruccion.getIcon().toString())) {
                int bienIzq = 0, bienDer = 2;
                if (bienIzq == control.get("yJoystickIzq") && bienDer == control.get("xJoystickDer")) {
                    puntajeAGuardar = puntajeAGuardar + 5;
                    DatabaseReference led = Login.db.getReference(Login.idDigitado + "/Datos");
                    Map<String, Object> actualizarPuntos = new HashMap<>();
                    actualizarPuntos.put("Puntaje", puntajeAGuardar);
                    led.updateChildrenAsync(actualizarPuntos);
                    Thread.sleep(1000);
                }
            } else if (Niveles.dinosAtack[7].equals(Juego.instruccion.getIcon().toString())) {
                int bienIzq = 0, bienDer = 0;
                if (bienIzq == control.get("yJoystickIzq") && bienDer == control.get("xJoystickDer")) {
                    puntajeAGuardar = puntajeAGuardar + 5;
                    DatabaseReference led = Login.db.getReference(Login.idDigitado + "/Datos");
                    Map<String, Object> actualizarPuntos = new HashMap<>();
                    actualizarPuntos.put("Puntaje", puntajeAGuardar);
                    led.updateChildrenAsync(actualizarPuntos);
                    Thread.sleep(1000);
                }
            } else if (Niveles.dinosAtack[8].equals(Juego.instruccion.getIcon().toString())) {
                int bienIzq = 2, bienDer = 2;
                if (bienIzq == control.get("xJoystickIzq") && bienDer == control.get("yJoystickDer")) {
                    puntajeAGuardar = puntajeAGuardar + 5;
                    DatabaseReference led = Login.db.getReference(Login.idDigitado + "/Datos");
                    Map<String, Object> actualizarPuntos = new HashMap<>();
                    actualizarPuntos.put("Puntaje", puntajeAGuardar);
                    led.updateChildrenAsync(actualizarPuntos);
                    Thread.sleep(1000);
                }
            } else if (Niveles.dinosAtack[9].equals(Juego.instruccion.getIcon().toString())) {
                int bienIzq = 2, bienDer = 0;
                if (bienIzq == control.get("xJoystickIzq") && bienDer == control.get("yJoystickDer")) {
                    puntajeAGuardar = puntajeAGuardar + 5;
                    DatabaseReference led = Login.db.getReference(Login.idDigitado + "/Datos");
                    Map<String, Object> actualizarPuntos = new HashMap<>();
                    actualizarPuntos.put("Puntaje", puntajeAGuardar);
                    led.updateChildrenAsync(actualizarPuntos);
                    Thread.sleep(1000);
                }
            } else if (Niveles.dinosAtack[10].equals(Juego.instruccion.getIcon().toString())) {
                int bienIzq = 2, bienDer = 2;
                if (bienIzq == control.get("xJoystickIzq") && bienDer == control.get("xJoystickDer")) {
                    puntajeAGuardar = puntajeAGuardar + 5;
                    DatabaseReference led = Login.db.getReference(Login.idDigitado + "/Datos");
                    Map<String, Object> actualizarPuntos = new HashMap<>();
                    actualizarPuntos.put("Puntaje", puntajeAGuardar);
                    led.updateChildrenAsync(actualizarPuntos);
                    Thread.sleep(1000);
                }
            } else if (Niveles.dinosAtack[11].equals(Juego.instruccion.getIcon().toString())) {
                int bienIzq = 2, bienDer = 0;
                if (bienIzq == control.get("xJoystickIzq") && bienDer == control.get("xJoystickDer")) {
                    puntajeAGuardar = puntajeAGuardar + 5;
                    DatabaseReference led = Login.db.getReference(Login.idDigitado + "/Datos");
                    Map<String, Object> actualizarPuntos = new HashMap<>();
                    actualizarPuntos.put("Puntaje", puntajeAGuardar);
                    led.updateChildrenAsync(actualizarPuntos);
                    Thread.sleep(1000);
                }
            } else if (Niveles.dinosAtack[12].equals(Juego.instruccion.getIcon().toString())) {
                int bienIzq = 0, bienDer = 2;
                if (bienIzq == control.get("xJoystickIzq") && bienDer == control.get("yJoystickDer")) {
                    puntajeAGuardar = puntajeAGuardar + 5;
                    DatabaseReference led = Login.db.getReference(Login.idDigitado + "/Datos");
                    Map<String, Object> actualizarPuntos = new HashMap<>();
                    actualizarPuntos.put("Puntaje", puntajeAGuardar);
                    led.updateChildrenAsync(actualizarPuntos);
                    Thread.sleep(1000);
                }
            } else if (Niveles.dinosAtack[13].equals(Juego.instruccion.getIcon().toString())) {
                int bienIzq = 0, bienDer = 0;
                if (bienIzq == control.get("xJoystickIzq") && bienDer == control.get("yJoystickDer")) {
                    puntajeAGuardar = puntajeAGuardar + 5;
                    DatabaseReference led = Login.db.getReference(Login.idDigitado + "/Datos");
                    Map<String, Object> actualizarPuntos = new HashMap<>();
                    actualizarPuntos.put("Puntaje", puntajeAGuardar);
                    led.updateChildrenAsync(actualizarPuntos);
                    Thread.sleep(1000);
                }
            } else if (Niveles.dinosAtack[14].equals(Juego.instruccion.getIcon().toString())) {
                int bienIzq = 0, bienDer = 2;
                if (bienIzq == control.get("xJoystickIzq") && bienDer == control.get("xJoystickDer")) {
                    puntajeAGuardar = puntajeAGuardar + 5;
                    DatabaseReference led = Login.db.getReference(Login.idDigitado + "/Datos");
                    Map<String, Object> actualizarPuntos = new HashMap<>();
                    actualizarPuntos.put("Puntaje", puntajeAGuardar);
                    led.updateChildrenAsync(actualizarPuntos);
                    Thread.sleep(1000);
                }
            } else if (Niveles.dinosAtack[15].equals(Juego.instruccion.getIcon().toString())) {
                int bienIzq = 0, bienDer = 0;
                if (bienIzq == control.get("xJoystickIzq") && bienDer == control.get("xJoystickDer")) {
                    puntajeAGuardar = puntajeAGuardar + 5;
                    DatabaseReference led = Login.db.getReference(Login.idDigitado + "/Datos");
                    Map<String, Object> actualizarPuntos = new HashMap<>();
                    actualizarPuntos.put("Puntaje", puntajeAGuardar);
                    led.updateChildrenAsync(actualizarPuntos);
                    Thread.sleep(1000);
                }
            }
        }
        else if ((Niveles.fondos[3].equals(Juego.back.getIcon().toString()))){
            if (Niveles.magoAtack[0].equals(Juego.instruccion.getIcon().toString())){
                int bienIzq = 2, bienDer = 0;
                if (bienIzq == control.get("yJoystickIzq") && bienDer == control.get("btnAzul")){
                    puntajeAGuardar = puntajeAGuardar + 8;
                    DatabaseReference led = Login.db.getReference(Login.idDigitado + "/Datos");
                    Map<String, Object> actualizarPuntos = new HashMap<>();
                    actualizarPuntos.put("Puntaje", puntajeAGuardar);
                    led.updateChildrenAsync(actualizarPuntos);
                    Thread.sleep(1000);
                }
            }else if (Niveles.magoAtack[1].equals(Juego.instruccion.getIcon().toString())){
                int bienIzq = 2, bienDer = 0;
                if (bienIzq == control.get("yJoystickIzq") && bienDer == control.get("btnRojo")){
                    puntajeAGuardar = puntajeAGuardar + 8;
                    DatabaseReference led = Login.db.getReference(Login.idDigitado + "/Datos");
                    Map<String, Object> actualizarPuntos = new HashMap<>();
                    actualizarPuntos.put("Puntaje", puntajeAGuardar);
                    led.updateChildrenAsync(actualizarPuntos);
                    Thread.sleep(1000);
                }
            }else if (Niveles.magoAtack[2].equals(Juego.instruccion.getIcon().toString())){
                int bienIzq = 2, bienDer = 0;
                if (bienIzq == control.get("yJoystickIzq") && bienDer == control.get("btnVerde")){
                    puntajeAGuardar = puntajeAGuardar + 8;
                    DatabaseReference led = Login.db.getReference(Login.idDigitado + "/Datos");
                    Map<String, Object> actualizarPuntos = new HashMap<>();
                    actualizarPuntos.put("Puntaje", puntajeAGuardar);
                    led.updateChildrenAsync(actualizarPuntos);
                    Thread.sleep(1000);
                }
            }else if (Niveles.magoAtack[3].equals(Juego.instruccion.getIcon().toString())){
                int bienIzq = 0, bienDer = 0;
                if (bienIzq == control.get("yJoystickIzq") && bienDer == control.get("btnAzul")){
                    puntajeAGuardar = puntajeAGuardar + 8;
                    DatabaseReference led = Login.db.getReference(Login.idDigitado + "/Datos");
                    Map<String, Object> actualizarPuntos = new HashMap<>();
                    actualizarPuntos.put("Puntaje", puntajeAGuardar);
                    led.updateChildrenAsync(actualizarPuntos);
                    Thread.sleep(1000);
                }
            }else if (Niveles.magoAtack[4].equals(Juego.instruccion.getIcon().toString())){
                int bienIzq = 0, bienDer = 0;
                if (bienIzq == control.get("yJoystickIzq") && bienDer == control.get("btnRojo")){
                    puntajeAGuardar = puntajeAGuardar + 8;
                    DatabaseReference led = Login.db.getReference(Login.idDigitado + "/Datos");
                    Map<String, Object> actualizarPuntos = new HashMap<>();
                    actualizarPuntos.put("Puntaje", puntajeAGuardar);
                    led.updateChildrenAsync(actualizarPuntos);
                    Thread.sleep(1000);
                }
            }else if (Niveles.magoAtack[5].equals(Juego.instruccion.getIcon().toString())){
                int bienIzq = 0, bienDer = 0;
                if (bienIzq == control.get("yJoystickIzq") && bienDer == control.get("btnVerde")){
                    puntajeAGuardar = puntajeAGuardar + 8;
                    DatabaseReference led = Login.db.getReference(Login.idDigitado + "/Datos");
                    Map<String, Object> actualizarPuntos = new HashMap<>();
                    actualizarPuntos.put("Puntaje", puntajeAGuardar);
                    led.updateChildrenAsync(actualizarPuntos);
                    Thread.sleep(1000);
                }
            }else if (Niveles.magoAtack[6].equals(Juego.instruccion.getIcon().toString())){
                int bienIzq = 0, bienDer = 2;
                if (bienIzq == control.get("btnAzul") && bienDer == control.get("yJoystickDer")){
                    puntajeAGuardar = puntajeAGuardar + 8;
                    DatabaseReference led = Login.db.getReference(Login.idDigitado + "/Datos");
                    Map<String, Object> actualizarPuntos = new HashMap<>();
                    actualizarPuntos.put("Puntaje", puntajeAGuardar);
                    led.updateChildrenAsync(actualizarPuntos);
                    Thread.sleep(1000);
                }
            }else if (Niveles.magoAtack[7].equals(Juego.instruccion.getIcon().toString())){
                int bienIzq = 0, bienDer = 0;
                if (bienIzq == control.get("btnAzul") && bienDer == control.get("yJoystickDer")){
                    puntajeAGuardar = puntajeAGuardar + 8;
                    DatabaseReference led = Login.db.getReference(Login.idDigitado + "/Datos");
                    Map<String, Object> actualizarPuntos = new HashMap<>();
                    actualizarPuntos.put("Puntaje", puntajeAGuardar);
                    led.updateChildrenAsync(actualizarPuntos);
                    Thread.sleep(1000);
                }
            }else if (Niveles.magoAtack[8].equals(Juego.instruccion.getIcon().toString())){
                int bienIzq = 0, bienDer = 2;
                if (bienIzq == control.get("btnAzul") && bienDer == control.get("xJoystickDer")){
                    puntajeAGuardar = puntajeAGuardar + 8;
                    DatabaseReference led = Login.db.getReference(Login.idDigitado + "/Datos");
                    Map<String, Object> actualizarPuntos = new HashMap<>();
                    actualizarPuntos.put("Puntaje", puntajeAGuardar);
                    led.updateChildrenAsync(actualizarPuntos);
                    Thread.sleep(1000);
                }
            }else if (Niveles.magoAtack[9].equals(Juego.instruccion.getIcon().toString())){
                int bienIzq = 0, bienDer = 0;
                if (bienIzq == control.get("btnAzul") && bienDer == control.get("xJoystickDer")){
                    puntajeAGuardar = puntajeAGuardar + 8;
                    DatabaseReference led = Login.db.getReference(Login.idDigitado + "/Datos");
                    Map<String, Object> actualizarPuntos = new HashMap<>();
                    actualizarPuntos.put("Puntaje", puntajeAGuardar);
                    led.updateChildrenAsync(actualizarPuntos);
                    Thread.sleep(1000);
                }
            }else if (Niveles.magoAtack[10].equals(Juego.instruccion.getIcon().toString())){
                int bienIzq = 0, bienDer = 0;
                if (bienIzq == control.get("btnAzul") && bienDer == control.get("btnRojo")){
                    puntajeAGuardar = puntajeAGuardar + 8;
                    DatabaseReference led = Login.db.getReference(Login.idDigitado + "/Datos");
                    Map<String, Object> actualizarPuntos = new HashMap<>();
                    actualizarPuntos.put("Puntaje", puntajeAGuardar);
                    led.updateChildrenAsync(actualizarPuntos);
                    Thread.sleep(1000);
                }
            }else if (Niveles.magoAtack[11].equals(Juego.instruccion.getIcon().toString())){
                int bienIzq = 2, bienDer = 0;
                if (bienIzq == control.get("xJoystickIzq") && bienDer == control.get("btnAzul")){
                    puntajeAGuardar = puntajeAGuardar + 8;
                    DatabaseReference led = Login.db.getReference(Login.idDigitado + "/Datos");
                    Map<String, Object> actualizarPuntos = new HashMap<>();
                    actualizarPuntos.put("Puntaje", puntajeAGuardar);
                    led.updateChildrenAsync(actualizarPuntos);
                    Thread.sleep(1000);
                }
            }else if (Niveles.magoAtack[12].equals(Juego.instruccion.getIcon().toString())){
                int bienIzq = 2, bienDer = 0;
                if (bienIzq == control.get("xJoystickIzq") && bienDer == control.get("btnRojo")){
                    puntajeAGuardar = puntajeAGuardar + 8;
                    DatabaseReference led = Login.db.getReference(Login.idDigitado + "/Datos");
                    Map<String, Object> actualizarPuntos = new HashMap<>();
                    actualizarPuntos.put("Puntaje", puntajeAGuardar);
                    led.updateChildrenAsync(actualizarPuntos);
                    Thread.sleep(1000);
                }
            }else if (Niveles.magoAtack[13].equals(Juego.instruccion.getIcon().toString())){
                int bienIzq = 2, bienDer = 0;
                if (bienIzq == control.get("xJoystickIzq") && bienDer == control.get("btnVerde")){
                    puntajeAGuardar = puntajeAGuardar + 8;
                    DatabaseReference led = Login.db.getReference(Login.idDigitado + "/Datos");
                    Map<String, Object> actualizarPuntos = new HashMap<>();
                    actualizarPuntos.put("Puntaje", puntajeAGuardar);
                    led.updateChildrenAsync(actualizarPuntos);
                    Thread.sleep(1000);
                }
            }else if (Niveles.magoAtack[14].equals(Juego.instruccion.getIcon().toString())){
                int bienIzq = 0, bienDer = 0;
                if (bienIzq == control.get("xJoystickIzq") && bienDer == control.get("btnAzul")){
                    puntajeAGuardar = puntajeAGuardar + 8;
                    DatabaseReference led = Login.db.getReference(Login.idDigitado + "/Datos");
                    Map<String, Object> actualizarPuntos = new HashMap<>();
                    actualizarPuntos.put("Puntaje", puntajeAGuardar);
                    led.updateChildrenAsync(actualizarPuntos);
                    Thread.sleep(1000);
                }
            }else if (Niveles.magoAtack[15].equals(Juego.instruccion.getIcon().toString())){
                int bienIzq = 0, bienDer = 0;
                if (bienIzq == control.get("xJoystickIzq") && bienDer == control.get("btnRojo")){
                    puntajeAGuardar = puntajeAGuardar + 8;
                    DatabaseReference led = Login.db.getReference(Login.idDigitado + "/Datos");
                    Map<String, Object> actualizarPuntos = new HashMap<>();
                    actualizarPuntos.put("Puntaje", puntajeAGuardar);
                    led.updateChildrenAsync(actualizarPuntos);
                    Thread.sleep(1000);
                }
            }else if (Niveles.magoAtack[16].equals(Juego.instruccion.getIcon().toString())){
                int bienIzq = 0, bienDer = 0;
                if (bienIzq == control.get("xJoystickIzq") && bienDer == control.get("btnVerde")){
                    puntajeAGuardar = puntajeAGuardar + 8;
                    DatabaseReference led = Login.db.getReference(Login.idDigitado + "/Datos");
                    Map<String, Object> actualizarPuntos = new HashMap<>();
                    actualizarPuntos.put("Puntaje", puntajeAGuardar);
                    led.updateChildrenAsync(actualizarPuntos);
                    Thread.sleep(1000);
                }
            }else if (Niveles.magoAtack[17].equals(Juego.instruccion.getIcon().toString())){
                int bienIzq = 0, bienDer = 2;
                if (bienIzq == control.get("btnRojo") && bienDer == control.get("yJoystickDer")){
                    puntajeAGuardar = puntajeAGuardar + 8;
                    DatabaseReference led = Login.db.getReference(Login.idDigitado + "/Datos");
                    Map<String, Object> actualizarPuntos = new HashMap<>();
                    actualizarPuntos.put("Puntaje", puntajeAGuardar);
                    led.updateChildrenAsync(actualizarPuntos);
                    Thread.sleep(1000);
                }
            }else if (Niveles.magoAtack[18].equals(Juego.instruccion.getIcon().toString())){
                int bienIzq = 0, bienDer = 0;
                if (bienIzq == control.get("btnRojo") && bienDer == control.get("yJoystickDer")){
                    puntajeAGuardar = puntajeAGuardar + 8;
                    DatabaseReference led = Login.db.getReference(Login.idDigitado + "/Datos");
                    Map<String, Object> actualizarPuntos = new HashMap<>();
                    actualizarPuntos.put("Puntaje", puntajeAGuardar);
                    led.updateChildrenAsync(actualizarPuntos);
                    Thread.sleep(1000);
                }
            }else if (Niveles.magoAtack[19].equals(Juego.instruccion.getIcon().toString())){
                int bienIzq = 0, bienDer = 2;
                if (bienIzq == control.get("btnRojo") && bienDer == control.get("xJoystickDer")){
                    puntajeAGuardar = puntajeAGuardar + 8;
                    DatabaseReference led = Login.db.getReference(Login.idDigitado + "/Datos");
                    Map<String, Object> actualizarPuntos = new HashMap<>();
                    actualizarPuntos.put("Puntaje", puntajeAGuardar);
                    led.updateChildrenAsync(actualizarPuntos);
                    Thread.sleep(1000);
                }
            }else if (Niveles.magoAtack[20].equals(Juego.instruccion.getIcon().toString())){
                int bienIzq = 0, bienDer = 0;
                if (bienIzq == control.get("btnRojo") && bienDer == control.get("xJoystickDer")){
                    puntajeAGuardar = puntajeAGuardar + 8;
                    DatabaseReference led = Login.db.getReference(Login.idDigitado + "/Datos");
                    Map<String, Object> actualizarPuntos = new HashMap<>();
                    actualizarPuntos.put("Puntaje", puntajeAGuardar);
                    led.updateChildrenAsync(actualizarPuntos);
                    Thread.sleep(1000);
                }
            }else if (Niveles.magoAtack[21].equals(Juego.instruccion.getIcon().toString())){
                int bienIzq = 0, bienDer = 2;
                if (bienIzq == control.get("btnVerde") && bienDer == control.get("yJoystickDer")){
                    puntajeAGuardar = puntajeAGuardar + 8;
                    DatabaseReference led = Login.db.getReference(Login.idDigitado + "/Datos");
                    Map<String, Object> actualizarPuntos = new HashMap<>();
                    actualizarPuntos.put("Puntaje", puntajeAGuardar);
                    led.updateChildrenAsync(actualizarPuntos);
                    Thread.sleep(1000);
                }
            }else if (Niveles.magoAtack[22].equals(Juego.instruccion.getIcon().toString())){
                int bienIzq = 0, bienDer = 0;
                if (bienIzq == control.get("btnVerde") && bienDer == control.get("yJoystickDer")){
                    puntajeAGuardar = puntajeAGuardar + 8;
                    DatabaseReference led = Login.db.getReference(Login.idDigitado + "/Datos");
                    Map<String, Object> actualizarPuntos = new HashMap<>();
                    actualizarPuntos.put("Puntaje", puntajeAGuardar);
                    led.updateChildrenAsync(actualizarPuntos);
                    Thread.sleep(1000);
                }
            }else if (Niveles.magoAtack[23].equals(Juego.instruccion.getIcon().toString())){
                int bienIzq = 0, bienDer = 0;
                if (bienIzq == control.get("btnVerde") && bienDer == control.get("btnAzul")){
                    puntajeAGuardar = puntajeAGuardar + 8;
                    DatabaseReference led = Login.db.getReference(Login.idDigitado + "/Datos");
                    Map<String, Object> actualizarPuntos = new HashMap<>();
                    actualizarPuntos.put("Puntaje", puntajeAGuardar);
                    led.updateChildrenAsync(actualizarPuntos);
                    Thread.sleep(1000);
                }
            }else if (Niveles.magoAtack[24].equals(Juego.instruccion.getIcon().toString())){
                int bienIzq = 0, bienDer = 2;
                if (bienIzq == control.get("btnVerde") && bienDer == control.get("xJoystickDer")){
                    puntajeAGuardar = puntajeAGuardar + 8;
                    DatabaseReference led = Login.db.getReference(Login.idDigitado + "/Datos");
                    Map<String, Object> actualizarPuntos = new HashMap<>();
                    actualizarPuntos.put("Puntaje", puntajeAGuardar);
                    led.updateChildrenAsync(actualizarPuntos);
                    Thread.sleep(1000);
                }
            }else if (Niveles.magoAtack[25].equals(Juego.instruccion.getIcon().toString())){
                int bienIzq = 0, bienDer = 0;
                if (bienIzq == control.get("btnVerde") && bienDer == control.get("xJoystickDer")){
                    puntajeAGuardar = puntajeAGuardar + 8;
                    DatabaseReference led = Login.db.getReference(Login.idDigitado + "/Datos");
                    Map<String, Object> actualizarPuntos = new HashMap<>();
                    actualizarPuntos.put("Puntaje", puntajeAGuardar);
                    led.updateChildrenAsync(actualizarPuntos);
                    Thread.sleep(1000);
                }
            }else if (Niveles.magoAtack[26].equals(Juego.instruccion.getIcon().toString())){
                int bienIzq = 0, bienDer = 0;
                if (bienIzq == control.get("btnVerde") && bienDer == control.get("btnRojo")){
                    puntajeAGuardar = puntajeAGuardar + 8;
                    DatabaseReference led = Login.db.getReference(Login.idDigitado + "/Datos");
                    Map<String, Object> actualizarPuntos = new HashMap<>();
                    actualizarPuntos.put("Puntaje", puntajeAGuardar);
                    led.updateChildrenAsync(actualizarPuntos);
                    Thread.sleep(1000);
                }
            }
        }
    }
}