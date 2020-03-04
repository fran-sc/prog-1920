package juegos.recursos;

enum Palo { OROS, COPAS, ESPADAS, BASTOS };

public class Carta {
    protected static final int MIN_VAL = 1;
    protected static final int MAX_VAL = 12;

    private Palo palo;
    private int valor;

    public Carta(Palo palo, int valor) {
        this.palo = palo;
        this.valor = valor;
    }

    public int getValor() { return this.valor; }
    public Palo getPalo() { return this.palo; }
    
    public String toString() { 
        String s = "";

        switch(this.valor) {
            case 10:
                s = "S";
                break;
            case 11:
                s = "C";
                break;
            case 12:
                s = "R";
                break;
            default:
                s = String.valueOf(this.valor);
        }

        return "[" + this.palo + ": " + s + "]"; 
    }
}
