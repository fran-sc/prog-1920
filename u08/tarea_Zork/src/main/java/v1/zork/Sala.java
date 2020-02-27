package zork;

public abstract class Sala {
    private String descripcion;
    private Sala[] puertas;

    public Sala(String descripcion) {
        this.descripcion = descripcion;
        puertas = new Sala[4];
    }

    public Salas[] getPuertas() { return this.puertas; }
    
    public String getDescripcion() { return this.descripcion; }

    public void setPuerta(Dir dir, Sala sala) { this.puertas[dir.id] = sala; }

    public Sala boolean avanza(Dir dir) { return puertas[dir.id]; }