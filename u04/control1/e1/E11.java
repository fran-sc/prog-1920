//: u04/control1/e1/E11.java
package u04.control1.e1;

import java.util.Scanner;

/**
 * E11. 
 * Diseña un programa que pida dos números por teclado, determine si el primero es múltiplo del 
 * segundo y muestre el resultado
 */
class E11 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Introduce dos números enteros: ");
        
        System.out.print("N1: ");
        int n1 = sc.nextInt();

        System.out.print("N1: ");
        int n2 = sc.nextInt();

        if(n1%n2 == 0)
            System.out.println(n1 + " es múltiplo de " + n2);
        else
            System.out.println(n1 + " no es múltiplo de " + n2);
    }
}