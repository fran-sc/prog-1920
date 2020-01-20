package juegos.sieteymedia;

import juegos.recursos.*;
import java.util.Scanner;

class GameController {
    private static final int APUESTA_MIN = 10;

    protected Baraja baraja;
    protected Jugador player;

    public static void main(String[] args) {
        boolean juego = true, jugada = true;

        Scanner cin = new Scanner(System.in);

        GameController gc = new GameController();
        gc.iniciaComponentes();

        int apuesta=0, totalApuesta=0;
        while(juego) {
            while(jugada) {
                if(gc.player.getNumCartas()!=0) {
                    System.out.println("Tus cartas son: ");
                    Carta[] cartas = gc.player.getCartas();
                    for(Carta c: cartas)
                        System.out.print(c + " ");
                    
                    System.out.println("Valor jugada: " + gc.valorJugada(cartas));
                    
                    System.out.println("Tu apuesta total en la jugada es de: " + totalApuesta + 
                                        " creditos");
                    
                    System.out.println("Tu crédito es de: " + gc.player.getCredito());

                    if(gc.pideCartas()) {

                    }
                }

            }                
        }
    }

    private void iniciaComponentes() {
        Scanner cin = new Scanner(System.in);
        
        // Baraja
        this.baraja = new Baraja(); 

        // Player
        System.out.println("Cuál es tu nombre? ");
        this.player = new Jugador(cin.nextLine().trim());

        System.out.println("Bienvenido, " + this.player.getNombre() + ". Vamos a jugar!");
        System.out.println("Pero antes, las reglas:");
        System.out.println("- Yo haré de banca");
        System.out.println("- Antes de pedir una carta, debes hacer una apuesta. ");
        System.out.println("- La apuesta no puede ser inferior a " + this.APUESTA_MIN);
        System.out.print("- Y el monto de las apuestas de cada partida no puede superar ");
        System.out.println("la mitad del crédito del que dispongas al empezar");
        System.out.print("- Puedes sacar todas las cartas que quieras. Recuerda, ");
        System.out.println("las figuras (10, 11 y 12) valen medio punto y, el resto, su valor");
        System.out.print("- Si la suma de los valores de las cartas sacadas es superior ");
        System.out.println("a 7 y medio, se pierde");
        System.out.println("- Puedes plantarte en cualquier momento");
        System.out.print("- Yo, al ser la banca, estoy obligado a sacar cartas hasta superar ");
        System.out.println("tu jugada o pasarme");
        System.out.println("- Ganas si obtienes una jugada de valor superior a la mía");
        System.out.println("- En caso de empate, gano yo");
        System.out.println("- En caso de que uno de los dos saque 7 y media, se pagará el doble");
        System.out.println("- En caso de quedarte sin crédito, el juego finalizará");
        System.out.println("\nEmpecemos!!!\n");
    }

    private double valorJugada(Carta[] cartas) {
        double total = 0.0;
        int val;
        for(Carta c: cartas) {
            val = c.getValor();
            total += (val>7)?0.5:val;
        }

        return total;
    }

    private boolean pideCartas() {
        Scanner cin = new Scanner(System.in);

        boolean nueva_carta = false;
                    
        loop_carta:
        while(true) {
            System.out.println("¿Pides [C]arta o te [P]lantas?");
            char opc = cin.nextLine().trim().toUpperCase().charAt(0);
            switch(opc) {
                case 'C':
                    nueva_carta = true;
                    break loop_carta;
                case 'P':
                    break loop_carta;
                default:
                    System.out.println("No te entendí...");
            }
        }    
        
        return nueva_carta;
    }
}