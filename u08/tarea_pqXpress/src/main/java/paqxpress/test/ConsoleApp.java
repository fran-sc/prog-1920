package paqxpress.test;

import paqxpress.core.*;

import java.util.HashMap;
import java.util.Scanner;

public class ConsoleApp {
    public static String menu() {
        System.out.println();
        System.out.println("\t#######################################");
        System.out.printf("\t# %35s #%n", "");
        System.out.println("\t#           p q X p r e s s           #");
        System.out.printf("\t# %35s #%n", "");
        System.out.println("\t#-------------------------------------#");
        System.out.printf("\t# %35s #%n", "");
        System.out.printf("\t# %-35s #%n", "[1] - Alta cliente");
        System.out.printf("\t# %-35s #%n", "[2] - Lista clientes");
        System.out.printf("\t# %-35s #%n", "[3] - Nuevo envío");
        System.out.printf("\t# %-35s #%n", "[4] - Consultar estado envío");
        System.out.printf("\t# %-35s #%n", "[5] - cambiar estado envío");
        System.out.printf("\t# %-35s #%n", "[6] - Listar envíos por cliente");
        System.out.printf("\t# %-35s #%n", "[7] - Listar envíos en reparto");
        System.out.printf("\t# %-35s #%n", "[X] - Salir");
        System.out.printf("\t# %35s #%n", "");
        System.out.println("\t#######################################");

        Scanner cin = new Scanner(System.in);
        String opc = "";
        boolean exit = false;
        
        while(!exit) {
            System.out.print("\nOpción > ");
            opc = cin.nextLine().trim().toUpperCase();
            switch(opc) {
                case "1": case "2": case "3": case "4":
                case "5": case "6": case "7": case "X":
                    exit = true;
                    break; 
                default:
                    System.out.println("Opción no válida");
            }
        }
        
        return opc;
    }
        
    private static void opcAltaCliente(PqxManager manager) {
        Scanner cin = new Scanner(System.in);
        String id = "", nombre = "";

        System.out.println("\nAlta de nuevo cliente >");

        while(id.length()==0) {
            System.out.print("NIF/CIF: ");
            id = cin.nextLine().trim();
        }
        while(nombre.length()==0) {
            System.out.print("Nombre/Razón Social: ");
            nombre = cin.nextLine().trim();
        }

        manager.altaCliente(id, nombre);

        System.out.println("\nCliente creado.");

    }

    private static void opcListaClientes(PqxManager manager) {
        System.out.println("\nLista de clientes >");
        
        for(Cliente c: manager.listaClientes())
            System.out.println(c);

        System.out.println();
    }    
    public static void main(String[] args) {
        PqxManager manager = new PqxManager();
        boolean exit = false;

        while(!exit) {
            switch(menu()) {
                case "1":   // Alta cliente
                    opcAltaCliente(manager);
                    break;

                case "2":   // Lista clientes
                    opcListaClientes(manager);
                    break;       

                case "X":
                    System.out.println("Bye!");
                    exit = true;
                    break;
            }
        }
    }
}
