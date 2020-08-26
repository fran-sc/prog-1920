package shop;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Arrays;
import java.util.ArrayList;

public class Basket {
    private ArrayList<BasketEntry> entryList;

    public Basket() {
        this.entryList = new ArrayList<>();
    }

    public boolean isEmpty() { return entryList.isEmpty(); }

    public int getNumEntries() { return entryList.size(); }

    public ArrayList<BasketEntry> getEntryList() { return this.entryList; }

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

    public void sub(Product p, int items) throws ProductNotInBasketException {
        BasketEntry entry =  this.find(p);
        
        if(entry != null) {
            // Si el producto está en la cesta, restamos unidades
            // Si no quedan más, eliminamos la entrada
            if(entry.sub(items) == 0)
                this.entryList.remove(this.entryList.indexOf(entry));
        }
        else 
        throw new ProductNotInBasketException("El producto no se encuentra en el carrito: " + p.getRef());
    }

    public void remove(Product p) throws ProductNotInBasketException {
        BasketEntry entry =  this.find(p);
        
        if(entry != null) {
            this.entryList.remove(this.entryList.indexOf(entry));
        }
        else 
            throw new ProductNotInBasketException("El producto no se encuentra en el carrito: " + p.getRef());
    }

    public BigDecimal[] getTotal() {
        BigDecimal[] total = new BigDecimal[] {BigDecimal.ZERO, BigDecimal.ZERO};

        for(BasketEntry entry: this.entryList) {
            BigDecimal[] entryTotal = entry.getTotal();
            total[0] = total[0].add(entryTotal[0]);
            total[1] = total[1].add(entryTotal[1]);
        }

        // redondeamos a 2 decimales
        total[0] = total[0].setScale(2, RoundingMode.HALF_EVEN);
        total[1] = total[1].setScale(2, RoundingMode.HALF_EVEN);

        return total;
    }

    @Override
    public String toString() {
        String s = "";

        int n = 0;
        for(BasketEntry entry: this.entryList) s += ++n + ":" + entry + "\n";

        s += "#:" + Arrays.toString(this.getTotal());

        return s;
    }
}