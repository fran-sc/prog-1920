//: u04/control1/e2/E25.java
package u04.control1.e2;

import java.util.Locale;
import java.util.Scanner;

/**
 * E25. 
 * Escribe un programa que solicite al usuario la introdución de valores numéricos (uno por línea)
 * hasta que se introduzca el valor “00”. A continuación, se mostrará la suma, el mayor y el menor 
 * de los valores introducidos
 */
class E25 {
    public static void main(String[] args) {
        final String EOF = "00";

        Scanner scn = new Scanner(System.in);
        scn.useLocale(Locale.US);

        double n, suma = 0, min = 0, max = 0, cont = 0;
        boolean primero = true;
        String snum;

        System.out.print("Introduce los números (00 - Fin)\n");
        do {
            snum = scn.nextLine().trim();
            if(!snum.equals(EOF)) {
                n = Double.parseDouble(snum);
                cont++;
                if(primero) {
                    min = n;
                    max = n;
                    primero = false;
                }
                else {
                    if(n<min) {
                        min = n;
                    }
                    else if(n>max) {
                        max = n;
                    }
                }
                suma += n;
            }
        } while(!snum.equals(EOF));
        
        if(primero) {
            System.out.println("No hay datos");
        }
        else{
            System.out.println("Min: " + min);
            System.out.println("Max: " + max);
            System.out.printf(Locale.US, "Suma: %.2f%n", suma);
            System.out.printf(Locale.US, "Media: %.2f%n", suma/cont);
        }
    }        
}