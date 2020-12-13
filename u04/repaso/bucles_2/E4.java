import java.util.Scanner;

public class E4 {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        
        while(true) {
            int n = cin.nextInt();
            if(n==0)
                break;
            for(int j=0; j<n; j++)
                System.out.print("1");
            System.out.println();
        }
    }
}
