import java.util.Scanner;

public class C3 {
    public static void main(String[] args) {
        int n, p, i;
        long faul;
        Scanner cin = new Scanner(System.in);
        do {
            n = cin.nextInt();
            p = cin.nextInt();
            if((n>=1 && n<=10) && (p>=1 && p<=10)) {
                for(i=1, faul=0; i<=n; i++) faul += Math.pow(i, p);
                System.out.println(faul);
            }
        } while(n!=0 && p!=0);
    }
}
