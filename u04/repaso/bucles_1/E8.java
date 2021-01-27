import java.util.Scanner;

public class E8 {
    public static void main(String[] args) {
        Scanner cin=new Scanner(System.in);
        while(true) {
            String t = cin.nextLine();
            if(t.equals("00:00"))
                break;
            int h = Integer.parseInt(t.substring(0,2));
            int m = Integer.parseInt(t.substring(3));
            
            System.out.println((23-h)*60 + (60-m));
        }
    }
}
