//: u04/control1/e1/E15.java
//package u04.control1.e1;

import java.util.Scanner;

/**
 * E15. 
 * Programa para calcular la letra del DNI
 */
class E15 {
    public static void main(String[] args) {
        final String LETRAS = "TRWAGMYFPDXBNJZSQVHLCKE";
        String dni;
        Scanner sc = new Scanner(System.in);
        
        System.out.print("DNI: ");
        dni = sc.nextLine().trim();

        if(dni.length()!=8)
            System.out.println("El número de DNI no es válido");
        else {
            char letra = LETRAS.charAt(Integer.valueOf(dni)%23);
            System.out.println("La letra es '" + letra + "'");
        }
    }
}