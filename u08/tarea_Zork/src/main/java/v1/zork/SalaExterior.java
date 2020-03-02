package zork;

public class SalaExterior extends Sala {
    public SalaExterior(String descripcion) {
        super(descripcion);
    }

    @Override
    public boolean entra(Jugador player) {
        player.setSala(this);
        return true;
    }    
}
