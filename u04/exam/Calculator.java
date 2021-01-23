import java.util.Scanner;

public class Calculator {
    public static final char EQU = '=';
    public static final char ADD = '+';
    public static final char SUB = '-';
    public static final char MUL = '*';
    public static final char DIV = '/';
    public static final char POW = '^';
    public static final char MOD = '%';
    public static final char MEM = 'M';
    public static final char CLR = 'C';

    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        double m=0.0, a=0.0, v=0.0;

        while(true) {
            String in = cin.nextLine();
            if(in.charAt(0) == EQU)
                break;
            
            // valor o memoria?
            if(in.length()>1)
                v = (in.charAt(1)==MEM)?m:Double.parseDouble(in.substring(1));

            switch(in.charAt(0)) {
                case ADD:
                    a += v;
                    break;
                case SUB:
                    a -= v;
                    break;
                case MUL:
                    a *= v;
                    break;
                case DIV:
                    a /= v;
                    break;
                case POW:
                    a = Math.pow(a,(int)v);
                    break;
                case MEM:
                    m = a;
                    break;
                case CLR:
                    a = 0.0;
                    break;
            }
        }
        System.out.println("M: " + m);
        System.out.println("A: " + a);
    }
}
