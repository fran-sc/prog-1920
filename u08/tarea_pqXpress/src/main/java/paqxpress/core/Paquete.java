package paqxpress.core;

import java.time.LocalDateTime;

public class Paquete {
    private static int _id = 1000;
    private final int id;
    private final Cliente cliente;
    private EstadoPq estado;
    private String destino;
    private final LocalDateTime timestamp;

    public Paquete(Cliente cliente, String destino) {
        this.id = ++Paquete._id;
        this.cliente = cliente;
        this.estado = new EstadoOrdenado();
        this.destino = destino;
        this.timestamp = LocalDateTime.now();
    }

    public Cliente getCliente() { return this.cliente; }

    public int getId() { return this.id; }

    public LocalDateTime getTimestamp() { return this.timestamp; }

    public String getDestino() { return this.destino; }

    public EstadoPq getEstado() { return this.estado; }
    public void setEstado(EstadoPq estado) { this.estado = estado; }
    public void cambiaEstado() { this.estado.avanza(this); }
    public String informaEstado() { return this.estado.informaEstado(); }
}