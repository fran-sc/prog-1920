package paqxpress.test;

import paqxpress.core.*;
import java.util.Scanner;

enum OPCIONES { 
    ALTA_CLI("1"),
    LISTA_CLI("2"),
    NUEVO_PQ("3"),
    CONS_EST("4"),
    CAMB_EST("5"),
    LISTA_PQ_CLI("6"),
    LISTA_REP("7"),
    SALIR("X");

    String opc;
    OPCIONES(String c) { this.opc = c; }
    String getVal() { return this.opc; }
}

public class ConsoleApp {
    public static OPCIONES menu() {
        System.out.println();
        System.out.println("#######################################");
        System.out.printf("# %35s #%n", "");
        System.out.println("#           p q X p r e s s           #");
        System.out.printf("# %35s #%n", "");
        System.out.println("#-------------------------------------#");
        System.out.printf("# %35s #%n", "");
        System.out.printf("# %-35s #%n", "[1] - Alta cliente");
        System.out.printf("# %-35s #%n", "[2] - Lista clientes");
        System.out.printf("# %-35s #%n", "[3] - Nuevo envío");
        System.out.printf("# %-35s #%n", "[4] - Consultar estado envío");
        System.out.printf("# %-35s #%n", "[5] - cambiar estado envío");
        System.out.printf("# %-35s #%n", "[6] - Listar envíos por cliente");
        System.out.printf("# %-35s #%n", "[7] - Listar envíos en reparto");
        System.out.printf("# %-35s #%n", "[X] - Salir");
        System.out.printf("# %35s #%n", "");
        System.out.println("#######################################");

        Scanner cin = new Scanner(System.in);
        OPCIONES opc;

        while(true) {
            System.out.print("\nOpción > ");
            try {
                opc = OPCIONES.valueOf(cin.nextLine().trim().toUpperCase());
                break; 
            catch(Exception e) { System.out.println("\nOpción no válida"); }
        }
        
        return opc;
    }
        
    public static void main(String[] args) {
        PqxManager manager = new PqxManager();

        while(true) {
            switch(menu()) {
                case OPCIONES.SALIR:
                    System.out.println("Bye!");
                    break;
            }
        }
    }
}
