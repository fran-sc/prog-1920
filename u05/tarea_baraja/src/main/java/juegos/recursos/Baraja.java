package juegos.recursos;

import java.util.Random;

public class Baraja {
    private static final int MAX_CARTAS = 40;

    Carta[] cartas;
    int siguiente;
    
    public Baraja() {
        cartas = new Carta[MAX_CARTAS];
    
        iniciaBaraja();
    }

    private void iniciaBaraja() {
        this.siguiente = 0;

        // Añadimos las cartas a la baraja
        int i=0;
        for(Palo palo:Palo.values()) {
            for(int j=Carta.MIN_VAL; j<=Carta.MAX_VAL; j++) {
                if(j!=7 && j!=8) cartas[i++] = new Carta(palo, j);
            }
        }               
        
        // Barajamos
        baraja();
    }    

    public void baraja() {
        Random r = new Random();

        for(int i=MAX_CARTAS-1; i>=siguiente+2; i--) {
            int p = r.nextInt(i);
            Carta c = this.cartas[i];
            this.cartas[i] = this.cartas[p];
            this.cartas[p] = c;
        }
    }

    public Carta[] daCartas(int n) {
        if((this.siguiente + n)>MAX_CARTAS) return null; // No hay suficientes cartas en el mazo
        
        Carta[] cartas = new Carta[n];
        for(int i=0; i<n; i++)
            cartas[i] = this.cartas[siguiente++];
        return cartas;
    }

    public Carta[] cartasMazo() {
        if(siguiente>MAX_CARTAS) return null; // No quedan cartas en el mazo

        Carta[] cartas = new Carta[MAX_CARTAS - siguiente];
        for(int i=siguiente, j=0; i<MAX_CARTAS; i++, j++)
            cartas[j] = this.cartas[i];
        return cartas;        
    }

    public Carta[] cartasDadas() {
        if(siguiente==0) return null; // No salió aún ninguna carta

        Carta[] cartas = new Carta[siguiente];
        for(int i=0; i<siguiente; i++)
            cartas[i] = this.cartas[i];
        return cartas;        
    }   
    
    public void reinicia() {
        iniciaBaraja();
    }    
}