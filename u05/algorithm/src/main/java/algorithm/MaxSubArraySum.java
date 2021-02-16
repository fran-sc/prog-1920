package algorithm;

/**
 * Cálculo del maximum subarray sum.
 *
 * Implementación de varios algoritmos para el cálculo de la suma máxima de
 * cualquiera de los subarrays del array procesado.
 **/
public class MaxSubArraySum {
    /**
     * Algoritmo 1.
     *
     * Complejidad temporal: O(n³)
     * Complejidad espacial: O(1) (in-place)
     **/
    public static long max1(int ar[]) {
        long best = 0, sum;
        for (int i = 0; i < ar.length; i++)
            for (int j = 0; j < ar.length; j++) {
                sum = 0;
                for (int k = i; k <= j; k++) sum += ar[k];
                best = Math.max(best, sum);
            }
        return best;
    }
    
    /**
     * Algoritmo 2.
     *
     * Complejidad temporal: O(n²)
     * Complejidad espacial: O(1) (in-place)
     **/
    public static long max2(int ar[]) {
        long best = 0, sum;
        for (int i = 0; i < ar.length; i++) {
            sum = 0;
            for (int j = i; j < ar.length; j++) {
                sum += ar[j];
                best = Math.max(best, sum);
            }
        }
        return best;
    }
    
    /**
     * Algoritmo 3 (Kadane's algorithm). 
     *
     * Complejidad temporal: O(n)
     * Complejidad espacial: O(1) (in-place)
     **/
    public static long max3(int ar[]) {
        long best = 0, sum = 0;
        for (int i = 0; i < ar.length; i++) {
            sum = Math.max(0, sum + ar[i]);
            best = Math.max(best, sum);
        }
        return best;
    }
}
