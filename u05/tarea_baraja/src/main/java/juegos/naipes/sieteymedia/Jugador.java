package juegos.naipes.sieteymedia;

import juegos.naipes.barajas.CartaEsp;

public class Jugador {
    private static final int MONEDAS_INI = 100;
    private static final int MAX_CARTAS = 15;
    private String nombre;
    private CartasEsp[] cartas;
    private int monedas;
    private int numCartas;

    Jugador(String nombre) {
        this.nombre = nombre;
        this.monedas = MONEDAS_INI;
        cartas = new CartasEsp[MAX_CARTAS];
        numCartas = 0;
    }

    public int getMonedas() { return this.monedas; }
    
    public void actualizaMonedas(int monedas) { this.monedas += monedas; }

    public double getValorJugada() {
        double ret = 0;
        if(numCartas>0)
            for(int i=0; i<numCartas; i++) {
                int val = cartas[i].getValor();
                ret += (val > 7)?0.5:1.0;
            }
        return ret;
    }

    public void reinicia() { numCartas = 0; }

    public void muestraCartas() {
        if(numCartas>0) {
            for(int i=0; i<numCartas; i++)
                System.out.print(cartas[i]);
            System.out.println(" --> " + getValorJugada());
        }
    }
}