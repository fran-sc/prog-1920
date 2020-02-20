import paqxpress;

public class EstadoEnReparto implements EstadoPq {
    public void avanza(Paquete pq) {
        pq.setEstado(new EstadoEntregado());
    }

    public String informaEstado() {
        return "Paquete en reparto";
    }
}