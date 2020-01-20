package juegos.sieteymedia;

import juegos.recursos.Carta;

class Jugador {
    private static final int DEF_CREDITO = 100;
    private static final int MAX_CARTAS = 15;

    private String nombre;
    private int credito;
    private Carta[] cartas;
    private int numCartas = 0;

    Jugador(String nombre) { this(nombre, DEF_CREDITO); }

    Jugador(String nombre, int credito) { 
        this.nombre = nombre; 
        this.credito = credito;
    }
    
    public String getNombre() { return this.nombre; }
    
    public int getCredito() { return this.credito; }

    public int getNumCartas() { return this.numCartas; }
    
    public int actualizaCredito(int cantidad) {
        this.credito += cantidad;
        return this.credito;
    }
    
    public void nuevaCarta(Carta carta) { this.cartas[this.numCartas++] = carta; }

    public Carta[] getCartas() {
        if(this.numCartas == 0) return null;
        
        Carta[] cartas = new Carta[this.numCartas];
        
        for(int i=0; i<this.numCartas; i++)
            cartas[i] = this.cartas[i];
        
        return cartas;
    }

    public void reiniciaMano() {
        for(int i=0; i<MAX_CARTAS; i++) this.cartas[i] = null;
        this.numCartas = 0;
    }
}