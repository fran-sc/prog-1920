package ciph;

import java.util.Arrays;

interface ICriptoSim {
    String cifra(String msg, String key);
    String descifra(String msg, String key);
}

public class CriptoTabla implements ICriptoSim {

    private String[][] tablaCifrado;

    private String[] abc = { "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R",
            "S", "T", "U", "V", "W", "X", "Y", "Z" };

    public CriptoTabla() {
        String[][] tablaGenerar = new String[26][26];
        int contador = 0;

        for (int i = 0; i < 26; i++) {
            for (int j = 0; j < 26; j++) {

                tablaGenerar[i][j] = abc[contador];
                if (contador == 25) {
                    contador = 0;
                } else {
                    contador++;
                }
            }
            contador++;
        }

        this.tablaCifrado = tablaGenerar;
    }

    public CriptoTabla(String[][] tablaCifrado) {
        if (tablaCifrado.length != 26 || tablaCifrado[0].length != 26) {
            throw new IllegalArgumentException("dimensiones no válidas");
        }

        this.tablaCifrado = tablaCifrado;
    }

    public CriptoTabla(int desplazamiento) {
        if (desplazamiento < 0 || desplazamiento > 26) {
            throw new IllegalArgumentException("desplazamiento no válido");
        }

        int contador;
        String[][] tablaGenerar = new String[26][26];
        if (desplazamiento == 26) {
            contador = 0;
        }
        contador = desplazamiento;

        for (int i = 0; i < 26; i++) {
            for (int j = 0; j < 26; j++) {

                tablaGenerar[i][j] = abc[contador];
                if (contador == 25) {
                    contador = 0;
                } else {
                    contador++;
                }
            }
            contador++;
        }

        this.tablaCifrado = tablaGenerar;
    }

    public String[][] getTablaCifrado() {
        return this.tablaCifrado;
    }

    public String cifra(String mensaje, String clave) {
        String mCifrado = "";
        String[][] tabla = getTablaCifrado();

        mensaje.replaceAll("[^A-Za-z]", "");
        mensaje = mensaje.toUpperCase();

        clave.replaceAll("[^A-Za-z]", "");
        clave = clave.toUpperCase();

        char[] aClave = clave.toCharArray();

        char[] aMensaje = mensaje.toCharArray();

        int[] nClave = new int[aClave.length];
        int[] nMensaje = new int[aMensaje.length];

        int[] nClave2 = new int[aMensaje.length];

        for (int i = 0; i < aMensaje.length; i++) {
            for (int j = 0; j < abc.length; j++) {
                if (String.valueOf(aMensaje[i]).equals(abc[j])) {
                    nMensaje[i] = j;
                }
            }
        }

        for (int i = 0; i < aClave.length; i++) {
            for (int j = 0; j < abc.length; j++) {
                if (String.valueOf(aClave[i]).equals(abc[j])) {
                    nClave[i] = j;
                }
            }
        }

        for (int i = 0; i < nClave2.length; i++) {
            if (i == nClave.length) {

            }
        }

        for (int i = 0; i < nMensaje.length; i++) {

            mCifrado += tabla[i][i];
        }

        return mCifrado;
    }

    public String descifra(String mensaje, String clave) {
        return "";
    }
}