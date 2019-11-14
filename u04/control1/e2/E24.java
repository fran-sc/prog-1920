//: u04/control1/e2/E24.java
package u04.control1.e2;

import java.util.Scanner;

/**
 * E24. 
 * Busca números primos hasta uno dado
 */
class E24 {
    public static boolean esPrimo(int n) {
        if(n<4) {
            return true;
        }

        boolean primo = true;
        for(int i=2; i<=n/2; i++) {
            if(n%i == 0){
                primo = false;
                break;
            }
        }        

        return primo;
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n;

        do {
            System.out.print("Introduce un número [>0]: ");
            n = scn.nextInt();
            if(n<1)
                System.out.println("Número no válido");
        } while(n<1);
        
        System.out.println("Primos: ");
        for(int i=1; i<=n; i++)
            if(esPrimo(i))
                System.out.print(i + " ");
        System.out.println();
    }        
}