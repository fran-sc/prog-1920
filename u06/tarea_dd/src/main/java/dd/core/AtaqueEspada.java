package dd.core;

import java.util.Random;

public class AtaqueEspada implements Ataque {
    private static final int ATAQUE = 150;

    @Override
    public int lanzaAtaque(Personaje enemigo) {
        Random r = new Random();

        int res = (r.nextInt(4)==0)?0:(-1)*Math.round(r.nextFloat()*ATAQUE);
        if(res<0) {
            enemigo.updateSalud(res);
            System.out.println("Ataque con espada (" + res + ")");
        }
        else
            System.out.println("Ataque con espada (falla)");
            
        return res;
    }
}
