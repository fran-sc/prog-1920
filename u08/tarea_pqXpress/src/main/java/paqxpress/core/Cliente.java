package paqxpress.core;

public class Cliente {
    private String id;
    private String nombre;

    public Cliente(String id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    public String getId() { return this.id; }
    public String getNombre() { return this.nombre; }
}