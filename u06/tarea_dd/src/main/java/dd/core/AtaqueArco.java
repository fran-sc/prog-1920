package dd.core;

import java.util.Random;

public class AtaqueArco implements Ataque {
    private static final int ATAQUE = 100;

    @Override
    public int lanzaAtaque(Personaje enemigo) {
        Random r = new Random();
                
        int res = (r.nextInt(4)==0)?0:(-1)*Math.round(r.nextFloat()*ATAQUE);
        if(res<0) {
            enemigo.updateSalud(res);
            System.out.println("Ataque con arco (" + res + ")");
        }
        else
            System.out.println("Ataque con arco (falla)");
            
        return res;
    }
}
