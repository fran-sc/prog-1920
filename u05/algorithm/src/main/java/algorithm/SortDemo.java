package algorithm;

import java.util.Random;
import java.util.Scanner;

/**
 * Sort Demo.
 *
 * @version 0.1
 * */
public class SortDemo {
    /* Opciones del menú principal. */
    private static final int OPC_NUEVO = 1;
    private static final int OPC_VER = 2;
    private static final int OPC_SHUFFLE = 3;
    private static final int OPC_ALG_BUBBLE = 4;
    private static final int OPC_ALG_SELECT = 5;
    private static final int OPC_ALG_INSERT = 6;
    private static final int OPC_ALG_MERGE = 7;
    private static final int OPC_SALIR = 8;

    /** Muestra el menú de opciones. */
    public static void showMenu() {
        System.out.println();
        System.out.println("********************************");
        System.out.println("*         SORTING DEMO         *");
        System.out.println("********************************");
        System.out.println(" 1 - Nuevo array");
        System.out.println(" 2 - Ver array");
        System.out.println(" 3 - Desordena array");
        System.out.println(" 4 - Bubble sort");
        System.out.println(" 5 - Selection sort");
        System.out.println(" 6 - Insertion sort");
        System.out.println(" 7 - Merge sort");
        System.out.println(" 8 - Salir");
        System.out.println();
    }

    /* Método principal */
    public static void main(String[] args) {
        int sys = ConsoleUtil.getSystem();

        int[] array = null;

        Scanner cin = new Scanner(System.in);

        boolean exit = false;
        while (!exit) {
            // Mostramos el menú de opciones:
            ConsoleUtil.cls(sys);
            showMenu();

            // Solicitamos la opción
            System.out.print("opc > ");
            String s = cin.nextLine().trim();
            if (s.length() == 0)
                s = "-1";
            int opc = Integer.parseInt(s);
            ConsoleUtil.cls(sys);

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

                    case OPC_SHUFFLE:
                        opcShuffleArray(array);
                        break;

                    case OPC_ALG_BUBBLE:
                    case OPC_ALG_SELECT:
                    case OPC_ALG_INSERT:
                    case OPC_ALG_MERGE:
                        opcSortArray(opc, array);
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
            System.out.print("Valores: ");
            for (int i = 0; i < n; i++) ar[i] = cin.nextInt();
            cin.nextLine();
        } else {
            System.out.print("Mínimo: ");
            int min = Integer.parseInt(cin.nextLine());

            System.out.print("Máximo: ");
            int max = Integer.parseInt(cin.nextLine());

            ar = ArrayUtil.createRandomArray(n, min, max);
        }
        return ar;
    }

    /* Muestra el contenido del array hasta un máximo de 20 valores */
    private static void opcVerArray(int[] ar) {
        System.out.println("\n--> VER ARRAY:\n");

        int n = Math.min(20, ar.length);

        System.out.println("[len: " + ar.length + "] " + ArrayUtil.toString(ar, 20));
    }

    /* Desordena el contenido del array */
    private static void opcShuffleArray(int[] ar) {
        System.out.println("\n--> DESORDENA ARRAY:\n");

        int n = Math.min(20, ar.length);

        System.out.println("in:  [len: " + ar.length + "] " + ArrayUtil.toString(ar, 20));
        ArrayUtil.shuffle(ar);
        System.out.println("out: [len: " + ar.length + "] " + ArrayUtil.toString(ar, 20));
    }

    /* Ejecuta la implementación del algoritmo */
    private static void opcSortArray(int opc, int[] ar) {
        System.out.print("\n--> ALGORITMO: ");

        // init time lapse
        long ini_t = System.currentTimeMillis();

        switch (opc) {
            case OPC_ALG_BUBBLE:
                System.out.println("Bubble sort\n");
                Sort.bubbleSort(ar);
                break;

            case OPC_ALG_SELECT:
                System.out.println("Selection sort\n");
                Sort.selectSort(ar);
                break;

            case OPC_ALG_INSERT:
                System.out.println("Insertion sort\n");
                Sort.insertSort(ar);
                break;

            case OPC_ALG_MERGE:
                System.out.println("Merge sort\n");
                Sort.mergeSort(ar, 0, ar.length-1);
                break;
        }

        // compute time lapse
        double sec = (System.currentTimeMillis() - ini_t) / 1000.0;
        System.out.printf("(time: %.3fs)\n", sec);

        // show array
        System.out.println("\nout: [len: " + ar.length + "] " + ArrayUtil.toString(ar, 20));
    }
}
