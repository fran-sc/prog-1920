import java.util.Scanner;

public class E1 {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        String line;
        while(true) {
            line = cin.nextLine();
            if(line.equals("0 0"))
                break;
            int blk = line.indexOf(" ");
            int ac = 0;
            for(int i=0, j=blk+1; i<blk; i++, j++)
                if( (line.charAt(i)-'0') + 
                    (line.charAt(j)-'0') > 9)
                        ++ac;
            System.out.println(ac);
        }
    }
}
