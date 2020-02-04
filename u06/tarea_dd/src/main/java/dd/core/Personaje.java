package dd.core;

public abstract class Personaje {
    private String nombre;
    private int salud;
    Ataque ataque;

    public Personaje(String nombre) { this.nombre = nombre; }
    public void setAtaque(Ataque ataque) { this.setAtaque = ataque; }
    public abstract int ataque(Personaje enemigo);

    @Override
    public String toString() { return "[" + this.nombre + ": " + this.salud + "]"; }
}
