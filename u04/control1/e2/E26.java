//: u04/control1/e2/E26.java
package u04.control1.e2;

import java.util.Scanner;

/**
 * E26. 
 * Diseña un programa que, en primer lugar, le pida al usuario que escriba un carácter cualquiera
 * (letra, dígito,...). A continuación, aceptará entradas del usuario hasta que éste escriba la
 * secuencia “<>”. Por último, mostrará cuántas ocurrencias del carácter se produjeron en el texto
 * introducido hasta la aparición de dicha secuencia.
 */
class E26 {
    public static void main(String[] args) {
        final String EOF = "<>";

        Scanner scn = new Scanner(System.in);
        
        int numc = 0;
        char c;
        String line = "";

        System.out.print("Introduce un carácter: ");
        c = scn.nextLine().trim().charAt(0);


        System.out.println("Escribe lo que quieras (<> para Finalizar)");
        while(!line.contains(EOF)) {
            line = scn.nextLine();
            for(int i=0; i<line.length(); i++) 
                if(line.charAt(i) == c)
                    numc++;
        }

        System.out.println("Apariciones de '" + c + "': " + numc);
    }        
}