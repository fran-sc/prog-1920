package algorithm;

import java.util.Random;

/**
 * Métodos de utilidad con arrays de enteros.
 *
 * - int[]  createRandomArray(int n, int min, int max)
 * - int[]  createRandomArray(int n, int min, int max, long seed)
 * - void   shuffle(int[] ar)
 * - void   swap(int[] ar, int i, int j)
 * - String toString(int[] ar, int n)
 * */

public class ArrayUtil {
    /** Crea un nuevo array de n elementos con datos aleatorios en el rango [min, max]. */
    public static int[] createRandomArray(int n, int min, int max) {
        return _createRandomArray(n, min, max, new Random());
    }

    /**
     * Crea un nuevo array de n elementos con datos aleatorios en el rango [min, max] y semilla
     * seed.
     */
    public static int[] createRandomArray(int n, int min, int max, long seed) {
        return _createRandomArray(n, min, max, new Random(seed));
    }

    /** Desordena el array. */
    public static void shuffle(int[] ar) {
        Random r = new Random();

        int n = ar.length - 1;
        while (n > 0) {
            int p = r.nextInt(n);
            swap(ar, n, p);
            --n;
        }
    }

    /** Intercambia dos posiciones del array. */
    public static void swap(int[] ar, int i, int j) {
        int temp = ar[i];
        ar[i] = ar[j];
        ar[j] = temp;
    }

    /**
     * Devuelve un String con el contenido del array hasta el número de
     * elementos indicado.
     */
    public static String toString(int[] ar, int n) {
        int p = Math.min(n, ar.length);
        if (p == 0)
            return "[]";

        String s = "[";
        for (int i = 0; i < p; i++) s += ar[i] + ", ";
        s += ((ar.length > p) ? "...]" : "\b\b]");

        return s;
    }

    private static int[] _createRandomArray(int n, int min, int max, Random r) {
        int[] ar = new int[n];

        for (int i = 0; i < n; i++) ar[i] = r.nextInt(max - min + 1) + min;

        return ar;
    }
}
