package algorithm;

import java.util.Random;
import java.util.Scanner;

/** 
 * MaxSubArraySum Demo.
 *
 * @version 0.2
 * @apiNote En 0.2 se cambia el código de craación de arrays aleatorios e
 *          impresión por llamadas a los métodos createRandomArray y toString
 *          de {@link algorithm.ArrayUtil}
 * */
public class MaxSubArraySumDemo {
    /* Opciones del menú principal. */
    private static final int OPC_NUEVO = 1;
    private static final int OPC_VER = 2;
    private static final int OPC_ALGO_1 = 3;
    private static final int OPC_ALGO_2 = 4;
    private static final int OPC_ALGO_3 = 5;
    private static final int OPC_SALIR = 6;

    private static final int SYS_NIX = 1;
    private static final int SYS_WIN = 2;

    /* Identificador del sistema. */
    private static int _sys;

    /** Muestra el menú de opciones. */
    public static void showMenu() {
        System.out.println();
        System.out.println("********************************");
        System.out.println("*     MAXIMUM SUBARRAY SUM     *");
        System.out.println("********************************");
        System.out.println(" 1 - Nuevo array");
        System.out.println(" 2 - Ver array");
        System.out.println(" 3 - Algoritmo 1");
        System.out.println(" 4 - Algoritmo 2");
        System.out.println(" 5 - Algoritmo 3");
        System.out.println(" 6 - Salir");
        System.out.println();
    }

    /* Limpia el terminal. */
    private static void cls() {
        switch (MaxSubArraySumDemo._sys) {
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
        MaxSubArraySumDemo._sys = SYS_NIX; // valor por defecto (linux, Mac)

        String os = System.getProperty("os.name").toUpperCase();
        if (os.contains("WIN"))
            MaxSubArraySumDemo._sys = SYS_WIN;
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
            if(s.length() == 0) s = "-1";
            int opc = Integer.parseInt(s);
            cls();

            // Chequea array creado
            if (array == null && opc > OPC_NUEVO && opc < OPC_SALIR)
                System.out.println("\n--> ERR: Aún no se ha dado de creado el array");

            else {
                switch (opc) {
                    case OPC_NUEVO:
                        array = opcNuevoArray(cin);
                        if (array != null)
                            System.out.println("\n--> Array creado satisfactoriamente.");
                        break;

                    case OPC_VER:
                        opcVerArray(array);
                        break;

                    case OPC_ALGO_1:
                        opcAlgoritmo1(array);
                        break;

                    case OPC_ALGO_2:
                        opcAlgoritmo2(array);
                        break;

                    case OPC_ALGO_3:
                        opcAlgoritmo3(array);
                        break;

                    case OPC_SALIR:
                        exit = true;
                        break;

                    default:
                        System.out.println("\n--> ERR: Opción no válida");
                }
            }

            if (!exit) {
                System.out.println("\n[RET] para continuar...");
                cin.nextLine();
            }
        }
    }

    /* Crea un nuevo array de enteros de forma aleatoria o manual */
    private static int[] opcNuevoArray(Scanner cin) {
        System.out.println("\n--> NUEVO ARRAY:\n");

        System.out.print("Número de elementos: ");
        int n = Integer.parseInt(cin.nextLine());

        System.out.print("[A]leatorio/[M]anual: ");
        char opc = cin.nextLine().trim().toUpperCase().charAt(0);

        int[] ar = new int[n];

        if (opc == 'M') {
            for (int i = 0; i < n; i++) ar[i] = cin.nextInt();
            cin.nextLine();
        } else {
            System.out.print("Mínimo: ");
            int min = Integer.parseInt(cin.nextLine());

            System.out.print("Máximo: ");
            int max = Integer.parseInt(cin.nextLine());

            ar = ArrayUtil.createRandomArray(n, min, max);
            /* v0.2 
            Random r = new Random();

            for (int i = 0; i < n; i++) ar[i] = r.nextInt(max - min + 1) + min;
            */
        }
        return ar;
    }

    /* Muestra el contenido del array hasta un máximo de 20 valores */
    private static void opcVerArray(int[] ar) {
        System.out.println("\n--> VER ARRAY:\n");

        int n = Math.min(20, ar.length);

        System.out.println("[len: " + ar.length + "] " + ArrayUtil.toString(ar, 20));
        /* v0.2
        System.out.print("[len: " + ar.length + "] [");
        for (int i = 0; i < n; i++) System.out.print(ar[i] + ", ");
        System.out.println((ar.length > n) ? "...]" : "\b\b]");
        */
    }

    /* Ejecuta el la implementación del algoritmo 1 */
    private static void opcAlgoritmo1(int[] ar) {
        System.out.println("\n--> ALGORITMO 1:\n");

        long ini_t = System.currentTimeMillis();

        System.out.println("max: " + MaxSubArraySum.max1(ar));

        double sec = (System.currentTimeMillis() - ini_t) / 1000.0;
        System.out.printf("(time: %.3fs)\n", sec);
    }

    /* Ejecuta el la implementación del algoritmo 2 */
    private static void opcAlgoritmo2(int[] ar) {
        System.out.println("\n--> ALGORITMO 2:\n");

        long ini_t = System.currentTimeMillis();

        System.out.println("max: " + MaxSubArraySum.max2(ar));

        double sec = (System.currentTimeMillis() - ini_t) / 1000.0;
        System.out.printf("(time: %.3fs)\n", sec);
    }

    /* Ejecuta el la implementación del algoritmo 3 */
    private static void opcAlgoritmo3(int[] ar) {
        System.out.println("\n--> ALGORITMO 3:\n");

        long ini_t = System.currentTimeMillis();

        System.out.println("max: " + MaxSubArraySum.max3(ar));

        double sec = (System.currentTimeMillis() - ini_t) / 1000.0;
        System.out.printf("(time: %.3fs)\n", sec);
    }
}
