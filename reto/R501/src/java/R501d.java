import java.util.Scanner;
import java.util.Arrays;

public class R501d {
    private final static int TD = 0;    // Tropas defensa
    private final static int TA = 1;    // Tropas ataque
    private final static int DD = 2;    // Dados defensa
    private final static int DA = 3;    // Dados ataque
    private final static int NO = 4;    // Num oleadas
    
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        int[] data = new int[5];

        data[TD] = cin.nextInt();
        data[TA] = cin.nextInt();
        data[DD] = cin.nextInt();
        data[DA] = cin.nextInt();
        data[NO] = cin.nextInt();

        int i, j, njd, nja, jd[], ja[];

        while(data[NO]-->0) {
            njd = (data[TD]<=data[DD])?data[TD]:data[DD];
            nja = (data[TA]<=data[DA])?data[TA]:data[DA];
            
            jd = new int[njd];
            ja = new int[nja];

            // tiradas defensa
            for(i=0; i<njd; i++) jd[i] = cin.nextInt();

            // tiradas ataque
            for(i=0; i<nja; i++) ja[i] = cin.nextInt();

            // eval jugadas
            Arrays.sort(jd);
            Arrays.sort(ja);

            for(i=njd-1, j=nja-1; i>=0&&j>=0; i--, j--) 
                if(ja[j]>jd[i]) data[TD]--;
                else data[TA]--;

            njd = (data[TD]<=data[DD])?data[TD]:data[DD];
            nja = (data[TA]<=data[DA])?data[TA]:data[DA];
        }
        System.out.println(data[TD] + " " + data[TA]);
    }
}
