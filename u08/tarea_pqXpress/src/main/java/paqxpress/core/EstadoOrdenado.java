import paqxpress.core;

public class EstadoOrdenado implements EstadoPq {
    public void avanza(Paquete pq) {
        pq.setEstado(new EstadoEnProceso());
    }

    public String informaEstado() {
        return "Paquete ordenado pero aún no ha sido recogido";
    }
}