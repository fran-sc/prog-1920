import java.util.Scanner;

public class C4 {
    public static void main(String[] args) {
        int a, b, c;
        double d, x1, x2;
        Scanner cin = new Scanner(System.in);

        a = cin.nextInt();
        b = cin.nextInt();
        c = cin.nextInt();

        if(a==0 && b==0)
            System.out.println("Coeficientes no válidos");
        else if(a==0) 
            System.out.printf("X = %.2f%n", (double)-c/b);
        else {
            d = (b*b - 4*a*c);
            if(d==0)
                System.out.printf("X = %.2f%n", (double)-b/(2*a));
            else if(d<0)
                System.out.println("Sin solución real");
            else {
                double r = Math.sqrt(d);
                x1 = (-b+r)/(2*a);
                x2 = (-b-r)/(2*a);
                System.out.printf("X1 = %.2f; X2 = %.2f%n", x1, x2);
            }
        }
    }
}
