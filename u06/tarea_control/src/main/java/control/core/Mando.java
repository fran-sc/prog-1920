package control.core;

import java.util.HashMap;

public class Mando {
    private static final int DEF_NSLOTS = 5;

    private HashMap<Integer, IComm[]> slots;
    private int nslots;

    public Mando(int nslots) {
        if(nslots<DEF_NSLOTS) nslots = DEF_NSLOTS;

        slots = new HashMap<Integer, IComm[]>(nslots); 

        this.nslots = nslots;
    }

    public void setComando(int slot, Dispositivo dispositivo) {
        if(slot>=0 && slot<this.nslots) {
            slots.put(slot, new IComm[] { new ComandoOn(dispositivo), new ComandoOff(dispositivo) });

            System.out.println("---> Dispositivo añadido");
        }
    }

    public void presBotonOn(int slot) {
        if(slot>=0 && slot<this.nslots && this.slots.get(slot)!=null) 
            slots.get(slot)[0].execute();
        else
            System.out.println("No hay ningún dipositivo asociado al slot " + slot);                        
    }

    public void presBotonOff(int slot) {
        if(slot>=0 && slot<this.nslots && this.slots.get(slot)!=null) 
            slots.get(slot)[1].execute();
        else
            System.out.println("No hay ningún dipositivo asociado al slot " + slot);                        
    }

    public void removeDispositivo(int slot) {
        if(slot>=0 && slot<this.nslots && this.slots.get(slot)!=null) {
            Dispositivo disp = ((Comando)this.slots.get(slot)[0]).getDispositivo();
            
            this.presBotonOff(slot);
            this.slots.remove(slot);

            System.out.println("Eliminando el dispositivo " + disp + " del slot " + slot);
        }
        else
            System.out.println("No hay ningún dipositivo asociado al slot " + slot);                                    
    }
    
    @Override
    public String toString() {
        Dispositivo disp;
        String s = "\n### M A N D O ###\n";

        for(int i=1; i<=this.nslots; i++) {
            s += "slot " + i + " --> ";

            if(this.slots.get(i)!= null) {
                disp = ((Comando)this.slots.get(i)[0]).getDispositivo();
                s += disp + " - " + (disp.getEstado()?"on":"off") + "\n";
            }
            else s += "---\n";
        }

        return s;
    }
}