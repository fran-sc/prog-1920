import java.util.Arrays;
import java.util.Scanner;

/**
 * Risk (versión para distancia).
 *
 * La entrada de casos finaliza con una línea de 0's para TD, TA, DD, DA, NO.
 * */
public class Risk_d {
    private final static int TD = 0; // Tropas defensa
    private final static int TA = 1; // Tropas ataque
    private final static int DD = 2; // Dados defensa
    private final static int DA = 3; // Dados ataque
    private final static int NO = 4; // Num oleadas

    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        int[] data = new int[5];

        while (true) {
            data[TD] = cin.nextInt();
            data[TA] = cin.nextInt();
            data[DD] = cin.nextInt();
            data[DA] = cin.nextInt();
            data[NO] = cin.nextInt();

            int sum = 0;
            for (int i = 0; i < data.length; i++) sum += data[i];
            if (sum == 0)
                break; // Fin de las entradas

            // Mientras haya oleadas...
            while (data[NO]-- > 0) {
                // Jugadas de la defensa
                int njd = Math.min(data[TD], data[DD]);
                int[] jd = new int[njd];

                // Jugadas del ataque
                int nja = Math.min(data[TA], data[DA]);
                int[] ja = new int[nja];

                // Tiradas defensa
                for (int i = 0; i < njd; i++) jd[i] = cin.nextInt();

                // Tiradas ataque
                for (int i = 0; i < nja; i++) ja[i] = cin.nextInt();

                // Evaluar las jugadas
                // 1. Ordenar
                Arrays.sort(jd);
                Arrays.sort(ja);

                // 2. Emparejar (de mayor a menor)
                for (int i = njd - 1, j = nja - 1; i >= 0 && j >= 0; i--, j--)
                    if (ja[j] > jd[i])
                        data[TD]--;
                    else
                        data[TA]--;
            }
            System.out.println(data[TD] + " " + data[TA]);
        }
    }
}
