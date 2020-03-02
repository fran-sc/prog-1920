package control;

public class Dispositivo {
    private int releId;
    private String nombre;
    private boolean estado;

    public Dispositivo(int releId, String nombre) {
        this.releId = releId;
        this.nombre = nombre;
    }

    public void on() {
        if(!this.estado) {
            System.out.println("Activando " + this.nombre + " (relé: " + this.releId + ")");
            estado = true;
        }
        else
            System.out.println("El dispositivo " + this.nombre + " (relé: " + this.releId + ") ya estába activado");
    }

    public void off() {
        if(this.estado) {
            System.out.println("Desactivando " + this.nombre + " (relé: " + this.releId + ")");
            estado = false;
        }
        else
            System.out.println("El dispositivo " + this.nombre + " (relé: " + this.releId + ") ya estába desactivado");        
    } 
    
    public String toString() { return "[" + this.releId + ": " + this.nombre + "]"; }
}