package control.core;

public class Mando {
    private static final int DEF_NSLOTS = 5;
    private IComm[][] slots;
    private int nslots;

    public Mando(int nslots) {
        if(nslots<DEF_NSLOTS) nslots = DEF_NSLOTS;

        slots = new IComm[nslots][2]; 
        this.nslots = nslots;
    }

    public void setComando(int slot, Dispositivo dispositivo) {
        if(slot>=0 && slot<this.nslots) {
            this.slots[slot-1][0] = new ComandoOn(dispositivo);
            this.slots[slot-1][1] = new ComandoOff(dispositivo);

            System.out.println("---> Dispositivo añadido");
        }
    }

    public void removeDispositivo(int slot) {
        if(slot>=0 && slot<this.nslots && this.slots[slot-1][0]!=null) {
            this.slots[slot-1][0] = null;
            this.slots[slot-1][1] = null;
        }
    }

    public void presBotonOn(int slot) {
        if(slot>=0 && slot<this.nslots && this.slots[slot-1][0]!=null) 
            this.slots[slot-1][0].execute();
        else
            System.out.println("No hay ningún dipositivo asociado al slot " + slot);            
    }

    public void presBotonOff(int slot) {
        if(slot>=0 && slot<this.nslots && this.slots[slot-1][1]!=null) 
            this.slots[slot-1][1].execute();
        else
            System.out.println("No hay ningún dipositivo asociado al slot " + slot);            
    }

    @Override
    public String toString() {
        Dispositivo disp;
        String s = "\n### M A N D O ###\n";

        for(int i=0; i<this.nslots; i++) {
            s += "slot " + (i+1) + " --> ";

            if(slots[i][0]!=null) {
                disp = ((Comando)this.slots[i][0]).getDispositivo();
                s += disp + " - " + (disp.getEstado()?"on":"off") + "\n";
            }
            else s += "---\n";
        }

        return s;
    }
}