package paqxpress.core;

public class EstadoEntregado implements EstadoPq {
    public void avanza(Paquete pq) { /* No hay más estados */ }

    public String informaEstado() {
        return "El paquete ya ha sido entregado";
    }
}