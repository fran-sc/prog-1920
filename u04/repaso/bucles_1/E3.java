import java.util.Scanner;

public class E3 {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);

        int p, n = cin.nextInt();
        
        while(n-->0) {
            p=  cin.nextInt()*6 + 
                    cin.nextInt()*8 +
                    cin.nextInt()*10 +
                    cin.nextInt()*cin.nextInt()*2;
            System.out.println(p); 
        }
    }
}
