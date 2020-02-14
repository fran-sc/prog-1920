// Versión optimizada
// Se basa en que las secuencias se volverán a repetir en el m.c.m de los periodos!! 
// El cálculo del m.c.m. se puede realizar a partir del m.c.d  --> mcm(a,b) = (a*b)/mcd(a,b)
// Para tres o más números... --> mcm(a,b,c) = mcm(mcm(a,b),c)

import java.util.Scanner;

public class R381o2 {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        int nump, period[], res, i;

		nump = cin.nextInt(); // nº planetas    
		while(nump != 0) {
			// periodos de los planetas
			period = new int[nump]; 
			for(i=0; i<nump; i++) period[i] = cin.nextInt();

			// cálculo del MCM de los periodos
			res = period[0];
			for(i=1; i<nump; i++) res = res*(period[i]/mcd(res, period[i]));

			// mostramos el resultado
			System.out.println(res);

			nump = cin.nextInt(); // nº planetas    
		}
	}

	private static int mcd(int a, int b) {
		int t;
		while(b>0) {
			t = b;
			b = a%b;
			a = t;
		}
		return a;
	}
}
