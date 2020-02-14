import java.util.Scanner;

public class R381 {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        int nump, period[], secuen[], i, dias;
		boolean encontrado;

		nump = cin.nextInt(); // nº planetas    
		while(nump != 0) {
			period = new int[nump]; // periodos de los planetas
			for(i=0; i<nump; i++) period[i] = cin.nextInt();

			secuen = new int[nump];
			dias = 0;
			
			while(checkEquals(secuen)) {
				dias++;
				next(secuen, period, dias);
			}

			while(!checkEquals(secuen)) {
				dias++;
				next(secuen, period, dias);
			}

			System.out.println(dias);
			nump = cin.nextInt(); // nº planetas    
		}
	}
	
	private static boolean checkEquals(int[] a) {
		for(int i=1; i<a.length; i++) { if(a[i]!=a[i-1]) return false; }
		return true;
	}

	private static void next(int[] sq, int[] p, int gen) {
		for(int i=0; i<p.length; i++) { sq[i] = gen % p[i]; }
	}
}
