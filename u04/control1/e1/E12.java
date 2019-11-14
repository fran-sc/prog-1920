//: u04/control1/e1/E12.java
package u04.control1.e1;

import java.util.Scanner;

/**
 * E12. 
 * Haz un programa que solicite al usuario la entrada de un número entero y diga si es par o impar
 */
class E12 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Introduce un número entero: ");
        int num = sc.nextInt();

        if(num==0 || num%2 == 0)
            System.out.println(num + " es PAR");
        else
            System.out.println(num + " es IMPAR");
    }
}