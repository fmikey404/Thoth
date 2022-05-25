package juego;

public class Niveles {

    public static String[] fondos = new String[6];
    public static String[] slimes = new String[8];
    public static String[] slimesAtack = new String[4];
    public static String[] fantasmas = new String[8];
    public static String[] fantasmasAtack = new String[4];
    public static String[] dinos = new String[8];
    public static String[] dinosAtack = new String[16];
    public static String[] magos = new String[8];
    public static String[] magoAtack = new String[27];
    public static String[] player = new String[2];

    public static void guardarImg(){
        player[0] = "src/main/java/resources/Player/Player.gif";
        player[1] = "src/main/java/resources/Player/PAttack.gif";

        fondos[0] = "src/main/java/resources/Fondos/Playa.jpg";
        fondos[1]= "src/main/java/resources/Fondos/Montañas.jpg";
        fondos[2] = "src/main/java/resources/Fondos/Desierto.jpg";
        fondos[3] = "src/main/java/resources/Fondos/Bosque.jpg";
        fondos[4] = "src/main/java/resources/Fondos/SubirNivel.jpg";
        fondos[5] = "src/main/java/resources/Fondos/FinJuego.jpg";

        slimes[0] ="src/main/java/resources/Niveles/Slimes/Enemigos/slime_azul.gif";
        slimes[1] = "src/main/java/resources/Niveles/Slimes/Enemigos/slime_azul_muerte.gif";
        slimes[2] = "src/main/java/resources/Niveles/Slimes/Enemigos/slime_verde.gif";
        slimes[3] = "src/main/java/resources/Niveles/Slimes/Enemigos/slime_verde_muerte.gif";
        slimes[4] = "src/main/java/resources/Niveles/Slimes/Enemigos/slime_rosa.gif";
        slimes[5] = "src/main/java/resources/Niveles/Slimes/Enemigos/slime_rosa_muerte.gif";
        slimes[6] = "src/main/java/resources/Niveles/Slimes/Enemigos/slime_amarillo.gif";
        slimes[7] = "src/main/java/resources/Niveles/Slimes/Enemigos/slime_amarillo_muerte.gif";

        slimesAtack[0] = "src/main/java/resources/Niveles/Slimes/Ataques/azul.png";
        slimesAtack[1] = "src/main/java/resources/Niveles/Slimes/Ataques/joystick.png";
        slimesAtack[2] = "src/main/java/resources/Niveles/Slimes/Ataques/rojo.png";
        slimesAtack[3] = "src/main/java/resources/Niveles/Slimes/Ataques/verde.png";

        fantasmas[0] = "src/main/java/resources/Niveles/Fantasmas/Enemigos/fanasme_blanco.gif";
        fantasmas[1] = "src/main/java/resources/Niveles/Fantasmas/Enemigos/fanasme_blanco_muerte.gif";
        fantasmas[2] = "src/main/java/resources/Niveles/Fantasmas/Enemigos/fanasme_celeste.gif";
        fantasmas[3] = "src/main/java/resources/Niveles/Fantasmas/Enemigos/fanasme_celeste_muerte.gif";
        fantasmas[4] = "src/main/java/resources/Niveles/Fantasmas/Enemigos/fanasme_naranja.gif";
        fantasmas[5] = "src/main/java/resources/Niveles/Fantasmas/Enemigos/fanasme_naranja_muerte.gif";
        fantasmas[6] = "src/main/java/resources/Niveles/Fantasmas/Enemigos/fanasme_morado.gif";
        fantasmas[7] = "src/main/java/resources/Niveles/Fantasmas/Enemigos/fanasme_morado_muerte.gif";

        fantasmasAtack[0] = "src/main/java/resources/Niveles/Fantasmas/Ataques/abajo.png";
        fantasmasAtack[1] = "src/main/java/resources/Niveles/Fantasmas/Ataques/arriba.png";
        fantasmasAtack[2] = "src/main/java/resources/Niveles/Fantasmas/Ataques/derecha.png";
        fantasmasAtack[3] = "src/main/java/resources/Niveles/Fantasmas/Ataques/izquierda.png";

        dinos[0] = "src/main/java/resources/Niveles/Dinos/Enemigos/dinosaurio_azul.gif";
        dinos[1] = "src/main/java/resources/Niveles/Dinos/Enemigos/dinosaurio_azul_muerte.gif";
        dinos[2] = "src/main/java/resources/Niveles/Dinos/Enemigos/dinosaurio_verde.gif";
        dinos[3] = "src/main/java/resources/Niveles/Dinos/Enemigos/dinosaurio_verde_muerte.gif";
        dinos[4] = "src/main/java/resources/Niveles/Dinos/Enemigos/dinosaurio_naranja.gif";
        dinos[5] = "src/main/java/resources/Niveles/Dinos/Enemigos/dinosaurio_naranja_muerte.gif";
        dinos[6] = "src/main/java/resources/Niveles/Dinos/Enemigos/dinosaurio_rojo.gif";
        dinos[7] = "src/main/java/resources/Niveles/Dinos/Enemigos/dinosaurio_rojo_muerte.gif";

        dinosAtack[0] = "src/main/java/resources/Niveles/Dinos/Ataques/abajoIzquierda+abajoDerecha.png";
        dinosAtack[1] = "src/main/java/resources/Niveles/Dinos/Ataques/abajoIzquierda+arribaDerecha.png";
        dinosAtack[2] = "src/main/java/resources/Niveles/Dinos/Ataques/abajoIzquierda+derechaDerecha.png";
        dinosAtack[3] = "src/main/java/resources/Niveles/Dinos/Ataques/abajoIzquierda+izquierdaDerecha.png";
        dinosAtack[4] = "src/main/java/resources/Niveles/Dinos/Ataques/arribaIzquierda+abajoDerecha.png";
        dinosAtack[5] = "src/main/java/resources/Niveles/Dinos/Ataques/arribaIzquierda+arribaDerecha.png";
        dinosAtack[6] = "src/main/java/resources/Niveles/Dinos/Ataques/arribaIzquierda+derechaDerecha.png";
        dinosAtack[7] = "src/main/java/resources/Niveles/Dinos/Ataques/arribaIzquierda+izquierdaDerecha.png";
        dinosAtack[8] = "src/main/java/resources/Niveles/Dinos/Ataques/derechaIzquierda+abajoDerecha.png";
        dinosAtack[9] = "src/main/java/resources/Niveles/Dinos/Ataques/derechaIzquierda+arribaDerecha.png";
        dinosAtack[10] = "src/main/java/resources/Niveles/Dinos/Ataques/derechaIzquierda+derechaDerecha.png";
        dinosAtack[11] = "src/main/java/resources/Niveles/Dinos/Ataques/derechaIzquierda+izquierdaDerecha.png";
        dinosAtack[12] = "src/main/java/resources/Niveles/Dinos/Ataques/izquierdaIzquierda+abajoDerecha.png";
        dinosAtack[13] = "src/main/java/resources/Niveles/Dinos/Ataques/izquierdaIzquierda+arribaDerecha.png";
        dinosAtack[14] = "src/main/java/resources/Niveles/Dinos/Ataques/izquierdaIzquierda+derechaDerecha.png";
        dinosAtack[15] = "src/main/java/resources/Niveles/Dinos/Ataques/izquierdaIzquierda+izquierdaDerecha.png";

        magos[0] = "src/main/java/resources/Niveles/Magos/Enemigos/mago_azul.gif";
        magos[1] = "src/main/java/resources/Niveles/Magos/Enemigos/mago_azul_muerte.gif";
        magos[2] = "src/main/java/resources/Niveles/Magos/Enemigos/mago_verde.gif";
        magos[3] = "src/main/java/resources/Niveles/Magos/Enemigos/mago_verde_muerte.gif";
        magos[4] = "src/main/java/resources/Niveles/Magos/Enemigos/mago_naranja.gif";
        magos[5] = "src/main/java/resources/Niveles/Magos/Enemigos/mago_naranja_muerte.gif";
        magos[6] = "src/main/java/resources/Niveles/Magos/Enemigos/mago_morado.gif";
        magos[7] = "src/main/java/resources/Niveles/Magos/Enemigos/mago_moradol_muerte.gif";

        magoAtack[0] = "src/main/java/resources/Niveles/Magos/Ataques/abajoIzquierda+azul.png";
        magoAtack[1] = "src/main/java/resources/Niveles/Magos/Ataques/abajoIzquierda+rojo.png";
        magoAtack[2] = "src/main/java/resources/Niveles/Magos/Ataques/abajoIzquierda+verde.png";
        magoAtack[3] = "src/main/java/resources/Niveles/Magos/Ataques/arribaIzquierda+azul.png";
        magoAtack[4] = "src/main/java/resources/Niveles/Magos/Ataques/arribaIzquierda+rojol.png";
        magoAtack[5] = "src/main/java/resources/Niveles/Magos/Ataques/arribaIzquierda+verde.png";
        magoAtack[6] = "src/main/java/resources/Niveles/Magos/Ataques/azul+abajoDerecha.png";
        magoAtack[7] = "src/main/java/resources/Niveles/Magos/Ataques/azul+arribaDerecha.png";
        magoAtack[8] = "src/main/java/resources/Niveles/Magos/Ataques/azul+derechaDerecha.png";
        magoAtack[9] = "src/main/java/resources/Niveles/Magos/Ataques/azul+izquierdaDerecha.png";
        magoAtack[10] = "src/main/java/resources/Niveles/Magos/Ataques/azul+rojo.png";
        magoAtack[11] = "src/main/java/resources/Niveles/Magos/Ataques/derechaIzquierda+azul.png";
        magoAtack[12] = "src/main/java/resources/Niveles/Magos/Ataques/derechaIzquierda+rojo.png";
        magoAtack[13] = "src/main/java/resources/Niveles/Magos/Ataques/derechaIzquierda+verde.png";
        magoAtack[14] = "src/main/java/resources/Niveles/Magos/Ataques/izquierdaIzquierda+azul.png";
        magoAtack[15] = "src/main/java/resources/Niveles/Magos/Ataques/izquierdaIzquierda+rojo.png";
        magoAtack[16] = "src/main/java/resources/Niveles/Magos/Ataques/izquierdaIzquierda+verde.png";
        magoAtack[17] = "src/main/java/resources/Niveles/Magos/Ataques/rojo+abajoDerecha.png";
        magoAtack[18] = "src/main/java/resources/Niveles/Magos/Ataques/rojo+arribaDerecha.png";
        magoAtack[19] = "src/main/java/resources/Niveles/Magos/Ataques/rojo+derechaDerecha.png";
        magoAtack[20] = "src/main/java/resources/Niveles/Magos/Ataques/rojo+izquierdaDerecha.png";
        magoAtack[21] = "src/main/java/resources/Niveles/Magos/Ataques/verde+abajoDerecha.png";
        magoAtack[22] = "src/main/java/resources/Niveles/Magos/Ataques/verde+arribaDerecha.png";
        magoAtack[23] = "src/main/java/resources/Niveles/Magos/Ataques/verde+azul.png";
        magoAtack[24] = "src/main/java/resources/Niveles/Magos/Ataques/verde+derechaDerecha.png";
        magoAtack[25] = "src/main/java/resources/Niveles/Magos/Ataques/verde+izquierdaDerecha.png";
        magoAtack[26] = "src/main/java/resources/Niveles/Magos/Ataques/verde+rojo.png";
    }

}
