import java.util.Scanner;

public class E7 {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        while(true) {
            int n = cin.nextInt();
            if(n==0)
                break;
                
            int l=1, p=0;   // lados, piedras usadas
            while(p+l<=n)
                p+=l++;
            --l;
            int r = n-p;    // piedras restantes
            System.out.println(l + " " + r);
        }
    }
}
