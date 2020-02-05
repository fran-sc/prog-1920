package dd.core;

public class Rey extends Personaje {
    private final int SALUD = 2000;
    private final int MAX_ATAQUES = 3;

    public Rey(String nombre) {
	    super(nombre);
	    this.setSalud(SALUD);
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
