package paqxpress.test;

import paqxpress.core.*;
import java.io.IOException;

import java.util.Scanner;

public class ConsoleApp {
    private static final boolean CL_ON = (System.getProperty("os.name").equals("Linux"))?true:false;
    private static final String CL_STR = "\033[H\033[2J";

    /*********************************************************************************************
     * Bucle principal.
     *********************************************************************************************/
        public static void main(String[] args) {
        PqxManager manager = new PqxManager();
        boolean exit = false;

        while(!exit) {
            switch(getOpcMenu()) {
                case "1":   // Alta cliente
                    opcAltaCliente(manager);
                    break;

                case "2":   // Lista clientes
                    opcListaClientes(manager);
                    break;       

                case "3":   // Nuevo envío
                    opcNuevoEnvio(manager);
                    break;                           

                case "4":   // Consultar estado envío
                    opcConsultarEstadoEnvio(manager);
                    break;   

                case "5":   // Cambiar estado envío
                    opcCambiarEstadoEnvio(manager);
                    break;

                case "6":   // Listar envíos por cliente
                    opcListarEnviosPorCliente(manager);
                    break;
                
                case "7":   // Listar envíos en reparto
                    opcListarEnviosEnReparto(manager);
                    break;

                case "X":
                    exit = opcExit();
                    break;
            }
        }
    }

    /*********************************************************************************************
     * Menú de opciones.
     *********************************************************************************************/
    public static String getOpcMenu() {
        Scanner cin = new Scanner(System.in);
        String opc = "";
        boolean exit = false;
        
        while(!exit) {
            clearScreen();
            
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
            System.out.printf("\t# %-35s #%n", "[5] - Cambiar estado envío");
            System.out.printf("\t# %-35s #%n", "[6] - Listar envíos por cliente");
            System.out.printf("\t# %-35s #%n", "[7] - Listar envíos en reparto");
            System.out.printf("\t# %-35s #%n", "[X] - Salir");
            System.out.printf("\t# %35s #%n", "");
            System.out.println("\t#######################################");

            System.out.print("\nOpción > ");
            opc = cin.nextLine().trim().toUpperCase();
            switch(opc) {
                case "1": case "2": case "3": case "4":
                case "5": case "6": case "7": case "X":
                    exit = true;
                    break; 
            }
        }
        
        return opc;
    }

    /*********************************************************************************************
     * Alta de clientes.
     *********************************************************************************************/ 
    private static void opcAltaCliente(PqxManager manager) {
        Scanner cin = new Scanner(System.in);
        String id = "", nombre = "";

        clearScreen();
        System.out.println("\nAlta de nuevo cliente >\n");

        System.out.print("NIF/CIF: ");
        id = cin.nextLine().trim().toUpperCase();
        
        System.out.print("Nombre/Razón Social: ");
        nombre = cin.nextLine().trim();

        if(id.length()==0 || nombre.length()==0) {
            System.out.println("\nDatos no válidos");
            waitReturn();
        }
        else {
            System.out.println("\n[C]onfirmar | []-Cancelar");

            if(cin.nextLine().trim().toUpperCase().equals("C")) {
                clearScreen();
                System.out.println(manager.altaCliente(id, nombre)?
                                    "\nCliente creado":
                                    "\nEl cliente ya existe en el sistema");                
                waitReturn();                                    
            }
        }
    }
    
    /*********************************************************************************************
     * Lista de clientes.
     *********************************************************************************************/
    private static void opcListaClientes(PqxManager manager) {
        clearScreen();
        System.out.println("\nLista de clientes >\n");

        System.out.printf("%-15s %s%n", "NIF/CIF", "NOMBRE");
        System.out.println("--------------------------------------------------");
        
        for(Cliente c: manager.listaClientes())
            System.out.printf("%-15s %s%n", c.getId(), c.getNombre());


        waitReturn();
    }    

    /*********************************************************************************************
     * Alta de nuevo envío
     *********************************************************************************************/
    private static void opcNuevoEnvio(PqxManager manager) {
        Scanner cin = new Scanner(System.in);
        String id = "", destino = "";

        while(true) {
            clearScreen();
            System.out.println("\nAlta de nuevo envío >\n");

            System.out.print("NIF/CIF ([L]ista clientes): ");
            id = cin.nextLine().trim().toUpperCase();

            if(id.equals("L")) opcListaClientes(manager);
            else break;
        }
        
        System.out.print("Destino: ");
        destino = cin.nextLine().trim();

        if(id.length()==0 || destino.length()==0) {
            System.out.println("\nDatos no válidos");
            waitReturn();
        }
        else {
            Cliente c = manager.getCliente(id);
            if(c==null) {
                System.out.println("\nEl cliente no está dado de alta en el sistema");
                waitReturn();
            }
            else {
                System.out.println("\n[C]onfirmar | []-Cancelar");

                if(cin.nextLine().trim().toUpperCase().equals("C")) {
                    int pqId = manager.altaEnvio(c, destino);

                    clearScreen();

                    System.out.println("\nCreado nuevo envío con ID: " + pqId);

                    waitReturn();
                }
            }
        }
    }

