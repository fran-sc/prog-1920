//: u04/control1/e2/E28.java
package u04.control1.e2;

import java.util.Scanner;

/**
 * E28. 
 * Detector de palíndromos.
 */
class E28 {
    public static String eliminaTildes(String sCon) {
        final String vocCon = "áéíóúÁÉÍÓÚ";
        final String vocSin = "aeiouAEIOU";

        String sSin = new String(sCon);

        for(int i=0; i<vocCon.length(); i++) {
            sSin = sSin.replaceAll("" + vocCon.charAt(i), "" + vocSin.charAt(i));
        }

        return sSin;
    }

    public static void main(String[] args) {
        final String signos = " ,;.:¡!¿?\"";

        Scanner scn = new Scanner(System.in);
        
        String linea, copia;

        System.out.println("Escribe una frase");
        linea = scn.nextLine();

        // Hacemos una copia
        copia = new String(linea);

        // Eliminamos espacios y convertimos a minúsculas
        copia = copia.trim().toLowerCase();

        // Sustituimos vocales acentuadas
        copia = eliminaTildes(copia);

        // Comprobamos si es palíndromo
        int i=0, j=copia.length()-1;
        char a, b;
        boolean pal = true;

        // Recorremos la cadena con dos índices, uno desde el ppio y otro desde el final
        while(i<j) {    
            a = copia.charAt(i);
            b = copia.charAt(j);
            if(signos.indexOf(a) != -1) {
                i++;
                continue;
            }
            if(signos.indexOf(b) != -1) {
                j--;
                continue;
            }
            if(a != b) {
                pal = false;
                break;
            }
            i++; j--;
        }

        System.out.println((pal?"Es ":"No es ") + "un palíndromo");
    }        
}