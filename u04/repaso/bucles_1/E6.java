import java.util.Scanner;

public class E6 {
    public static void main(String[] args) {
        Scanner cin=new Scanner(System.in);
        int n = cin.nextInt();
        while(n-->0) 
            System.out.println((cin.nextInt()+cin.nextInt()>=0)?"SI":"NO");
    }
}
