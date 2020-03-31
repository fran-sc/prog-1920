package control.core;

public class ComandoOff extends Comando {
    public ComandoOff(Dispositivo dispositivo) {
        super(dispositivo);
    }

    @Override
    public void execute() { 
        System.out.println("Desactivando el dispositivo " + this.getDispositivo() + "...");
        this.getDispositivo().off();
    }    
}