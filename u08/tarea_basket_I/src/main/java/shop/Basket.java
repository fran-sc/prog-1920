package shop;

import java.math.BigDecimal;
import java.util.Arrays;
import ds.DynArray;

public class Basket {
    private DynArray<BasketEntry> entryList;

    public Basket() {
        this.entryList = new DynArray<>();
    }

    public boolean isEmpty() { return entryList.isEmpty(); }

    public int getNumEntries() { return entryList.size(); }

    public void clear() { this.entryList.clear(); }

    public void add(Product p, int items) {
        BasketEntry entry =  this.find(p);

        if(entry !=null)
            // El producto está en la cesta -> Icrementamos las unidades
            entry.add(items);
        else
            // El producto no está en la lista -> Añadimos el producto
            this.entryList.add(new BasketEntry(p, items));
    }

    private BasketEntry find(Product p) {
        for(BasketEntry entry: this.entryList) 
            if(entry.getProduct().equals(p)) return entry;
        
        return null;
    }

    public void sub(Product p, int items) {
        BasketEntry entry =  this.find(p);
        
        if(entry != null) {
            // Si el producto está en la cesta, restamos unidades
            // Si no quedan más, eliminamos la entrada
            if(entry.sub(items) == 0)
                this.entryList.remove(this.entryList.indexOf(entry));
        }
    }

    public BigDecimal[] getTotal() {
        BigDecimal[] total = new BigDecimal[] {BigDecimal.ZERO, BigDecimal.ZERO};

        for(BasketEntry entry: this.entryList) {
            BigDecimal[] entryTotal = entry.getTotal();
            total[0] = total[0].add(entryTotal[0]);
            total[1] = total[1].add(entryTotal[1]);
        }

        return total;
    }

    @Override
    public String toString() {
        String s = "";

        for(BasketEntry entry: this.entryList) s += entry + "\n";

        return s;
    }

    public static void main(String[] args) {
        Product p1 = new Product("R001", "Producto 1", "0.04", "21.25");
        Product p2 = new Product("R002", "Producto 2", "0.10", "32.50");
        Product p3 = new Product("R003", "Producto 3", "0.21", "112.18");

        Basket cesta = new Basket();
        cesta.add(p1, 1);
        cesta.add(p2, 1);
        cesta.add(p3, 2);
        cesta.add(p1, 2);

        System.out.println("CESTA:\n" + cesta);
        System.out.println("IMPORTE: " + Arrays.toString(cesta.getTotal()));
    }
}