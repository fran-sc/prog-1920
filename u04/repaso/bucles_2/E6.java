import java.util.Scanner;

public class E6 {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        while(true) {
            String in = cin.nextLine();
            if(in.charAt(0)=='-')
                break;
            long suma=0;
            String res = "";
            for(int i=0; i<in.length(); i++) {
                char c = in.charAt(i);
                suma += c - '0';
                res += c + ((i==in.length()-1)?" = ":" + ");
            }
            res += suma;
            System.out.println(res);
        }
    }
}
