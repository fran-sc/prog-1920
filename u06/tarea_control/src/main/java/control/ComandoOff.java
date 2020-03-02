package control;

public class ComandoOff extends Comando {
    public ComandoOff(Dispositivo dispositivo) {
        super(dispositivo);
    }

    public void execute() { 
        this.getDispositivo().off();
    }    
}