import java.util.Locale;
import java.util.Scanner;

public class C5 {
    public static void main(String[] args) {
        final String EOF = "00";

        Scanner cin = new Scanner(System.in);
        cin.useLocale(Locale.US);

        double n, suma = 0, min = 0, max = 0, cont = 0;
        boolean primero = true;
        String snum;

        do {
            snum = cin.nextLine().trim();
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
