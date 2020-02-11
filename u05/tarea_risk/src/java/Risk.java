import java.util.Scanner;
import java.util.Arrays;

public class Risk {
    private final static int TD = 0;    // Tropas defensa
    private final static int TA = 1;    // Tropas ataque
    private final static int DD = 2;    // Dados defensa
    private final static int DA = 3;    // Dados ataque
    private final static int NO = 4;    // Num oleadas
    
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        int[] data = new int[5];

        int i, j, njd, nja, jd[], ja[];

	// Mientras haya casos de prueba
	while(cin.hasNext()) {
            data[TD] = cin.nextInt();
            data[TA] = cin.nextInt();
            data[DD] = cin.nextInt();
            data[DA] = cin.nextInt();
            data[NO] = cin.nextInt();

            // Mientras haya oleadas...
            while(data[NO]-->0) {
                // Jugadas de la defensa
                njd = (data[TD]<=data[DD])?data[TD]:data[DD];
                jd = new int[njd];
            
                // Jugadas del ataque
                nja = (data[TA]<=data[DA])?data[TA]:data[DA];
                ja = new int[nja];

                // Tiradas defensa
                for(i=0; i<njd; i++) jd[i] = cin.nextInt();

                // Tiradas ataque
                for(i=0; i<nja; i++) ja[i] = cin.nextInt();

                // Evaluar las jugadas
                // 1. Ordenar
                Arrays.sort(jd);
                Arrays.sort(ja);
            
	    	// 2. Emparejar (de mayor a menor)
                for(i=njd-1, j=nja-1; i>=0 && j>=0; i--, j--) 
                    if(ja[j]>jd[i]) data[TD]--;
                    else data[TA]--;
            }
            System.out.println(data[TD] + " " + data[TA]);
        }
    }
}
