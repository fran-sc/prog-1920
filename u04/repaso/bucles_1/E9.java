import java.util.Scanner;

public class E9 {
    public static void main(String[] args) {
        Scanner cin=new Scanner(System.in);
        int n = Integer.parseInt(cin.nextLine());
        while(n-->0) {
            String s = cin.nextLine();
            int p = s.indexOf(' ');
            String s1 = s.substring(0,p).toLowerCase();
            String s2 = s.substring(p+4).toLowerCase();
            System.out.println(((s1.equals(s2))?"":"NO ") + "TAUTOLOGIA");
        }
    }
}
