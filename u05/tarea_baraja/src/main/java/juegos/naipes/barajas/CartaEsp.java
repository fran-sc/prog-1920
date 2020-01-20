package juegos.naipes.barajas;

enum Palo { OROS, COPAS, ESPADAS, BASTOS };

class CartaEsp {
    Palo palo;
    int valor;

    CartaEsp(Palo palo, int valor) {
        this.palo = palo;
        this.valor = valor;
    }

    public int getValor() { return this.valor; }
    public Palo getPalo() { return this.palo; }
    
    public String toString() { return "[" + this.palo + ": " + this.valor + "]"; }
}