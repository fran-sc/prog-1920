import java.util.Scanner;

public class C3 {
    public static void main(String[] args) {
        int n1, n2, n3, max;
        Scanner cin = new Scanner(System.in);
        
        n1 = cin.nextInt();
        n2 = cin.nextInt();
        n3 = cin.nextInt();        

        if(n1==n2 && n2==n3)
            System.out.println("3 iguales");
        else {
            max = n1;
            if(n2>max)
                max = n2;
            if(n3>max)
                max = n3;
            System.out.println(max);
        }
    }
}
