package ds;

public class DynStrArrayDemo {
    public static void main(String[] args) {
        test21();

        test22();

        test23();

        test24();
    }

    private static void test21() {
        System.out.println("\n### Test 2.1");
        System.out.println("Creando array dinámico dynArr...");
        DynStrArray dynArr = new DynStrArray();
        System.out.println("Tamaño de dynArr = " + dynArr.size());

        System.out.println("Añadiendo cadenas hasta superar el espacio por defecto (10)...");
        for(int i=1; i<=20; i++) dynArr.add(String.valueOf(i));
        System.out.println("Tamaño de dynArr = " + dynArr.size());
        System.out.println("dynArr = " + dynArr);

        System.out.println("Borrando el array...");
        dynArr.clear();
        System.out.println("Tamaño de dynArr = " + dynArr.size());
        System.out.println("dynArr = " + dynArr);
    }

    private static void test22() {
        System.out.println("\n### Test 2.2");
        System.out.println("Creando array dinámico dynArr1 a partir del array {\"cero\", \"uno\", \"dos\"}...");
        DynStrArray dynArr1 = new DynStrArray(new String[] {"cero", "uno", "dos"});

        System.out.println("Creando array dinámico dynArr2 a partir de dynArr1...");
        DynStrArray dynArr2 = new DynStrArray(dynArr1);

        System.out.println("Tamaño de dynArr1 = " + dynArr1.size());
        System.out.println("Tamaño de dynArr2 = " + dynArr2.size());

        System.out.println("Añadiendo la cadenas \"tres\" al primero y \"3\" al segundo...");
        dynArr1.add("tres");
        dynArr2.add("3");
        System.out.println("Tamaño de dynArr1 = " + dynArr1.size());
        System.out.println("Tamaño de dynArr2 = " + dynArr2.size());        
        System.out.println("dynArr1 = " + dynArr1);
        System.out.println("dynArr2 = " + dynArr2);

        System.out.println("Borrando los arrays...");
        dynArr1.clear();
        dynArr2.clear();
        System.out.println("Tamaño de dynArr1 = " + dynArr1.size());
        System.out.println("Tamaño de dynArr2 = " + dynArr2.size());        
        System.out.println("dynArr1 = " + dynArr1);
        System.out.println("dynArr2 = " + dynArr2);
    }    

    private static void test23() {
        System.out.println("\n### Test 2.3");
        System.out.println("Creando array dinámico dynArr...");
        DynStrArray dynArr = new DynStrArray();
        
        System.out.println("Añadiendo los valores \"uno\", \"dos\" y \"cuatro\"}...");
        dynArr.add("uno");
        dynArr.add("dos");
        dynArr.add("cuatro");

        System.out.println("Añadiendo el valor \"cero\" en la posición 5...");
        try { dynArr.add(5, "cero"); }
        catch(IndexOutOfBoundsException e) { System.out.println(e.getMessage()); }

        System.out.println("Añadiendo el valor \"cero\" en la posición -5...");
        try { dynArr.add(-5, "cero"); }
        catch(IndexOutOfBoundsException e) { System.out.println(e.getMessage()); }

        System.out.println("Añadiendo el valor \"cero\" en la posición 0...");
        dynArr.add(0, "cero");
        System.out.println("Tamaño de dynArr = " + dynArr.size());
        System.out.println("dynArr = " + dynArr);

        System.out.println("Añadiendo el valor \"tres\" en la posición 3...");
        dynArr.add(3, "tres");
        System.out.println("Tamaño de dynArr = " + dynArr.size());
        System.out.println("dynArr = " + dynArr);
    }

    private static void test24() {
        System.out.println("\n### Test 2.4");
        System.out.println("Creando array dinámico dynArr a partir del array {\"0\", \"1\", \"dos\"}...");
        DynStrArray dynArr = new DynStrArray(new String[] {"0", "1", "dos"});
        System.out.println("Tamaño de dynArr = " + dynArr.size());
        System.out.println("dynArr = " + dynArr);        

        System.out.println("Modificando el valor de la posición 3...");
        try { dynArr.set(3, "cero"); }
        catch(IndexOutOfBoundsException e) { System.out.println(e.getMessage()); }        

        System.out.println("Modificando el valor de la posición -3...");
        try { dynArr.set(-3, "cero"); }
        catch(IndexOutOfBoundsException e) { System.out.println(e.getMessage()); }                

        System.out.println("Modificando el valor de la posición 0...");
        try { dynArr.set(0, "cero"); }
        catch(IndexOutOfBoundsException e) { System.out.println(e.getMessage()); }                

        System.out.println("Eliminando el valor de la posición 3...");
        try { dynArr.remove(3); }
        catch(IndexOutOfBoundsException e) { System.out.println(e.getMessage()); }        

        System.out.println("Eliminando el valor de la posición -3...");
        try { dynArr.remove(-3); }
        catch(IndexOutOfBoundsException e) { System.out.println(e.getMessage()); }                

        System.out.println("Buscando la cadena \"1\"... " + dynArr.indexOf("1"));

        System.out.println("Eliminando la cadena \"1\"... " + dynArr.delete("1"));

        System.out.println("Tamaño de dynArr = " + dynArr.size());
        System.out.println("dynArr = " + dynArr);   

        System.out.println("Buscando la cadena \"hola\"... " + dynArr.indexOf("hola"));

        System.out.println("Eliminando la cadena \"hola\"... " + dynArr.delete("hola"));

        System.out.println("Añadiendo el valor \"uno\" en la posición 1...");
        dynArr.add(1, "uno");

        System.out.println("Añadiendo el valor \"cinco\" al final...");
        dynArr.add("cinco");

        System.out.println("Insertando el valor \"cuatro\" antes de \"cinco\"...");
        dynArr.add(dynArr.indexOf("cinco"), "cuatro");

        System.out.println("Insertando el valor \"tres\" después de \"dos\"...");
        dynArr.add(dynArr.indexOf("dos") + 1, "tres");        
       
        System.out.println("Tamaño de dynArr = " + dynArr.size());
        System.out.println("dynArr = " + dynArr);          
    }    
}
