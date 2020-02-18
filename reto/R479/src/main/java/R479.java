/** 
 * R479. El hombre sin miedo y sin radar
 */

import java.util.Scanner;

public class R479 {
    private static final char VILLANO = 'X';
    private static final String NINGUNO = "NINGUNO";
    private static final String ARRIBA = "ARRIBA";
    private static final String ABAJO = "ABAJO";
    private static final String IZQUIERDA = "IZQUIERDA";
    private static final String DERECHA = "DERECHA";

    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        int c, f, n, i, j, k, dist;
        String dir;
        char[][] data;

        do {
            f = cin.nextInt();  // filas
            c = cin.nextInt();  // cols

            if (f!=0) {
                cin.nextLine(); // limpia buffer
                data = new char[f][];
                for(i=0; i<f; i++) 
                    data[i] = cin.nextLine().toCharArray();

                // procesamos las consultas
                n = cin.nextInt();
                while(n-->0) {
                    i = cin.nextInt()-1;              // Fila
                    j = cin.nextInt()-1;              // Columna
                    dir = cin.nextLine().trim();    // Dirección
                    dist = 0;
                    switch(dir) {
                        case ARRIBA:
                            for(k=i-1; k>=0; k--) {
                                dist++;
                                if(data[k][j] == VILLANO) break;
                            }
                            if(k == -1) dist = 0;   // Llegamos al final sin encontrar VILLANO
                            break;
                        case ABAJO:
                            for(k=i+1; k<f; k++) {
                                dist++;
                                if(data[k][j] == VILLANO) break;
                            }
                            if(k == f) dist = 0;   // Llegamos al final sin encontrar VILLANO
                            break;
                        case IZQUIERDA:
                            for(k=j-1; k>=0; k--) {
                                dist++;
                                if(data[i][k] == VILLANO) break;
                            }
                            if(k == -1) dist = 0;   // Llegamos al final sin encontrar VILLANO
                            break;
                        case DERECHA:
                            for(k=j+1; k<c; k++) {
                                dist++;
                                if(data[i][k] == VILLANO) break;
                            }
                            if(k == c) dist = 0;   // Llegamos al final sin encontrar VILLANO
                            break;                            
                    }
                    System.out.println((dist==0)?NINGUNO:dist);
                }
                System.out.println("---");
            }
        } while(f!=0);
    }
}