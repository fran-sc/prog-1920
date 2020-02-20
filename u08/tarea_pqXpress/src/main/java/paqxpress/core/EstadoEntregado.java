import paqxpress.core;

public class EstadoEntregado implements EstadoPq {
    public void avanza(Paquete pq) {
        System.out.println(this.informaEstado());
    }

    public String informaEstado() {
        return "El paquete ya ha sido entregado";
    }
}