    /*********************************************************************************************
     * Consultar estado envío
     *********************************************************************************************/
    private static void opcConsultarEstadoEnvio(PqxManager manager) {    
        Scanner cin = new Scanner(System.in);

        clearScreen();
        
        System.out.println("\nConsultar estado del envío >\n");

        System.out.print("Id del envío: ");
        int id = cin.nextInt();

        clearScreen();

        Paquete pq = manager.getPaquete(id);
        if(pq==null)
            System.out.println("\nNo se encuentra el ID [" + id + "] en el sistema") ;
        else {
            System.out.println("\nDatos del envío >\n");
            System.out.printf("%-10s %d%n", "ID:", pq.getId());
            System.out.printf("%-10s %d-%02d-%02d %02d:%02d%n", 
                "FECHA:", 
                pq.getTimestamp().getYear(),
                pq.getTimestamp().getMonthValue(),
                pq.getTimestamp().getDayOfMonth(),
                pq.getTimestamp().getHour(),
                pq.getTimestamp().getMinute() );
            System.out.printf("%-10s %s%n", "CLIENTE:", pq.getCliente().getNombre());
            System.out.printf("%-10s %s%n", "DESTINO:", pq.getDestino());
            System.out.printf("%-10s %s%n", "SITUACION:", pq.informaEstado());
        }

        waitReturn();
    }

    /*********************************************************************************************
     * Cambiar estado envío
     *********************************************************************************************/
    private static void opcCambiarEstadoEnvio(PqxManager manager) {    
        Scanner cin = new Scanner(System.in);

        clearScreen();
        
        System.out.println("\nCambio de estado del envío >\n");

        System.out.print("Id del envío: ");
        int id = cin.nextInt();
        cin.nextLine();

        clearScreen();

        Paquete pq = manager.getPaquete(id);
        if(pq==null) {
            System.out.println("\nNo se encuentra el ID [" + id + "] en el sistema") ;
            waitReturn();
        }
        else {
            System.out.println("\nEl paquete [" + id + "] se encuentra en situación:");
            System.out.println("\n--> " + pq.informaEstado());
            System.out.println("\n¿Desea promover su estado?");
            System.out.println("\n[C]onfirmar | []-Cancelar");
            if(cin.nextLine().trim().toUpperCase().equals("C")) {
                clearScreen();

                if(manager.cambiarEstadoEnvio(id)) {
                    System.out.println("\nSe ha modificado el estado del envío [" + id + "] a:");
                    System.out.println("\n--> " + pq.informaEstado());
                }
                else
                    System.out.println("\nNo se ha podido modificar el estado del envío");

                waitReturn();
            }
        }
    }

    /*********************************************************************************************
     * Listar envíos por cliente
     *********************************************************************************************/
    private static void opcListarEnviosPorCliente(PqxManager manager) {
        Scanner cin = new Scanner(System.in);
        String id = "";

        while(true) {
            clearScreen();
            System.out.println("\nLista de envíos por cliente >\n");

            System.out.print("NIF/CIF ([L]ista clientes): ");
            id = cin.nextLine().trim().toUpperCase();

            if(id.equals("L")) opcListaClientes(manager);
            else break;
        }
        
        clearScreen();

        if(id.length()==0)
            System.out.println("\nNIF/CIF cliente no válido");
        else {
            Cliente c = manager.getCliente(id);
            if(c==null) 
                System.out.println("\nEl cliente no está dado de alta en el sistema");
            else {
                String line = "";
                for(int i=0; i<84; i++) line += "-";

                System.out.println("\nNIF/CIF: " + c.getId());
                System.out.println("Nombre: " + c.getNombre());
                System.out.println();

                Paquete[] pqList = manager.listaPaquetesPorCliente(id);
                listaPaquetes(pqList);
            }
        }

        waitReturn();
    }

    /*********************************************************************************************
     * Listar envíos en reparto
     *********************************************************************************************/
    private static void opcListarEnviosEnReparto(PqxManager manager) {
        clearScreen();

        System.out.println("\nLista de envíos en reparto >");

        Paquete[] pqList = manager.listaPaquetesEnReparto();
        listaPaquetes(pqList);

        waitReturn();
    }    

    /*********************************************************************************************
     * Salir.
     *********************************************************************************************/
    private static boolean opcExit() {
        clearScreen();

        // solicitar confirmación del usuario

        return true;
    }

    /*********************************************************************************************
     * Funciones de utilidad
     *********************************************************************************************/ 
    private static void clearScreen() {
        if(CL_ON) System.out.print(CL_STR);
    }

    private static void waitReturn() {
        System.out.print("\nPulse [RET] para continuar ");

        try{
            System.in.read();
        }
        catch (IOException ex) {}
    }    

    private static void listaPaquetes(Paquete[] pqList) {
        String line = "";
        for(int i=0; i<80; i++) line += "-";

        System.out.printf("\n%-10s %-5s %-6s %-25s %-30s%n", 
                            "FECHA", "HORA", "ID-PAQ", "DESTINO", "SITUACION");
        System.out.println(line);

        if(pqList.length == 0) 
            System.out.println("\nNo se encuentran envíos\n");
        else
            for(Paquete pq: pqList)
                System.out.printf("%d-%02d-%02d %02d:%02d %-6d %-25s %-30s %n", 
                                    pq.getTimestamp().getYear(),
                                    pq.getTimestamp().getMonthValue(),
                                    pq.getTimestamp().getDayOfMonth(),
                                    pq.getTimestamp().getHour(),
                                    pq.getTimestamp().getMinute(),
                                    pq.getId(),
                                    pq.getDestino().substring(0,
                                            Math.min(pq.getDestino().length(), 25)),
                                    pq.informaEstado().substring(0,
                                            Math.min(pq.informaEstado().length(),30 ))
                                );
        
        System.out.println(line);                                
    }
}
