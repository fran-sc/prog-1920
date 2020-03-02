package zork;

public abstract class Sala {
    private String descripcion;
    private Sala[] puertas;

    public Sala(String descripcion) {
        this.descripcion = descripcion;
        puertas = new Sala[4];
    }

    public String getDescripcion() { return this.descripcion; }

    public Sala getSalaEnDir(Dir dir) { return this.puertas[dir.id]; }
    
    public Salas[] getPuertas() { return this.puertas; }
    
    public void setPuerta(Dir dir, Sala sala) { this.puertas[dir.id] = sala; }

    public abstract boolean entra(Jugador player);
}