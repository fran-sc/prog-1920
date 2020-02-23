package paqxpress.core;

public class EstadoEnProceso implements EstadoPq {
    public void avanza(Paquete pq) {
        pq.setEstado(new EstadoEnviado());
    }

    public String informaEstado() {
        return "Paquete recogido y en proceso de envío";
    }
}