import java.util.Scanner;

public class FibonacciDemo {
    public static void main(String[] args) {
        Scanner cin =  new Scanner(System.in);

        System.out.print("Cuántos términos de la serie? ");
        int n = cin.nextInt();

        if(n>=0) 
            Fibonacci.getSerie(n);
        else
            System.out.println("Valor no válido");
        
        System.out.println();
    }
}
