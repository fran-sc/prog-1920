/** 
 * R207. Sombras en el camping 
 */

import java.util.Scanner;

public class R207 {
    private static final int ARBOL = 1;
    private static final int FREE = 0;
    private static final int VISITED = -1;

    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        int c, f, a, cel[][], i, x, y, sombras;

        do {
            c = cin.nextInt();  // cols
            f = cin.nextInt();  // filas
            a = cin.nextInt();  // árboles            

            if (c!=0) {
                sombras = 0;

                if(a==0) {
                    System.out.println(sombras);
                    continue;
                }
                
                // tablero
                cel = new int[f][c];

                // añadimos los árboles
                for(i=0; i<a; i++) {
                    y = cin.nextInt()-1;   // col
                    x = cin.nextInt()-1;   // fila
                    sombras += nuevoArbol(x, y, cel); // de paso, contamos las sombras
                }

                System.out.println(sombras);
            }
        } while(c!=0);
    }

    /**
     * Añade un nuevo árbol y devuelve cuántas nuevas celdas de sombra hay
     */
    private static int nuevoArbol(int x, int y, int[][] cel) {
        int res = 0, fi, ff, ci, cf, c, f;
        
        if(cel[x][y]==VISITED) res -= 1; // restamos una contada previamente
        cel[x][y] = ARBOL;
        
        fi = (x>0)?(x-1):x;
        ff = (x<cel.length-1)?x+1:x;
        ci = (y>0)?(y-1):y;
        cf = (y<cel[0].length-1)?y+1:y;

        for(f=fi;f<=ff;f++)
            for(c=ci;c<=cf;c++)
                if(cel[f][c]==FREE) {       // celda libre?
                    res++;                  // una sombra más
                    cel[f][c] = VISITED;    // la marcamos como visitada
                }

        return res;
    }
}