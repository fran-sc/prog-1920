//: E2.java
package u02.basicos;

import java.util.Scanner;
import java.util.Locale;    // para cambiar configuración regional

/**
 * E2. 
 * Escribe un programa que pida una temperatura en grados Celsius y que escriba esa temperatura en * grados Fahrenheit (la relación entre grados Celsius (C) y grados Fahrenheit (F) es la siguiente: 
 * F = 1,8 * C + 32). La entrada puede contener decimales. La salida se mostrará redondeada a 1 
 * decimal
 */
class E2 {
    public static void main(String[] args) {
        // Creamos un objeto Scanner para la entrada de datos
        Scanner entrada = new Scanner(System.in);

        // Cambiamos la configuración de entrada para usar punto como separador decimal
        entrada.useLocale(Locale.US);   

        System.out.println("\nCONVERSOR DE GRADOS CELSIUS A GRADOS FAHRENHEIT");
        
        System.out.print("\nIntroduce una temperatura en grados Celsius: ");
        double celsius = entrada.nextDouble();

        double fahr = 1.8*celsius + 32;

        System.out.printf(Locale.US, "%n%.1f ºC son %.1f ºF%n", celsius, fahr);

        /* Si quisiéramos mantener en la salida la configuración regional del sistema haríamos
        System.out.printf("%n%.1f ºC son %.1f ºF%n", celsius, fahr);
        */
    }
}
/* Output:

CONVERSOR DE GRADOS CELSIUS A GRADOS FAHRENHEIT

Introduce una temperatura en grados Celsius: 35

35.0 ºC son 95.0 ºF
*///:~
