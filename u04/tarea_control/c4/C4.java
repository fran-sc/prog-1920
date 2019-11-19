import java.util.Scanner;

public class C4 {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        for(int i=0; i<Integer.valueOf(cin.nextLine()); i++)
            System.out.println(procesaEntrada(cin.nextLine(), cin.nextLine()));
    }

    private static String procesaEntrada(String titular, String mensaje) {
        String res = "SI";
        char m;

        titular = titular.toUpperCase().trim();
        mensaje = mensaje.toUpperCase().trim();

        for(int i=0, j=0; i<mensaje.length() && j!=-1; i++) {
            m = mensaje.charAt(i);
            if(m == ' ') continue;

            j = titular.indexOf(m, j);
            if(j==-1) res = "NO";
        }

        return res;
    }
}