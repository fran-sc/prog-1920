package control.core;

public abstract class Comando implements IComm {
    private Dispositivo dispositivo;

    public Comando(Dispositivo dispositivo) {
        this.dispositivo = dispositivo;
    }

    public Dispositivo getDispositivo() { return this.dispositivo; }

    // No hace falta añadir el método execute() del interfaz. Si se hace, debe ser abstracto
    //public abstract void execute();
}