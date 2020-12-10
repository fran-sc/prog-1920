import java.util.Scanner;

public class E7 {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        while(true) {
            int n = cin.nextInt();
            if(n==0)
                break;
            int l=1, p=0;
            while(p+l<=n)
                p+=l++;
            --l;
            int r = n-p;
            System.out.println(l + " " + r);
        }
    }
}
