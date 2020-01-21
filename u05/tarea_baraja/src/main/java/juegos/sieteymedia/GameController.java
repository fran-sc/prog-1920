package juegos.sieteymedia;

import juegos.recursos.*;

import java.io.IOException;
import java.util.Scanner;

class GameController {
    private static final int APUESTA_MIN = 10;
    private static final double JUGADA_MAX = 7.5;

    protected Baraja baraja;
    protected Jugador player;

    public static void main(String[] args) {
        boolean juego = true, finJugada, nueva_carta;;
        int totalApuesta;
        Scanner cin = new Scanner(System.in);

        GameController gc = new GameController();
        gc.iniciaComponentes();

        while(juego) {
            gc.player.reiniciaMano();
            totalApuesta = 0;
            finJugada = false;
            gc.baraja.reinicia();

            while(!finJugada) {
                nueva_carta = (gc.player.getNumCartas()==0)?true:false;
                
                if(!nueva_carta) {
                    gc.muestraJugada(totalApuesta);

                    nueva_carta = gc.checkPlayerPideCartas();
                    finJugada = !nueva_carta;
                }

                if(nueva_carta) {
                    totalApuesta += gc.pedirCartaPlayer();
                    if(gc.valorJugada(gc.player.getCartas())>=JUGADA_MAX)
                        finJugada = true;
                }
            } 
            gc.juegaMano(totalApuesta);    
            
            juego = gc.checkContinuarJuego();           
        }

        int dif = gc.player.getCredito() - Jugador.DEF_CREDITO;
        if(dif>=0)
            System.out.println("\nEnhorabuena,  " + gc.player.getNombre() + "! Has ganado " +                           gc.player.getCredito() + " créditos");
        else
            System.out.println("\nLo siento " + gc.player.getNombre() + ". Has perdido " +
                                (-1)*dif + " créditos.\nMejor suerte la próxima vez");
    }

    private void muestraJugada(int apuesta) {
        System.out.println("\nTus cartas son: ");
        Carta[] cartas = this.player.getCartas();
        for(Carta c: cartas)
            System.out.print(c + " ");
        
        System.out.println("\nValor jugada: " + valToString(this.valorJugada(cartas)));
        
        System.out.println("\nTu apuesta total en la jugada es de: " + apuesta + 
                            " créditos");
    }

    private void iniciaComponentes() {
        Scanner cin = new Scanner(System.in);
        
        // Baraja
        this.baraja = new Baraja(); 

        // Player
        System.out.print("\nCómo te llamas? ");
        this.player = new Jugador(cin.nextLine().trim());

        System.out.println("\nBienvenido, " + this.player.getNombre() + ". Vamos a jugar!");
        System.out.println("\nPero antes, las reglas:");
        System.out.println("- Yo haré de banca");
        System.out.println("- Antes de pedir una carta, debes hacer una apuesta. ");
        System.out.println("- La apuesta no puede ser inferior a " + APUESTA_MIN);
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
        System.out.println("\nTu crédito actual es de: " + this.player.getCredito() + " créditos");
        System.out.println("\nEmpecemos!!!");
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

    private boolean checkContinuarJuego() {
        Scanner cin = new Scanner(System.in);

        boolean continuar = false;

        loop_cont:
        while(true) {
            System.out.println("\n¿Quieres continuar? [S/N]");
            char opc = cin.nextLine().trim().toUpperCase().charAt(0);
            switch(opc) {
                case 'S':
                    continuar = true;
                    break loop_cont;
                case 'N':
                    break loop_cont;
                default:
                    System.out.println("No te entendí...");
            }
        }    

        return continuar;
    }

    private boolean checkPlayerPideCartas() {
        Scanner cin = new Scanner(System.in);

        boolean nueva_carta = false;

        loop_carta:
        while(true) {
            System.out.println("\n¿Pides [C]arta o te [P]lantas?");
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

    private int pedirCartaPlayer() {
        int apuesta=0;

        Scanner cin = new Scanner(System.in);

        while(true) {
            System.out.println("\n¿Cuánto deseas apostar? (mín: " + APUESTA_MIN + " créditos)"); 
            apuesta = Integer.parseInt(cin.nextLine().trim());       
            if(apuesta>=APUESTA_MIN) 
                break;
        }

        this.player.nuevaCarta(this.baraja.daCartas(1)[0]);

        return apuesta;
    }

    private void juegaMano(int apuesta) {
        Scanner cin = new Scanner(System.in);

        muestraJugada(apuesta);

        double playerVal = this.valorJugada(this.player.getCartas());

        if(playerVal>GameController.JUGADA_MAX) {
            System.out.println("\n----> Ohhh!!! Te pasaste. Yo gano!");
            apuesta *= -1;
        }
        else {
            double bancaVal = 0.0;
            
            if(playerVal==GameController.JUGADA_MAX) 
                System.out.println("\nWow!! Siete y media!");
            
            System.out.println("\nVoy a sacar mis cartas...\n");
            System.err.println("Pulsa [RET] para continuar...");
            cin.nextLine();

            while(bancaVal<playerVal && bancaVal<GameController.JUGADA_MAX) {
                Carta c = this.baraja.daCartas(1)[0];
                int val = c.getValor();
                bancaVal += (val>7)?0.5:val;
                System.out.print(c + " ");
            }
            System.out.println("\nValor jugada: " + valToString(bancaVal));
            
            if(bancaVal==GameController.JUGADA_MAX) {
                System.out.println("\n----> Wow!! Siete y media! Yo gano!");
                apuesta *= -2;
            }
            else if(bancaVal>GameController.JUGADA_MAX) {
                System.out.println("\n----> Me pasé! Tú ganas!!");
                if(playerVal==GameController.JUGADA_MAX)
                    apuesta *= 2;
            }
            else {
                System.out.println("\n----> Ohhh!!! Yo gano!");
                apuesta *= -1;
            }
        }
        
        this.player.actualizaCredito(apuesta);
        System.out.println("\nTu crédito ahora es de: " + this.player.getCredito() + " créditos");
    }

    private String valToString(double val) {
        String s = "";

        if(val>=1.0) s += (int)val;

        if((val-(int)val)>0) s += ((s.length()>0)?" y ":"") + "media";

        return s;
    }
}