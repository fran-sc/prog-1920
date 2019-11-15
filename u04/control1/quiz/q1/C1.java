import java.util.Scanner;

public class C1 {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);

        int n1 = cin.nextInt();
        int n2 = cin.nextInt();

        if(n1%n2 == 0)
            System.out.println(n1 + " es múltiplo de " + n2);
        else
            System.out.println(n1 + " no es múltiplo de " + n2);
    }
}
