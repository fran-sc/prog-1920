/**
 * R345. Sudokus correctos
 */

import java.util.Scanner;
import java.util.Arrays;

public class R345 {
    private static final int SIZE = 9;  // Tamaño fila
    private static final int REG = 3;   // Regiones por fila

    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        
        int[][] data = new int[SIZE][SIZE];
        boolean[] val = new boolean[SIZE+1]; // Ignoramos el primer valor

        int f, c, k;

        int n = cin.nextInt();  // casos de prueba
main_loop:
        while(n-->0) {
            // leemos sudoku
            for(f=0; f<SIZE; f++)
                for(c=0; c<SIZE; c++)
                    data[f][c] = cin.nextInt();
                
            // Procesamos filas
            for(f=0; f<SIZE; f++) {
                Arrays.fill(val, false);
        
                for(c=0; c<SIZE; c++) { 
                    k = data[f][c];
                    if(val[k]) {
                        System.out.println("NO");
                        continue main_loop;
                    }
                    else val[k] = true;
                }

                // Test regiones cada 3 filas
                if((f+1)%3==0 && !testRegiones(f, data)) {
                    System.out.println("NO");
                    continue main_loop;
                }
            }

            // Columnas
            if(!testColumnas(data)) {
                System.out.println("NO");
                continue;                    
            }
            
            System.out.println("SI");
        }
    }

    private static boolean testRegiones(int fila, int[][] data) {
        boolean[] val = new boolean[SIZE+1];
        
        int f_ini=fila-2, f_fin=fila, c_ini=0, c_fin=2, f, c;

        for(int reg=REG; reg>0; c_ini+=3, c_fin+=3, reg--) {
            Arrays.fill(val, false);
        
            for(f=f_ini; f<=f_fin; f++) 
                for(c=c_ini; c<=c_fin; c++)
                    if(val[data[f][c]]) return false;
                    else val[data[f][c]] = true;
        }

        return true;
    }

    private static boolean testColumnas(int[][] data) {
        boolean[] val = new boolean[SIZE+1];
        
        int f, c;

        for(c=0; c<SIZE; c++) {
            Arrays.fill(val, false);        
        
            for(f=0; f<SIZE; f++) 
                if(val[data[f][c]]) return false;
                else val[data[f][c]] = true;
        }

        return true;
    }    
}