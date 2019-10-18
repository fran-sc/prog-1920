//: E5.java
package u02.basicos;

import java.util.Scanner;
import java.util.Locale;    // para cambiar configuración regional

/**
 * E5. 
 * Escribe un programa que solicite la nota de cada una de las 3 evaluaciones (pueden contener 
 * decimales). El programa mostrará la nota final (media de la nota de las evaluaciones) de dos
 *  maneras: redondeada a dos decimales y redondeada al entero más próximo
 */
class E5 {
    public static void main(String[] args) {
        // Creamos un objeto Scanner para la entrada de datos
        Scanner entrada = new Scanner(System.in);

        // Cambiamos la configuración de entrada para usar punto como separador decimal
        entrada.useLocale(Locale.US);   

        System.out.println("\nCÁLCULO NOTA FINAL");
        
        double notaFinal = 0;

        System.out.print("\nIntroduce la nota de la evaluación 1: ");
        notaFinal += entrada.nextDouble();

        System.out.print("Introduce la nota de la evaluación 2: ");
        notaFinal += entrada.nextDouble();

        System.out.print("Introduce la nota de la evaluación 3: ");
        notaFinal += entrada.nextDouble();

        notaFinal /= 3; // Nota media

        // Para calcular el entero más próximo, sumamos 0.5 y truncamos
        int notaFinalEnt = (int) (notaFinal + 0.5);

        System.out.printf(Locale.US, "%nNota Final (decimal): %.2f%n", notaFinal);
        System.out.printf(Locale.US, "Nota Final (entero): %d%n", notaFinalEnt);
    }
}
/* Output:

CONVERSOR DE GRADOS CELSIUS A GRADOS FAHRENHEIT

Introduce una temperatura en grados Celsius: 35

35.0 ºC son 95.0 ºF
*///:~
