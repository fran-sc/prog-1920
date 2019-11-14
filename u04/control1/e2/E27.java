//: u04/control1/e2/E27.java
package u04.control1.e2;

import java.util.Scanner;

/**
 * E27. 
 * Si te fijas en la codificación ASCII de las letras, se puede observar cómo la diferencia entre 
 * una letra mayúscula y su correspondiente minúscula, está en el bit 6
 * 
 *			A   →    6510  →  0b1000001
 *			a   →    9710  →  0b1100001
 *			B   →    6610  →  0b1000010
 *			b   →    9810  →  0b1100010
 * 			C   →    6710  →  0b1000011
 *			c   →    9910  →  0b1100011
 *
 * Haz un programa que acepte un texto por teclado y, usando las operaciones de nivel de bit, 
 * convierta cada carácter al contrario. El cambio sólo debería afectar a los caracteres alfabéticos
 */
class E27 {
    public static void main(String[] args) {
        final String EOF = "<>";
        final int MASK = 0b10_0000;

        Scanner scn = new Scanner(System.in);
        
        String line = "";

        System.out.println("Escribe lo que quieras (<> para Finalizar)");
        while(!line.contains(EOF)) {
            line = scn.nextLine();
            String newLine = "";

            for(int i=0; i<line.length(); i++) {
                char c = line.charAt(i);
                if((c>='a' && c<='z') || (c>='A' && c<='Z')) { 
                    c ^= MASK;
                }
                newLine += c;
            }

            System.out.println(newLine);
        }
    }        
}