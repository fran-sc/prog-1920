import java.util.Scanner;

public class E1 {
    private static String eliminaTildes(String s) {
        final String vocCon = "ÁÉÍÓÚ";
        final String vocSin = "AEIOU";
    
        String sSin = new String(s);
    
        for(int i=0; i<vocCon.length(); i++) {
            sSin = sSin.replaceAll("" + vocCon.charAt(i), "" + vocSin.charAt(i));
        }
    
        return sSin;
    }
    
    private static String soloAlfaNum(String s) {
        String sSin = "";
        char c;
        
        for(int i=0; i<s.length(); i++) {
            c = s.charAt(i);
            if((c>='A' && c<='Z') || (c>='0' && c<='9') || c=='Ñ') sSin += c;
        }
        
        return sSin;
    }
    
    private static boolean esPalindromo(String s) {
        String copia;
        
        copia = s.trim().toUpperCase(); // a mayúsculas
        copia = eliminaTildes(copia);   // no tildes
        copia = soloAlfaNum(copia);     // no signos
    
        char a, b;
        boolean pal = true;
        for(int i=0, j=copia.length()-1; i<j; i++, j--) {    
            a = copia.charAt(i);
            b = copia.charAt(j);
            if(a != b) {
                pal = false;
                break;
            }
        }
    
        return pal;
    }        
    
    public static void main(String[] args) {
        final String EXIT = "XXX";
        
        Scanner cin = new Scanner(System.in);
        
        while(true) {
            String input = cin.nextLine();
            if(input.equals(EXIT))
                break;
            System.out.println(esPalindromo(input)?"SI":"NO");
        }
    }
}
