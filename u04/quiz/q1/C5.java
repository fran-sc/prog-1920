import java.util.Scanner;

public class C5 {
    public static void main(String[] args) {
        final String LETRAS = "TRWAGMYFPDXBNJZSQVHLCKE";
        String dni;

        Scanner cin = new Scanner(System.in);
        dni = cin.nextLine();
        
        if(dni.trim().length()!=8)
            System.out.println("DNI no válido");
        else {
            char letra = LETRAS.charAt(Integer.valueOf(dni)%23);
            System.out.println(letra);
        }
    }
}
