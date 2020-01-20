package juegos.naipes.barajas;

import java.util.Random;

class BarajaEsp {
    private static final int MIN_VAL = 1;
    private static final int MAX_VAL = 12;
    private static final int MAX_CARTAS = 40;

    private CartaEsp[] cartas;
    private int siguiente;

    BarajaEsp() {
        cartas = new CartaEsp[MAX_CARTAS];

        iniciaBaraja();
    }

    private void iniciaBaraja() {
        this.siguiente = 0;

        // Añadimos las cartas a la baraja
        System.out.println("Creando nueva baraja...");
        int i=0;
        for(Palo palo:Palo.values()) {
            System.out.print("\n" + palo + ": ");
            for(int j=MIN_VAL; j<=MAX_VAL; j++) {
                System.out.print(j + " ");
                if(j!=7&&j!=8) cartas[i++] = new CartaEsp(palo, j);
            }
        }               
        
        // Barajamos
        baraja();
    }

    public CartaEsp[] daCartas(int n) {
        if((this.siguiente + n)>MAX_CARTAS) return null; // No hay suficientes cartas en el mazo
        
        CartaEsp[] cartas = new CartaEsp[n];
        for(int i=0; i<n; i++)
            cartas[i] = this.cartas[siguiente++];
        return cartas;
    }

    public CartaEsp[] cartasEnMazo() {
        if(siguiente>MAX_CARTAS) return null; // No quedan cartas en el mazo

        CartaEsp[] cartas = new CartaEsp[MAX_CARTAS - siguiente];
        for(int i=siguiente, j=0; i<MAX_CARTAS; i++, j++)
            cartas[j] = this.cartas[i];
        return cartas;        
    }

    public CartaEsp[] cartasEnMesa() {
        if(siguiente==0) return null; // No salió aún ninguna carta

        CartaEsp[] cartas = new CartaEsp[siguiente];
        for(int i=0; i<siguiente; i++)
            cartas[i] = this.cartas[i];
        return cartas;        
    }   
    
    public void reinicia() {
        iniciaBaraja();
    }

    public void baraja() {
        Random r = new Random();

        for(int i=MAX_CARTAS-1; i>=siguiente+2; i--) {
            int p = r.nextInt(i);
            CartaEsp c = this.cartas[i];
            this.cartas[i] = this.cartas[p];
            this.cartas[p] = c;
        }
    }
}