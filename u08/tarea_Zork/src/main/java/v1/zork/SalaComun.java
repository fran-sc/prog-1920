package zork;

public class SalaComun extends Sala {
    public SalaComun(String descripcion) { super(descripcion); }

    @Override
    public boolean entra(Jugador player) {
        player.setSala(this);
        return false;
    }    
}
