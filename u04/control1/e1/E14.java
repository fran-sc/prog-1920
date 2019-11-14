//: u04/control1/e1/E14.java
package u04.control1.e1;

import java.util.Scanner;

/**
 * E14. 
 * Programa para resolver ecuaciones de segundo grado 
 */
class E14 {
    public static void main(String[] args) {
        double a, b, c, d, x1, x2;
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Coeficiente A: ");
        a = sc.nextDouble();

        System.out.print("Coeficiente B: ");
        b = sc.nextDouble();
        
        System.out.print("Coeficiente C: ");
        c = sc.nextDouble();

        if(a==0 && b==0)
            System.out.println("Coeficientes no válidos");
        else if(a==0) 
            System.out.println("La solución es " + -c/b);
        else {
            d = (b*b - 4*a*c);
            if(d==0)
                System.out.println("La solución es " + -b/(2*a));
            else if(d<0)
                System.out.println("No tiene solución real");
            else {
                d = Math.sqrt(d);
                x1 = (-b-d)/(2*a);
                x2 = (-b+d)/(2*a);
                System.out.println("Las soluciones son " + x1 + " y " + x2);
            }
        }
    }
}