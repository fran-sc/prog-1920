package control.console;

import control.core.*;
import java.util.Scanner;

public class MandoDemo {
    private static int getOpc(Scanner cin) {
        int opc;
        
        do {
            System.out.println();
            System.out.println("MANDO DEMO");
            System.out.println("1 - Mostrat slots");
            System.out.println("2 - Asignar dispositivo");
            System.out.println("3 - Eliminar dispositivo");
            System.out.println("4 - Encender dispositivo");
            System.out.println("5 - Apagar dispositivo");
            System.out.println("6 - Salir");
            System.out.print("Opción> ");
            
            while(!cin.hasNextInt());
            opc = cin.nextInt();
        } while(opc<1 || opc>6);
        
        return opc;
    }  
    
    private static void addDispositivo(Scanner cin, Mando mando) {
        // Se omiten comprobaciones de tipos y rangos
        System.out.print("\nRelé ID? ");
        int rele = cin.nextInt();
        cin.nextLine();

        System.out.print("Dispositivo? ");
        String nombre = cin.nextLine();

        System.out.print("Slot? ");
        int slot = cin.nextInt();

        mando.setComando(slot, new Dispositivo(rele, nombre));
    }

    private static void removeDispositivo(Scanner cin, Mando mando) {
        // Se omiten comprobaciones de tipos y rangos
        System.out.print("\nSlot? ");
        int slot = cin.nextInt();
        
        mando.removeDispositivo(slot);
    }    

    private static void activaDispositivo(Scanner cin, Mando mando, boolean estado) {
        // Se omiten comprobaciones de tipos y rangos
        System.out.print("\nSlot? ");
        int slot = cin.nextInt();

        if(estado) mando.presBotonOn(slot);
        else mando.presBotonOff(slot);
    }

    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);

        Mando mando = new Mando(5);

        int opc;
        while((opc = getOpc(cin)) != 6) {
            switch(opc) {
                case 1:
                    System.out.println(mando);
                    break;
                case 2:
                    addDispositivo(cin, mando);
                    break;
                case 3:
                    removeDispositivo(cin, mando);
                    break;
                case 4:
                    activaDispositivo(cin, mando, true);
                    break;
                case 5:
                    activaDispositivo(cin, mando, false);
                    break;                    
            }
        }
    }
}