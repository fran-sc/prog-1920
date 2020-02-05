package dd.main;

import dd.core.*;
import java.util.Random;
import java.util.Arrays;

public class DDApp {
    private static final int NUM_HOMBRES = 3;
    private static final int MIN_TROLLS = 2;
    private static final int MAX_TROLLS = 10;

    public static void main(String[] args) {
        // Creamos el ejército de los hombres
        Personaje[] hombres = initMenArmy();

        // Creamos el ejército de trolls
        Personaje[] trolls = initTrollsArmy();

        // Lanzamos el bucle de ejecución principal
        gameLoop(hombres, trolls);
    }

    private static Personaje[] initMenArmy() {
        Personaje[] hombres = new Personaje[NUM_HOMBRES];

        // Añadimos los personajes
        hombres[0] = new Rey("Arturo");
        hombres[0].setAtaque(new AtaqueEspada());

        hombres[1] = new Caballero("Lancelot");
        hombres[1].setAtaque(new AtaqueEspada());

        hombres[2] = new Caballero("Percival");
        hombres[2].setAtaque(new AtaqueArco());

        return hombres;
    }

    private static Personaje[] initTrollsArmy() {
        Random r = new Random();

        Personaje[] trolls = new Personaje[r.nextInt(MAX_TROLLS-MIN_TROLLS+1) + MIN_TROLLS];

        // Añadimos los personajes
        for(int i=0; i<trolls.length; i++) {
            trolls[i] = new Troll("Troll " + (i+1));
            trolls[i].setAtaque((r.nextInt(2)==0)?new AtaqueEspada():new AtaqueCuchillo());
        }

        return trolls;
    }    

    private static void gameLoop(Personaje[] hombres, Personaje[] trolls) {
        int aliveMen = hombres.length;
        int aliveTrolls = trolls.length;

        // Mostrar introducción
        showIntro(hombres, aliveTrolls);

        // Bucle principal
        while(aliveMen>0 && aliveTrolls>0) {
            // Turno humanos
            aliveTrolls -= clash(hombres, trolls, aliveTrolls);

            // Turno trolls
            if(aliveTrolls>0)
                aliveMen -= clash(trolls, hombres, aliveMen);
        }

        // Mostrar Resultado
        showResult(hombres, aliveMen, trolls, aliveTrolls);
    }

    private static void showIntro(Personaje[] hombres, int numTrolls) {
        System.out.print("Tal día como hoy, en una húmeda y fría mañana de finales");
        System.out.print(" de primavera, la partida formada por: ");
        System.out.print(Arrays.toString(hombres));
        System.out.print(" hallándose en los frondosos bosques del sitio de Deorham,");
        System.out.print(" se topó con una patrulla de " + numTrolls);
        System.out.print(" de esas sanguinarias e inhumanas criaturas popularmente");
        System.out.print(" conocidas como trolls.");
        
        System.out.println("\n\nDe la batalla que aconteció, dejo aquí testimonio:\n");
    }

    private static void showResult(Personaje[] hombres, int aliveMen, 
                                        Personaje[] trolls, int aliveTrolls) {
        if(aliveMen>0) {
            System.out.println("\nFinalmente, el ejército del Rey Arturo venció!!");
            showSurvivors(hombres);
        }
        else{
            System.out.println("\nFinalmente, el ejército de trolls venció!!");
            showSurvivors(trolls);
        }
    }

    private static void showSurvivors(Personaje[] army) {
        String sArmy = "";

        System.out.println("\nLos supervivientes de la batalla fueron:");
        System.out.print("{");
        
        for(int i=0; i<army.length; i++) {
            if(army[i].getSalud()>0) {
                sArmy += ((sArmy.length()>0)?", ":"");
                sArmy += army[i];
            } 
        }

        System.out.println(sArmy + "}");
    }

    private static int clash(Personaje[] atacantes, Personaje[] defensores, int numDefensores) {
        int bajas = 0;
        Personaje atacante, defensor;
        Random r = new Random();

        for(int i=0; i<atacantes.length; i++) {
            atacante = atacantes[i];
            if(atacante.getSalud()<0) continue; // Muerto! --> next

            do {
                defensor = defensores[r.nextInt(defensores.length)];
            } while(defensor.getSalud()<0); // Muerto! --> next

            // Lanza ataque
            System.out.println(atacante + " lucha contra " + defensor);
            atacante.ataca(defensor);

            // Check si muerto
            if(defensor.getSalud()<0) {
                System.out.println(defensor + " muere!");
                bajas++;
                if(numDefensores-bajas==0) 
                    break;
            }
        }

        return bajas;
    }
}