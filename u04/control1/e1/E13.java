//: u04/control1/e1/E13.java
package u04.control1.e1;

import java.util.Scanner;

/**
 * E13. 
 * Haz un programa que acepte 3 números introducidos por el usuario y
 * muestre el mensaje “3 iguales” si los tres números son iguales o
 * muestre el mayor de los 3 en caso de que no sean iguales. 
 */
class E13 {
    public static void main(String[] args) {
        int n1, n2, n3, max;
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Número 1: ");
        n1 = sc.nextInt();

        System.out.print("Número 2: ");
        n2 = sc.nextInt();
        
        System.out.print("Número 3: ");
        n3 = sc.nextInt();        

        if(n1==n2 && n2==n3)
            System.out.println("3 iguales");
        else {
            max = n1;
            if(n2>max)
                max = n2;
            if(n3>max)
                max = n3;
            System.out.println("El mayor es " + max);
        }
    }
}