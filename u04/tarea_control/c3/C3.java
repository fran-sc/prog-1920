import java.util.Scanner;

public class C3 {
    public static void main(String[] args) {
        int n=-1, p=-1, j;
        long faul;
        Scanner cin = new Scanner(System.in);
        while(n!=0 && p!=0) {
            n = cin.nextInt();
            p = cin.nextInt();
            if((n>=1 && n<=10) && (p>=1 && p<=10)) {
                for(j=1, faul=0; j<=n; j++) faul += Math.pow(j, p);
                System.out.println(faul);
            }
        }
    }
}
