import java.util.Scanner;

public class E7 {
    public static void main(String[] args) {
        Scanner cin=new Scanner(System.in);
        int n = Integer.parseInt(cin.nextLine());
        while(n-->0) 
            System.out.println("Hola, " + cin.nextLine().substring(4) + ".");
    }
}
