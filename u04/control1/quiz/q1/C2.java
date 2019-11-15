import java.util.Scanner;

public class C2 {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        int num = cin.nextInt();
        System.out.println(num + " es un número " + ((num%2 == 0)?"par":"impar"));
    }
}
