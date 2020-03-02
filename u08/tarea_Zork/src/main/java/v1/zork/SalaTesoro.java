package zork;

public class SalaTesoro {
    public SalaTesoro(String descripcion) {
        super(descripcion);
    }

    @Override
    public void entra(Jugador player) {
        player.setSala(this);
        player.setTesoro(true);
        return false;
    }    
}