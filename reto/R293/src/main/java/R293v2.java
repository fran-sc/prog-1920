import java.util.Scanner;

public class R293v2 {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);

        int p, n = cin.nextInt();
        cin.nextLine(); 
        while(n-->0) {
            String[] s = cin.nextLine().split(" ");
            p=  Integer.parseInt(s[0])*6 + 
                Integer.parseInt(s[1])*8 +
                Integer.parseInt(s[2])*10 +
                Integer.parseInt(s[3])*Integer.parseInt(s[4])*2;
            System.out.println(p); 
        }
    }
}
