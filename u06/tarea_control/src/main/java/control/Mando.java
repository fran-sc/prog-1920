package control;

import java.util.HashMap;

public class Mando {
    private HashMap<Integer, IComm> botonesOn;
    private HashMap<Integer, IComm> botonesOff;

    public Mando() {
        botonesOn = new HashMap<Integer, IComm>();
        botonesOff = new HashMap<Integer, IComm>();
    }

    public void setComando(int slot, Dispositivo dispositivo) {
        botonesOn.put(slot, new ComandoOn(dispositivo));
        botonesOff.put(slot, new ComandoOff(dispositivo));
    }

    public void presBotonOn(int slot) {
        botonesOn.get(slot).execute();
    }

    public void presBotonOff(int slot) {
        botonesOff.get(slot).execute();
    }

    public String toString() {
        String s = "";

        s += "#--- M A N D O ";
        for(Object obj: botonesOn.keySet()) {
            s += "\nslot: " + obj + " --> " + ((ComandoOn)botonesOn.get(obj)).getDispositivo();
        }

        return s;
    }
}