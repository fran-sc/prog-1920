package algorithm;

import java.util.Random;
import java.util.Scanner;

public class FibonacciDemo {
    /* Opciones del menú principal. */
    private static final int OPC_ALGO_1 = 1;
    private static final int OPC_ALGO_2 = 2;
    private static final int OPC_SALIR = 3;

    private static final int SYS_NIX = 1;
    private static final int SYS_WIN = 2;

    /* Identificador del sistema. */
    private static int _sys;

    /** Muestra el menú de opciones. */
    public static void showMenu() {
        System.out.println();
        System.out.println("********************************");
        System.out.println("*           FIBONACCI          *");
        System.out.println("********************************");
        System.out.println(" 1 - Algoritmo 1");
        System.out.println(" 2 - Algoritmo 2");
        System.out.println(" 3 - Salir");
        System.out.println();
    }

    /* Limpia el terminal. */
    private static void cls() {
        switch (FibonacciDemo._sys) {
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

    /* Identifica la plataforma. */
    private static void getSystem() {
        FibonacciDemo._sys = SYS_NIX; // valor por defecto (linux, Mac)

        String os = System.getProperty("os.name").toUpperCase();
        if (os.contains("WIN"))
            FibonacciDemo._sys = SYS_WIN;
    }

    /* Método principal */
    public static void main(String[] args) {
        getSystem();

        int[] array = null;

        Scanner cin = new Scanner(System.in);

        boolean exit = false;
        while (!exit) {
            // Mostramos el menú de opciones:
            cls();
            showMenu();

            // Solicitamos la opción
            System.out.print("opc > ");
            String s = cin.nextLine().trim();
            if (s.length() == 0)
                s = "-1";
            int opc = Integer.parseInt(s);
            cls();

            // Chequea array creado
            switch (opc) {
                case OPC_ALGO_1:
                    opcAlgoritmo1(cin);
                    break;

                case OPC_ALGO_2:
                    opcAlgoritmo2(cin);
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

    /* Ejecuta el la implementación del algoritmo 1 */
    private static void opcAlgoritmo1(Scanner cin) {
        System.out.println("\n--> ALGORITMO 1 (recursivo):\n");

        System.out.print("Término de la serie: ");
        int n = Integer.parseInt(cin.nextLine());

        long ini_t = System.currentTimeMillis();

        System.out.println("valor --> " + Fibonacci.fibonacci_1(n));

        double sec = (System.currentTimeMillis() - ini_t) / 1000.0;
        System.out.printf("(time: %.3fs)\n", sec);
    }

    /* Ejecuta el la implementación del algoritmo 1 */
    private static void opcAlgoritmo2(Scanner cin) {
        System.out.println("\n--> ALGORITMO 2 (iterativo):\n");

        System.out.print("Término de la serie: ");
        int n = Integer.parseInt(cin.nextLine());

        long ini_t = System.currentTimeMillis();

        System.out.println("valor --> " + Fibonacci.fibonacci_2(n));

        double sec = (System.currentTimeMillis() - ini_t) / 1000.0;
        System.out.printf("(time: %.3fs)\n", sec);
    }
}
