import java.util.Scanner;

public class E1 {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        
        int pa, pv, pd, mov;
        while(true) {
            pa = cin.nextInt(); // planta ascensor
            if(pa<0)
                break;
                
            mov = 0;            // recorrido
            while(true) {
                pv = cin.nextInt(); // planta vecino
                if(pv<0)
                    break;
                pd = cin.nextInt(); // planta destino
                mov += Math.abs(pv-pa) + Math.abs(pd-pv);
                pa = pd; 
            }
            System.out.println(mov);
        }
    }
}
    
