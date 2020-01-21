package juegos.recursos;

enum Palo { OROS, COPAS, ESPADAS, BASTOS };

public class Carta {
    protected static final int MIN_VAL = 1;
    protected static final int MAX_VAL = 12;

    Palo palo;
    int valor;

    public Carta(Palo palo, int valor) {
        this.palo = palo;
        this.valor = valor;
    }

    public int getValor() { return this.valor; }
    public Palo getPalo() { return this.palo; }
    
    public String toString() { 
        char c;
        if(this.valor == 10) c = 'S';
        else if(this.valor == 11) c = 'C';
        else if(this.valor == 12) c = 'R';
        else c = String.valueOf(this.valor).charAt(0);
        return "[" + this.palo + ": " + c + "]"; 
    }
}