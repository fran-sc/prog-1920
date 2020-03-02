package zork;

import java.util.Scanner;
import java.util.Random;

public class ZorkGame implements ZorkData {
    private Jugador jugador;
    private Sala[] salas;

    public void init() {
        Random r = new Random();

        jugador = new Jugador();

        // Salas
        salas = new Sala[NUM_SALAS];
        sala[0] = new SalaComun(TEXT[r.nextInt(TEX_COM_LEN) + TEXT_COM_INI]);
        sala[1] = new SalaComun(TEXT[r.nextInt(TEX_COM_LEN) + TEXT_COM_INI]);
        sala[2] = new SalaTesoro(TEXT[TEXT_TES]);
        sala[4] = new SalaComun(TEXT[r.nextInt(TEX_COM_LEN) + TEXT_COM_INI]);
        sala[5] = new SalaTrampa(TEXT[TEXT_TRA]);
        sala[6] = new SalaComun(TEXT[r.nextInt(TEX_COM_LEN) + TEXT_COM_INI]);
        sala[7] = new SalaComun(TEXT[r.nextInt(TEX_COM_LEN) + TEXT_COM_INI]);
        sala[8] = new SalaComun(TEXT[TEXT_ENT]);
        sala[9] = new SalaComun(TEXT[r.nextInt(TEX_COM_LEN) + TEXT_COM_INI]);
        sala[10] = new SalaExterior(TEXT[TEXT_EXT]);

        // Puertas
        sala[0].setPuerta(Dir.E, sala[1]);
        sala[0].setPuerta(Dir.S, sala[3]);

        sala[1].setPuerta(Dir.O, sala[0]);
        sala[1].setPuerta(Dir.S, sala[4]);
        sala[1].setPuerta(Dir.E, sala[2]);

        sala[2].setPuerta(Dir.O, sala[1]);
        sala[2].setPuerta(Dir.S, sala[5]);

        sala[3].setPuerta(Dir.N, sala[0]);
        sala[3].setPuerta(Dir.S, sala[6]);
        sala[3].setPuerta(Dir.E, sala[4]);

        sala[4].setPuerta(Dir.N, sala[1]);
        sala[4].setPuerta(Dir.S, sala[7]);
        sala[4].setPuerta(Dir.E, sala[5]);
        sala[4].setPuerta(Dir.O, sala[3]);

        sala[5].setPuerta(Dir.O, sala[1]);
        sala[5].setPuerta(Dir.S, sala[5]);        
    }

    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);

        ZorkGame zork = new ZorkGame();    

    }
}