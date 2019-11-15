import java.util.Scanner;

public class C6 {
    public static void main(String[] args) {
        final String EOF = "<>";

        Scanner cin = new Scanner(System.in);
        
        int numc = 0;
        char c;
        String line = "";

        c = cin.nextLine().trim().charAt(0);
        
        int fin;
        do {
            line = cin.nextLine();
            fin = line.indexOf(EOF);
            if(fin!=-1) line = line.substring(0, fin);
            for(int i=0; i<line.length(); i++) 
                if(line.charAt(i) == c) numc++;
        } while(fin == -1);

        System.out.println(numc);
    }        
}
