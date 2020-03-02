package control;

public abstract class Comando implements IComm {
    private Dispositivo dispositivo;

    public Comando(Dispositivo dispositivo) {
        this.dispositivo = dispositivo;
    }

    public Dispositivo getDispositivo() { return this.dispositivo; }

    public abstract void execute();
}