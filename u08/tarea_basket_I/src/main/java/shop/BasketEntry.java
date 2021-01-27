package shop;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Arrays;

public class BasketEntry {
    private Product product;
    private double items;

    public BasketEntry(Product product, int items) {
        this.product = product;
        this.items = items;
    }

    public Product getProduct() { return this.product; }
    public double getItems() { return this.items; }

    public double add(double items) { 
        this.items += items; 
        return this.items;
    }

    public double sub(double items) { 
        this.items -= items; 
        if(this.items<0) this.items = 0;

        return this.items;
    }

    public BigDecimal[] getTotal() {
        BigDecimal tax = new BigDecimal(this.product.getTax());
        BigDecimal unitPrice = new BigDecimal(this.product.getPrice());

        // totalPrice = unitPrice * items
        BigDecimal totalPrice = unitPrice.multiply(BigDecimal.valueOf(this.items));

        // totalTaxes = totalPrice * tax
        BigDecimal totalTaxes = totalPrice.multiply(tax);

        // totalAmount = totalPrice + totalTaxes
        BigDecimal totalAmount = totalPrice.add(totalTaxes);

        // redondeamos a 2 decimales
        totalTaxes = totalTaxes.setScale(2, RoundingMode.HALF_EVEN);
        totalAmount = totalAmount.setScale(2, RoundingMode.HALF_EVEN);
        
        return new BigDecimal[] {totalTaxes, totalAmount};
    }

    @Override
    public String toString() {
        return this.product + "[" + this.items + "]" + Arrays.toString(this.getTotal());
    }
}