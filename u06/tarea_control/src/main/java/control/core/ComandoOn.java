package control.core;

public class ComandoOn extends Comando {
    public ComandoOn(Dispositivo dispositivo) {
        super(dispositivo);
    }

    public void execute() { 
        this.getDispositivo().on();
    }    
}