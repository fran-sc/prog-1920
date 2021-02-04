/*
 * R376.  Siete picos.
 * */

import java.util.Scanner;

public class R376 {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        
        while(true) {
            int n = cin.nextInt();
            if(n==0)
                break;
            
            // leemos las alturas
            int[] alturas = new int[n];
            for(int i=0; i<n; i++)
                alturas[i] = cin.nextInt();
                
            // caso particular n=2
            if(n==2 && alturas[0]!=alturas[1]) {
                System.out.println(1);
                continue;
            }
            
            int nump = 0; // número de picos
            // ventana móvil de 3 alturas para detectar picos
            int[] win = new int[3]; 
            
            // movemos la ventana sobre el array
            for(int i=0; i<n; i++) {
                win[0] = alturas[i];
                win[1] = alturas[(i+1)%n];
                win[2] = alturas[(i+2)%n];
                if(win[1]>win[2] && win[1]>win[0])
                    ++nump;
            }

            System.out.println(nump);
        }
    }
}
