import java.util.Scanner;

public class E4 {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        int h, c;
        while(true) {
            h = cin.nextInt();
            c = cin.nextInt();
            if(h==0 && c==0)
                break;
            System.out.println(((h-1)/c+1)*10);
        }
    }
}
