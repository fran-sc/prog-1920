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
	    encontrado = true;
	    while(true) {
		dias++;
	        for(i=0; i<nump; i++) {
		    secuen[i]++;
		    if(secuen[i]==period[i]) secuen[i]=0;
		    if(i>0 && secuen[i]!=secuen[i-1]) encontrado = false;
		}
		if(i>0 && encontrado) break;
 	    }
	    System.out.println(dias);
	    nump = cin.nextInt(); // nº planetas    
	}
    }
}
