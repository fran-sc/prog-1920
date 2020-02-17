/** 
 * R176. Campo de minas
 */

import java.util.Scanner;

public class R176 {
    private static final char MINA = '*';
    private static final char FREE = '-';

    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        int c, f, i, j, celdas = 0;
        char[][] data;

        do {
            c = cin.nextInt();  // cols
            f = cin.nextInt();  // filas

            if (c!=0 && f!=0) {
                cin.nextLine(); // clear buffer
                data = new char[f][];
                for(i=0; i<f; i++) 
                    data[i] = cin.nextLine().toCharArray();

                // contamos celdas con, al menos, 6 minas alrededor
                celdas = 0;
                for(i=1; i<(f-1); i++)
                    for(j=1; j<(c-1); j++)
                        if(data[i][j]==FREE && getMinas(i, j, data)>=6) celdas++;

                System.out.println(celdas);
            }
        } while(c!=0 && f!=0);
    }

    private static int getMinas(int f, int c, char[][] data) {
        int minas = 0;

        int f_ini=f-1, f_fin=f+1, c_ini=c-1, c_fin=c+1;
        int i, j;
        for(i=f_ini; i<=f_fin; i++)
            for(j=c_ini; j<=c_fin; j++) 
                if((i!=f || j!=c) && data[i][j]==MINA) minas++;

        return minas;
    }
}