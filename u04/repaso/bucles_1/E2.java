import java.util.Scanner;

public class E2 {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        int n, p=0;
        while(true) {
            n = cin.nextInt();
            if(n==0) break;
            // 3*n palillos por fila
            for(i=n, p=0;i>0;i--) p+=i; 
            System.out.println(3*p);
        }
    }
}
