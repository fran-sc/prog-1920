import java.util.Scanner;

public class E2 {
    private static int numDias(int d, int m) {
        int tot = 0;
        switch(m) {
            case 1: tot = 334 + (31-d); break;
            case 2: tot = 304 + (30-d); break;
            case 3: tot = 273 + (31-d); break;
            case 4: tot = 243 + (30-d); break;
            case 5: tot = 212 + (31-d); break;
            case 6: tot = 181 + (30-d); break;
            case 7: tot = 151 + (31-d); break;
            case 8: tot = 120 + (31-d); break;
            case 9: tot = 90 + (30-d); break;
            case 10: tot = 59 + (31-d); break;
            case 11: tot = 29 + (30-d); break;
            case 12: tot = 31-d;
        }
        return tot;
    }
    
    private static int numDias2(int d, int m) {
        int[] diasPorMes = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        
        int tot=0;
        for(int i=m; i<diasPorMes.length; i++)
            tot += diasPorMes[i];
        tot += diasPorMes[m-1]-d;
        
        return tot;
    }
    
    public static void main(String args[]) {
        Scanner cin = new Scanner(System.in);
        int n = Integer.parseInt(cin.nextLine());
        while(n-->0) {
            int d = cin.nextInt();
            int m = cin.nextInt();

            // versión con switch
            //System.out.println(numDias2(d,m));
            
            // versión con arrays... más simple
            System.out.println(numDias2(d,m));
        }
    }
}
