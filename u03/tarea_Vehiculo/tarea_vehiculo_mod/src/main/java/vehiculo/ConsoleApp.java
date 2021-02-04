package vehiculo;

import java.time.LocalDate;
import java.util.Scanner;
import vehiculo.util.Util;

/**
 * Aplicación para la gestión de vehículos.
 *
 * @author
 * @version 1.0
 */
public class ConsoleApp {
    /** Opciones del menú principal. */
    private static final int OPC_NUEVO = 1;
    private static final int OPC_VER_MAT = 2;
    private static final int OPC_VER_KM = 3;
    private static final int OPC_ACT_KM = 4;
    private static final int OPC_VER_ANIO = 5;
    private static final int OPC_VER_PROP = 6;
    private static final int OPC_VER_DESC = 7;
    private static final int OPC_VER_PREC = 8;
    private static final int OPC_SALIR = 9;

    private static final int SYS_NIX = 1;
    private static final int SYS_WIN = 2;

    /* Identificador del sistema. */
    private static int _sys;

    /**
     * Solicita los datos para la creación de una nueva instancia de vehiculo.
     *
     * @param cin objeto Scanner para la entrada de datos
     * @return nuevo objeto Vehiculo
     */
    private static Vehiculo opcNuevo(Scanner cin) {
        System.out.println("\n--> NUEVO VEHICULO");
        System.out.println("\nIntroduzca los siguientes datos del vehículo\n");

        // Marca
        System.out.print("Marca: ");
        String marca = cin.nextLine().trim();

        // Matrícula
        System.out.print("Matrícula: ");
        String matricula = cin.nextLine().trim();

        // Número de KMs
        System.out.print("Nº de kms: ");
        int numKM = Integer.parseInt(cin.nextLine().trim());
        if (!Util.validaKM(numKM)) {
            System.out.println("\n--> ERR: Kilometraje incorrecto");
            return null;
        }

        // Fecha de matriculación
        System.out.print("Fecha de matriculación [aaaa-mm-dd]: ");
        LocalDate fechMatricula = LocalDate.parse(cin.nextLine().trim());
        if (!Util.validaFechaMat(fechMatricula)) {
            System.out.println("\n--> ERR: Fecha de matriculación incorrecta");
            return null;
        }

        // Descripción
        System.out.print("Descripción: ");
        String descripcion = cin.nextLine().trim();

        // Precio
        System.out.print("Precio: ");
        Double precio = Double.parseDouble(cin.nextLine().trim());

        // Nombre propietario
        System.out.print("Nombre propietario: ");
        String nomPropietario = cin.nextLine().trim();

        // DNI propietario
        System.out.print("DNI propietario: ");
        String dniPropietario = cin.nextLine().trim();
        try {
            Util.validaDNI(dniPropietario);
        } catch (Exception e) {
            System.out.println("\n--> ERR: " + e.getMessage());
            return null;
        }

        return new Vehiculo(marca, matricula, numKM, fechMatricula, descripcion, precio,
            nomPropietario, dniPropietario);
    }

    /**
     * Actualiza la información de kilometraje del vehículo.
     *
     * @param v objeto Vehiculo a actualizar
     * @param cin objeto Scanner para la entrada de datos
     */
    private static void opcActualizaKM(Vehiculo v, Scanner cin) {
        System.out.println("\n--> ACTUALIZA KILOMETRAJE");
        System.out.print("\nNuevo kilometraje del vehículo: ");

        int km = Integer.parseInt(cin.nextLine());
        if (km <= v.getNumKM())
            System.out.println(
                "\n--> ERR: El kilometraje indicado es inferior al actual del vehículo.");
        else
            v.setNumKM(km);
    }

