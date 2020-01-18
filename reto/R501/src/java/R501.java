import java.util.Scanner;

public class R501 {
    private final static int TD = 0;    // Tropas defensa
    private final static int TA = 1;    // Tropas ataque
    private final static int DD = 2;    // Dados defensa
    private final static int DA = 3;    // Dados ataque
    private final static int NO = 4;    // Num oleadas
    
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        int[] data = new int[5];

        while(cin.hasNext()) {
            data[TD] = cin.nextInt();
            data[TA] = cin.nextInt();
            data[DD] = cin.nextInt();
            data[DA] = cin.nextInt();
            data[NO] = cin.nextInt();

            int njd = (data[TD]<=data[DD])?data[TD]:data[DD];
            int nja = (data[TA]<=data[DA])?data[TA]:data[DA];

            int[] jd = new int[njd];
            int[] ja = new int[nja];

            int i, j, k, val;

            while(data[NO]-->0) {
                // tiradas defensa
                for(i=0, j=0; i<njd; i++, j=0) {
                    val = cin.nextInt();
                    while(j!=i) {
                        if(val > jd[j]) {
                            for(k=i; k>j; k--) jd[k] = jd[k-1];
                            break;
                        }
                        else j++;
                    }
                    jd[j] = val;
                }
                // tiradas ataque
                for(i=0, j=0; i<nja; i++, j=0) {
                    val = cin.nextInt();
                    while(j!=i) {
                        if(val > ja[j]) {
                            for(k=i; k>j; k--) ja[k] = ja[k-1];
                            break;
                        }
                        else j++;
                    }
                    ja[j] = val;
                }     
                // eval jugadas
                int fin = (nja<=njd)?nja:njd;
                for(i=0; i<fin; i++) 
                    if(ja[i]>jd[i]) data[TD]--;
                    else data[TA]--;

                njd = (data[TD]<=data[DD])?data[TD]:data[DD];
                nja = (data[TA]<=data[DA])?data[TA]:data[DA];
            }
            System.out.println(data[TD] + " " + data[TA]);
        }
    }
}
