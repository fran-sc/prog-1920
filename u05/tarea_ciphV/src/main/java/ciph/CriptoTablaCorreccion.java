package ciph;

public class CriptoTablaCorreccion {
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
    
    private static void test3() {
        System.out.print("Test 3 - Constructor por defecto: ");
        boolean res = true;
        CriptoTabla c = new CriptoTabla();
        char[][] data = c.getTablaCifrado();
        char[][] data_test = createTable(0);
        for (int i = 0; i < data.length; i++) {
            for (int j = 0; j < data[0].length; j++) {
                if (data[i][j] != data_test[i][j]) {
                    res = false;
                    break;
                }
            }
        }
        System.out.println(res ? "OK" : "FAIL");
    }

    private static void test4() {
        System.out.print("Test 4 - Constructor copia: ");
        boolean res = true;
        char[][] data_test = createTable(0);
        CriptoTabla c = new CriptoTabla(data_test);
        char[][] data = c.getTablaCifrado();
        for (int i = 0; i < data.length; i++) {
            for (int j = 0; j < data[0].length; j++) {
                if (data[i][j] != data_test[i][j]) {
                    res = false;
                    break;
                }
            }
        }
        System.out.println(res ? "OK" : "FAIL");
    }

    private static void test5() {
        System.out.print("Test 5 - Constructor copia - excepción: ");
        boolean res = false;
        char[][] data_test = new char[1][2];
        try {
            CriptoTabla c = new CriptoTabla(data_test);
        } catch (IllegalArgumentException e) {
            res = true;
        } catch (Exception e) {
        }
        System.out.println(res ? "OK" : "FAIL");
    }

    private static void test6() {
        System.out.print("Test 6 - Constructor n=5: ");
        boolean res = true;
        char[][] data_test = createTable(5);
        CriptoTabla c = new CriptoTabla(5);
        char[][] data = c.getTablaCifrado();
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

    private static void test71() {
        System.out.print("Test 7.1 - Constructor n (-1) - excepción: ");
        boolean res = false;
        try {
            CriptoTabla c = new CriptoTabla(-1);
        } catch (IllegalArgumentException e) {
            res = true;
        } catch (Exception e) {}
        System.out.println(res ? "OK" : "FAIL");
    }

    private static void test72() {
        System.out.print("Test 7.1 - Constructor n (27) - excepción: ");
        boolean res = false;
        try {
            CriptoTabla c = new CriptoTabla(27);
        } catch (IllegalArgumentException e) {
            res = true;
        } catch (Exception e) {
        }
        System.out.println(res ? "OK" : "FAIL");        
    }

    private static void test8() {
        System.out.print("Test 8 - Método cifra() - tabla por defecto: ");

        char[][] data_test = createTable(0);
        CriptoTabla c = new CriptoTabla(data_test);
        
        String ct = c.cifra("The #eagle# is in the nest", "orange");
        
        System.out.println(ct.equals("HYERGKZVIFORHYEAKWH")?"OK":"FAIL");
        System.out.println("[" + ct + "]");        
    }

    private static void test9() {
        System.out.print("Test 9 - Método cifra() - tabla n=5: ");

        char[][] data_test = createTable(5);
        CriptoTabla c = new CriptoTabla(data_test);

        String ct = c.cifra("The #eagle# is in the nest", "orange");
        
        System.out.println(ct.equals("MDJWLPEANKTWMDJFPBM") ? "OK" : "FAIL");
        System.out.println("[" + ct + "]");        
    }

    private static void test10() {
        System.out.print("Test 10 - Método descifra() - tabla por defecto: ");
        
        char[][] data_test = createTable(0);
        CriptoTabla c = new CriptoTabla(data_test);
        
        String ct = c.descifra("Hyer gKz VIFO rhye A--KWH", "orange");
        System.out.println(ct.equals("THEEAGLEISINTHENEST") ? "OK" : "FAIL");
        System.out.println("[" + ct + "]");
    }

    private static void test11() {
        System.out.print("Test 11 - Método descifra() - tabla n=5: ");

        char[][] data_test = createTable(5);
        CriptoTabla c = new CriptoTabla(data_test);

        String ct = c.descifra("!!md JWLP ean#k TWMD?JFPBM", "orange");
        
        System.out.println(ct.equals("THEEAGLEISINTHENEST") ? "OK" : "FAIL");
        System.out.println("[" + ct + "]");
    }

    public static void main(String[] args) {
        test3();
        test4();
        test5();
        test6();
        test71();
        test72();
        test8();
        test9();
        test10();
        test11();
    }
}