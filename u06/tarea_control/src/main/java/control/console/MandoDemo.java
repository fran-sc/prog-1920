package control.console;

import control.core.*;

public class MandoDemo {
    public static void main(String[] args) {
        Mando mando = new Mando();

        mando.setComando(1, new Dispositivo(1, "Hilo musical"));
        mando.setComando(2, new Dispositivo(2, "Proyector"));
        mando.setComando(3, new Dispositivo(5, "Aire acondicionado"));
        mando.setComando(4, new Dispositivo(8, "Iluminación escenario"));

        System.out.println(mando);

        mando.presBotonOn(2);
        mando.presBotonOn(4);

        mando.presBotonOn(2);
        mando.presBotonOn(4);

        mando.presBotonOff(2);
        mando.presBotonOff(4);
    }
}