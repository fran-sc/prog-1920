package algorithm;

/**
 * Algoritmos de ordenación.
 *
 * - void bubbleSort(int ar[])
 * - void selectSort(int ar[])
 * - void insertSort(int ar[])
 *
 * @version 0.1
 * */

public class Sort {
    /** Bubble sort. */
    public static void bubbleSort(int ar[]) {
        if (ar.length < 2)
            return;

        int n = ar.length - 1;
        boolean swap = true;
        while (swap) {
            swap = false;
            for (int i = 0; i < n; i++) {
                if (ar[i] > ar[i + 1])
                    ArrayUtil.swap(ar, i, i + 1);
                swap = true;
            }
            --n;
        }
    }

    /** Selection sort. */
    public static void selectSort(int ar[]) {
        if (ar.length < 2)
            return;

        int n = ar.length - 1;
        while (n-- > 0) {
            int maxi = 0;
            for (int i = 1; i <= n; i++)
                if (ar[i] > ar[maxi])
                    maxi = i;
            if (maxi != n)
                ArrayUtil.swap(ar, maxi, n);
        }
    }

    /** Insertion sort. */
    public static void insertSort(int ar[]) {
        if (ar.length < 2)
            return;

        for (int i = 1; i < ar.length; i++) {
            int val = ar[i];
            int j = i - 1;
            while (j >= 0 && ar[j] > val) {
                ar[j + 1] = ar[j];
                --j;
            }
            ar[j + 1] = val;
        }
    }

    /** Merge sort. */
    public static void mergeSort(int ar[], int ini, int end) {
        if (ini == end)
            return;

        // índice en la mitad del array
        int mid = (ini + end + 1) / 2;

        // --> splitting
        mergeSort(ar, ini, mid - 1);
        mergeSort(ar, mid, end);

        // --> merging (si no está ordenado)
        merge(ar, ini, mid, end);
    }

    private static void merge(int ar[], int ini, int mid, int end) {
        if (ar[mid - 1] <= ar[mid])
            return; // ya está ordenado

        int[] temp_ar = new int[end - ini + 1];

        // añadimos los elementos en orden
        int i = ini, j = mid, p = 0;
        while (i <= (mid - 1) && j <= end) temp_ar[p++] = (ar[i] <= ar[j]) ? ar[i++] : ar[j++];

        // añadimos los sobrantes (sólo de izquierda. Si sobran de la drcha, ya
        // están ordenados en el array original, por lo que no hace falta)
        while (i < mid) temp_ar[p++] = ar[i++];

        // actualizamos el array
        for (i = 0; i < p; i++) ar[ini + i] = temp_ar[i];
    }
}
