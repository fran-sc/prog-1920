import java.util.Scanner;

class DiamondDemo {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);

        System.out.println("De cuántas filas quieres que sea la figura? ");
        int filas = cin.nextInt();

        if(!Diamond.create(filas))
            System.out.println("El valor introducido no es correcto");
        else
            DiamondFlip.create(filas);
    }
}