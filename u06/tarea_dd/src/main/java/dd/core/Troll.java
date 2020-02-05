package dd.core;

import java.util.Random;

public class Troll extends Personaje {
    private final int MIN_SALUD = 500;
    private final int MAX_SALUD = 1000;
    private final int MAX_ATAQUES = 1;

    public Troll(String nombre) {
	    super(nombre);
        
        Random r = new Random();
        this.setSalud(r.nextInt(MAX_SALUD-MIN_SALUD+1)+MIN_SALUD);
    }

    @Override
    public int ataca(Personaje enemigo) {
	    int res = 0;
        if(this.getAtaque() != null)
	    for(int i=0; i<MAX_ATAQUES; i++) 
	        res += this.getAtaque().lanzaAtaque(enemigo);	
	    return res;
    }
}
