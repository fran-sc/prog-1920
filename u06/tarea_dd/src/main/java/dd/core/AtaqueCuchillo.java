package dd.core;

import java.util.Random;

public class AtaqueCuchillo implements Ataque {
    private static final int ATAQUE = 75;

    @Override
    public int lanzaAtaque(Personaje enemigo) {
        Random r = new Random();
                
        int res = (r.nextInt(4)==0)?0:(-1)*Math.round(r.nextFloat()*ATAQUE);
        if(res<0) {
            enemigo.updateSalud(res);
            System.out.println("Ataque con cuchillo (" + res + ")");
        }
        else
            System.out.println("Ataque con cuchillo (falla)");
            
        return res;
    }
}
