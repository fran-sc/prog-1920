import paqxpress.core;

public class EstadoEnviado implements EstadoPq {
    public void avanza(Paquete pq) {
        pq.setEstado(new EstadoEnReparto());
    }

    public String informaEstado() {
        return "Paquete enviado";
    }
}