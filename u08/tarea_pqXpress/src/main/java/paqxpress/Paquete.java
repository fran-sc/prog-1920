import paqxpress;

public class Paquete {
    private static int _id = 1000;
    private int id;
    private Cliente cliente;
    private EstadoPq estado;
    private String destino;

    public Paquete(Cliente cliente, String destino) {
        this.id = ++Paquete._id;
        this.cliente = cliente;
        this.estado = new EstadoEnProceso();
        this.destino = destino;
    }

    public Cliente getCliente() { return this.cliente; }

    public int getId() { return this.id; }

    public EstadoPq getEstado() { return this.estado; }
    
    public void cambiaEstado() { this.estado.avanza(this); }

    public String informaEstado() { return this.estado.informaEstado(); }
}