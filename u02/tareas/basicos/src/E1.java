//: E1.java
package u02.basicos;

import java.util.Scanner;

/**
 * E1. 
 * Escribe un programa que pida el número de días, horas, minutos y segundos
 * y calcule el número total de segundos.
 */
class E1 {
    public static void main(String[] args) {
        // Creamos un objeto Scanner para la entrada de datos
        Scanner entrada = new Scanner(System.in);

        System.out.println("\nCONVERSOR A SEGUNDOS");
        
        System.out.print("\nNúmero de días: ");
        int numDias = entrada.nextInt();

        System.out.print("Número de horas: ");
        int numHoras = entrada.nextInt();

        System.out.print("Número de minutos: ");
        int numMinutos = entrada.nextInt();

        System.out.print("Número de segundos: ");
        int numSegundos = entrada.nextInt();        

        long totSegundos = numSegundos + ((numMinutos + (numHoras + (numDias * 24))*60)*60);

        System.out.print("\n" + numDias + " dias, " + numHoras + " horas," + numMinutos);
        System.out.print(" minutos y " + numSegundos + " segundos son ");
        System.out.println(totSegundos + " segundos");
    }
}
/* Output:

CONVERSOR A SEGUNDOS

Número de días: 365
Número de horas: 5
Número de minutos: 48
Número de segundos: 45

365 dias, 5 horas,48 minutos y 45 segundos son 31556925 segundos
*///:~

