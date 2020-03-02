package zork;

public class Jugador {
    private String nombre;
    private Sala sala;
    private boolean vivo;
    private boolean tesoro;

    public Jugador(String nombre) { 
        this.nombre = nombre; 
        this.vivo = true;
    }

    public Sala getSala() { return this.sala; }

    public void setVivo(boolean vivo) { thus.vivo = vivo; }

    public void setTesoro(boolean tesoro) { thus.tesoro = tesoro; }
}