    /** Muestra el menú de opciones. */
    public static void showMenu() {
        System.out.println();
        System.out.println("********************************");
        System.out.println("*     GESTION DE VEHICULOS     *");
        System.out.println("********************************");
        System.out.println(" 1 - Nuevo Vehiculo");
        System.out.println(" 2 - Ver Matrícula");
        System.out.println(" 3 - Ver Número de Kilómetros");
        System.out.println(" 4 - Actualizar Kilómetros");
        System.out.println(" 5 - Ver Años de Antigüedad");
        System.out.println(" 6 - Mostrar Propietario");
        System.out.println(" 7 - Mostrar Descripción");
        System.out.println(" 8 - Mostrar Precio");
        System.out.println(" 9 - Salir");
        System.out.println();
    }

    /** Limpia el terminal. */
    private static void cls() {
        switch (ConsoleApp._sys) {
            case SYS_NIX:
                System.out.print("\033[H\033[2J");
                break;
            case SYS_WIN:
                try {
                    // chapucilla windows
                    new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
        }
    }

    /** Identifica la plataforma. */
    private static void getSystem() {
        ConsoleApp._sys = SYS_NIX; // valor por defecto (linux, Mac)

        String os = System.getProperty("os.name").toUpperCase();
        if (os.contains("WIN"))
            ConsoleApp._sys = SYS_WIN;
    }

    /** Método principal */
    public static void main(String[] args) {
        getSystem();

        Vehiculo veh = null; // Objeto Vehiculo principal

        Scanner cin = new Scanner(System.in);

        boolean exit = false;
        while (!exit) {
            // Mostramos el menú de opciones:
            cls();
            showMenu();

            // Solicitamos la opción
            System.out.print("opc > ");
            int opc = Integer.parseInt(cin.nextLine().trim());
            cls();

            switch (opc) {
                case OPC_NUEVO:
                    veh = opcNuevo(cin);
                    if (veh != null)
                        System.out.println("\n--> Vehículo creado satisfactoriamente.");
                    break;

                case OPC_VER_MAT:
                    if (veh != null)
                        System.out.println("\n--> MATRICULA: " + veh.getMatricula());
                    else
                        System.out.println("\n--> ERR: Aún no se ha dado de alta el vehículo");
                    break;

                case OPC_VER_KM:
                    if (veh != null)
                        System.out.println("\n--> KILOMETRAJE: " + veh.getNumKM());
                    else
                        System.out.println("\n--> ERR: Aún no se ha dado de alta el vehículo");
                    break;

                case OPC_ACT_KM:
                    if (veh != null)
                        opcActualizaKM(veh, cin);
                    else
                        System.out.println("\n--> ERR: Aún no se ha dado de alta el vehículo");
                    break;

                case OPC_VER_ANIO:
                    if (veh != null)
                        System.out.println("\n--> AÑOS: " + veh.getAnios(veh));
                    else
                        System.out.println("\n--> ERR: Aún no se ha dado de alta el vehículo");
                    break;

                case OPC_VER_PROP:
                    if (veh != null)
                        System.out.println("\n--> PROPIETARIO: [" + veh.getDNIPropietario() + "] "
                            + veh.getNomPropietario());
                    else
                        System.out.println("\n--> ERR: Aún no se ha dado de alta el vehículo");
                    break;

                case OPC_VER_DESC:
                    if (veh != null)
                        System.out.println("\n--> DESCRIPCION: " + veh.getDescripcion());
                    else
                        System.out.println("\n--> ERR: Aún no se ha dado de alta el vehículo");
                    break;

                case OPC_VER_PREC:
                    if (veh != null)
                        System.out.printf("\n--> PRECIO: %.2f€%n", veh.getPrecio());
                    else
                        System.out.println("\n--> ERR: Aún no se ha dado de alta el vehículo");
                    break;

                case OPC_SALIR:
                    exit = true;
                    break;

                default:
                    System.out.println("\n--> ERR: Opción no válida");
            }

            if (!exit) {
                System.out.println("\n[RET] para continuar...");
                cin.nextLine();
            }
        }
    }
}
