package control.core;

public class ComandoOn extends Comando {
    public ComandoOn(Dispositivo dispositivo) {
        super(dispositivo);
    }

    @Override
    public void execute() { 
        System.out.println("Activando el dispositivo " + this.getDispositivo() + "...");
        this.getDispositivo().on();
    }    
}