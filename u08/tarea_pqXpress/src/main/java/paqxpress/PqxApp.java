package paqxpress;

import java.util.Scanner;

public class PqxApp {
    public static void main(String[] args) {
        PqxManager manager = new PqxManager();

        boolean exit = false;
        while(!exit) {
            switch(menu()) {
                
            }
        }
    }

    public static char menu() {
        String opc;
        char c;

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
        System.out.printf("# %-35s #%n", "[5] - Listar envíos en reparto");
        System.out.printf("# %-35s #%n", "[X] - Salir");
        System.out.printf("# %35s #%n", "");
        System.out.println("#######################################");

        Scanner cin = new Scanner(System.in);

        loop:
        do {
            System.out.print("\nOpción > ");
            opc = cin.nextLine().trim().toUpperCase();

            if(opc.length()>0) {
                c = opc.charAt(0);
                switch (c) {
                    case '1': case '2': case '3': case '4': case '5': case 'X':
                        break loop;
                }
            } 
            System.out.println("\nOpción no válida");
        } while(true);

        return opc;
    }
}