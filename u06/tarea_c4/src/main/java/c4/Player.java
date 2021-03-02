package c4;

/**
 * Clase base abstracta para los jugadores.
 * */
public abstract class Player {
    protected int id;
    private String name;

    public Player(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return this.id;
    }
    public String getName() {
        return this.name;
    }
    public String toString() {
        return this.id + ":" + this.name;
    }

    /**
     * Devuelve la columna donde se colocará la nueva pieza.
     * Debe validar que dicha posición es válida
     * */
    public abstract int nextMove(Board board);
}
