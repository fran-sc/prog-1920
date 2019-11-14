//: u04/control1/e2/E23.java
package u04.control1.e2;

import java.util.Scanner;

/**
 * E23. 
 * Determina si el número introducido es primo o no
 */
class E23 {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n;

        do {
            System.out.print("Introduce un número [>0]: ");
            n = scn.nextInt();
            if(n<1)
                System.out.println("Número no válido");
        } while(n<1);
        
        if(n<4)
            System.out.println("El número " + n + " es primo");
        else {
            boolean primo = true;
            for(int i=2; i<=n/2; i++) {
                if(n%i == 0){
                    primo = false;
                    break;
                }
            }
            System.out.println(n + (primo?" ":" no ") + "es primo");            
        }
    }        
}