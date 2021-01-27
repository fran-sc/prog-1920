package ciph;

import java.util.Arrays;

interface ICriptoSim {
    String cifra(String msg, String key);
    String descifra(String msg, String key);
}

class CriptoTablaTest {
    public static char[][] createTable(int n) {
        char[][] data = new char[26][26];
        for (int i = 0; i < 26; ++i) {
            for (int j = 0, k = n + i; j < 26; ++j, ++k) {
                if (('A' + k) > 'Z')
                    k -= 26;
                data[i][j] = (char) ('A' + k);
            }
        }
        return data;
    }
}

public class CriptoTabla implements ICriptoSim {
    private static final int SIZE = 26;

    private char[][] ciphTable;

    public CriptoTabla() { this(0); }

    public CriptoTabla(char[][] data) throws IllegalArgumentException {
        if(data.length!=SIZE || data[0].length!=SIZE)
            throw new IllegalArgumentException("argument dimensions not valid");

        this.ciphTable = new char[SIZE][];

        for(int i=0; i<SIZE; ++i) this.ciphTable[i] = Arrays.copyOf(data[i], SIZE);
    }

    public CriptoTabla(int n) throws IllegalArgumentException {
        if(n<0 || n>SIZE)
            throw new IllegalArgumentException("argument value out of range");

        this.ciphTable = new char[SIZE][SIZE];
        
        for(int i=0; i<SIZE; ++i) {
            for(int j=0, k=n+i; j<SIZE; ++j, ++k) {
                if(('A' + k)>'Z') k -= SIZE;
                this.ciphTable[i][j] = (char)('A' + k);
            }
        }
    }

    public String cifra(String msg, String key) {
        String crypto = "", cmsg = "";
        
        // Preprocess message
        msg = msg.toUpperCase();
        for(int i=0; i<msg.length(); i++) {
            char c = msg.charAt(i);
            if(c>='A' && c<='Z')
                cmsg += c;
        }       
            
        // cypher
        key = key.toUpperCase();
        for(int i=0, j=0; i< cmsg.length(); ++i, j++) {
            if(j==key.length()) j=0;
            crypto += this.ciphTable[key.charAt(j) - 'A'][cmsg.charAt(i) - 'A'];
        }

        return crypto;
    }

    public String descifra(String msg, String key) { 
        String crypto = "", cmsg = "";

        // Preprocess message
        msg = msg.toUpperCase();
        for (int i = 0; i < msg.length(); i++) {
            char c = msg.charAt(i);
            if (c >= 'A' && c <= 'Z')
                cmsg += c;
        }    
    
        // decypher
        key = key.toUpperCase();
        for (int i = 0, j = 0; i < cmsg.length(); ++i, j++) {
            if (j == key.length()) j = 0;

            int row = 0;
            while(this.ciphTable[row][key.charAt(j) - 'A'] != cmsg.charAt(i)) ++row;

            crypto += (char)(row + 'A');
        }

        return crypto; 
    }

    public char[][] getTablaCifrado() {
        char[][] ret = new char[SIZE][];

        for (int i = 0; i < SIZE; ++i) ret[i] = Arrays.copyOf(this.ciphTable[i], SIZE);

        return ret;
    }

    public static void main(String[] args) {
        CriptoTabla c1 = new CriptoTabla();

        char[][] ct1 = c1.getTablaCifrado();
        for(int i=0; i<26; i++) 
            System.out.println(Arrays.toString(ct1[i]));

        System.out.println();

        CriptoTabla c2 = new CriptoTabla(5);
        char[][] ct2 = c2.getTablaCifrado();
        for (int i = 0; i < 26; i++)
            System.out.println(Arrays.toString(ct2[i]));            

        String crypto1 = c1.cifra("The #eagle# is in the nest", "orange");
        System.out.println(crypto1);
        System.out.println(c1.descifra(crypto1, "orange"));

        String crypto2 = c2.cifra("The #eagle# is in the nest", "orange");
        System.out.println(crypto2);
        System.out.println(c2.descifra(crypto2, "orange"));

        System.out.print("Test 3 - Constructor por defecto: ");

        boolean res = true;
        CriptoTabla c = new CriptoTabla();
        char[][] data = c.getTablaCifrado();
        char[][] data_test = CriptoTablaTest.createTable(0);
        for(int i=0; i<data.length; i++) {
            for(int j=0; j<data[0].length; j++) {
                if(data[i][j] != data_test[i][j]) {
                    res = false;
                    break;
                }
            }
        }
        System.out.println(res?"OK":"FAIL");
    }
}