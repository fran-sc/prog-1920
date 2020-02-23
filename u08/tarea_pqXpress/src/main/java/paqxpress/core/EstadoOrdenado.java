package paqxpress.core;

public class EstadoOrdenado implements EstadoPq {
    public void avanza(Paquete pq) {
        pq.setEstado(new EstadoEnProceso());
    }

    public String informaEstado() {
        return "Envío ordenado pero el paquete aún no ha sido recogido";
    }
}