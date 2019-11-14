//: u04/control1/e2/E21.java
package u04.control1.e2;

import java.util.Scanner;

/**
 * E21. 
 * Programa que pida un número entre 0 y 9 y muestra su tabla de multiplicar
 */
class E21 {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        int n;
        do {
            System.out.print("Introduce un número [0-9]:");
            n = scn.nextInt();
            if(n<0 || n>10)
                System.out.println("Número no válido");
        } while(n<0 || n>10);

        for(int i=0; i<=10; i++)
            System.out.println(n + " x " + i + " = " + n*i);
    }
}