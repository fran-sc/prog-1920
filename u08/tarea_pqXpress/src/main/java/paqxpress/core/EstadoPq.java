package paqxpress.core;

public interface EstadoPq {
    void avanza(Paquete pq);
    String informaEstado();
}