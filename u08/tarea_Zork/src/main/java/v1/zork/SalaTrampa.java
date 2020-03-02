package zork;

public class SalaTrampa extends Sala {
    public SalaTrampa(String descripcion) {
        super(descripcion);
    }

    @Override
    public boolean entra(Jugador player) {
        player.setSala(this);
        player.setVivo(false);
        return true;
    }    
}
