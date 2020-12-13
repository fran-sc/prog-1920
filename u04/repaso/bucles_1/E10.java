import java.util.Scanner;

public class E10 {
    public static void main(String[] args) {
        final int MAX = 99;
        Scanner cin = new Scanner(System.in);
        int n1, n2, d1, d2;
        while(true) {
            n1 = cin.nextInt();
            n2 = cin.nextInt();
            if(n1==0 && n2==0)
                break;
            d1 = Math.abs(n2-n1);
            d2 = MAX-d1;
            System.out.println(d1<d2?d1:d2);
        }
    }
}
