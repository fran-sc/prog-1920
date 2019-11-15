import java.util.Scanner;

public class C1 {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);

        int n = cin.nextInt();
        if(n<0 || n>9)
                System.out.println("Número no válido");
        else
            for(int i=0; i<=10; i++)
                System.out.println(n + " x " + i + " = " + n*i);
    }
}
