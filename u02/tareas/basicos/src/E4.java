//: u02/basicos/E4.java
package u02.basicos;

import java.util.Scanner;
import java.util.Locale;

/**
 * E4. 
 * Haz un programa que pida al usuario una cantidad en euros, una tasa de interés y un número de
 * años. El programa mostrará por pantalla cuál será el capital resultante transcurridos el número 
 * de años indicado. La salida debe mostrar el formato del ejemplo de ejecución adjunto
 * 
 * Dado un capital inicial C, el capital resultante a un interés del X por cien durante n años es:
 * 
 *                          C ✕ (1 + X/100)ⁿ
 */
class E4 {
    public static void main(String[] args) {
        // Creamos un objeto Scanner para la entrada de datos
        Scanner entrada = new Scanner(System.in);

        System.out.print("\nIntroduce el capital inicial (€): ");
        double capitalIni = entrada.nextDouble();

        System.out.print("Introduce el interés anual (%): ");
        double interes = entrada.nextDouble();

        System.out.print("Introduce el número de años: ");
        int anhos = entrada.nextInt();

        double capitalFinal = capitalIni * Math.pow((1 + interes/100.0), anhos);

        System.out.println();   // Línea en blanco
        System.out.println("######################################");
        System.out.println("#                                    #");
        System.out.printf("# %-16s%,16.2f %c #%n", "Capital inicial:", capitalIni, '€');
        System.out.printf("# %-16s%16.2f %c #%n", "Interés anual:", interes, '%');
        System.out.printf("# %-16s%16d %c #%n", "Periodo:", anhos, 'A');
        System.out.println("#                                    #");
        System.out.printf("# %-16s%,16.2f %c #%n", "Capital final:", capitalFinal, '€');
        System.out.printf("# %-16s%,16.2f %c #%n", "Rendimiento:", capitalFinal - capitalIni, '€');
        System.out.println("#                                    #");
        System.out.println("######################################");
    }
}
/* Output:

Introduce el capital inicial (€): 10000
Introduce el interés anual (%): 4,5
Introduce el número de años: 20

######################################
#                                    #
# Capital inicial:       10.000,00 € #
# Interés anual:              4,50 % #
# Periodo:                      20 A #
#                                    #
# Capital final:         24.117,14 € #
# Rendimiento:           14.117,14 € #
#                                    #
######################################
*///:~
