import java.util.Scanner;

public class E5 {
    public static void main(String[] args) {
        Scanner cin=new Scanner(System.in);
        int n = cin.nextInt();
        while(n-->0) 
            System.out.println((cin.nextInt()==25 && cin.nextInt()==12)?"SI":"NO");
        
    }
}
