import java.util.Scanner;

public class C4 {
    public static int esPrimo(int n) {
        if(n<1) return -1;
        if(n<4) return 1;

        boolean primo = true;
        for(int i=2; i<=n/2; i++)
            if(n%i == 0){
                primo = false;
                break;
            }
        return (primo)?1:0;
    }

    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        int n = cin.nextInt();

        if(n<1)
                System.out.println("Número no válido");
        else {
            boolean primero = true;
            for(int i=1; i<=n; i++)
                if(esPrimo(i)==1) {
                    if(!primero) System.out.print(",");
                    else primero=false;
                    System.out.print(i);
                }
        }
    }        
}
