import paqxpress;

public class EstadoEnProceso implements EstadoPq {
    public void avanza(Paquete pq) {
        pq.setEstado(new EstadoEnviado());
    }

    public String informaEstado() {
        return "Paquete recogido en proceso de envío";
    }
}