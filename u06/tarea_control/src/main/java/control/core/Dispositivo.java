package control.core;

public class Dispositivo {
    private int releId;
    private String nombre;
    private boolean estado;

    public Dispositivo(int releId, String nombre) {
        this.releId = releId;
        this.nombre = nombre;
    }

    public boolean getEstado() { return this.estado; }

    public void on() {
        if(!this.estado)
            System.out.println("El dispositivo " + this + " ha sido activado");
        else
            System.out.println("El dispositivo " + this + " ya estaba activado");

        estado = true;        
    }

    public void off() {
        if(this.estado)             
            System.out.println("El dispositivo " + this + " ha sido desactivado");
        else
            System.out.println("El dispositivo " + this + " ya estaba desactivado");

        estado = false;        
    } 
    
    @Override
    public String toString() { return "[" + this.releId + ": " + this.nombre + "]"; }
}