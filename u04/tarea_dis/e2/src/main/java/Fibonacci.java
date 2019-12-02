public class Fibonacci {
    public static void getSerie(int n) {
        final int MAX_COLS = 4;
        long ant1 = 1, ant2 = 1, val;
        int cont = 0;

        while(cont++<n) {
            if(cont<3) val = 1;
            else {
                val = ant1 + ant2;
                ant2 = ant1;
                ant1 = val;
            }
            System.out.printf("%-20d", val);
            if(cont%MAX_COLS==0) System.out.println();
        }
    }
}
