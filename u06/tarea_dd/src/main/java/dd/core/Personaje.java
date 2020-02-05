package dd.core;

public abstract class Personaje {
    private String nombre;
    private int salud;
    Ataque ataque;

    public Personaje(String nombre) { this.nombre = nombre; }
    
    public int getSalud() { return this.salud; }
    public void setSalud(int salud) { this.salud = salud; }
    public void setAtaque(Ataque ataque) { this.ataque = ataque; }
    public Ataque getAtaque() { return this.ataque; }

    public void updateSalud(int value) { this.salud += value; }

    public abstract int ataca(Personaje enemigo);
    
    @Override
    public String toString() { return "[" + this.nombre + ": " + this.salud + "]"; }
}
