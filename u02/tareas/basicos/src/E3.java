//: E3.java
package u02.basicos;

import java.util.Scanner;

/**
 * E3. 
 * Diseña un programa que solicite el radio de una circunferencia y calcule su longitud (2✕π✕r) y
 * área (r✕π²). La salida de los valores numéricos debe ser con dos decimales de precisión y deben
 * quedar alineados por la derecha según el ejemplo de ejecución
 */
class E3 {
    public static void main(String[] args) {
        // Creamos un objeto Scanner para la entrada de datos
        Scanner entrada = new Scanner(System.in);

        System.out.print("\nIntroduce el radio: ");
        double radio = entrada.nextDouble();

        double longitud = 2 * Math.PI * radio;
        double area = Math.PI * Math.pow(radio, 2);

        System.out.println();   // Línea en blanco
        System.out.println("==========================================");
        System.out.printf("%-30s%12.2f%n", "Longitud de la circunferencia:", longitud);
        System.out.printf("%-30s%12.2f%n", "Área del círculo:", area);
        System.out.println("==========================================");
    }
}
/* Output:

Introduce el radio: 2,25

==========================================
Longitud de la circunferencia:       14,14
Área del círculo:                    15,90
==========================================
*///:~
