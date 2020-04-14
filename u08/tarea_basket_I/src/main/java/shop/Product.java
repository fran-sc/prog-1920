package shop;

public class Product {
    private String ref;
    private String name;
    private String tax;
    private String price;

    public Product(String ref, String name, String tax, String price) {
        this.ref = ref;
        this.name = name;
        this.tax = tax;
        this.price = price;
    }

    public String getRef() { return this.ref; }
    public String getName() { return this.name; }
    public String getTax() { return this.tax; }
    public String getPrice() { return this.price; }

    @Override
    public boolean equals(Object obj) {
        return this.ref.equals(((Product)obj).getRef());
    }
    
    @Override
    public String toString() { 
        return "[" + this.ref + ": " + this.name + ": " + this.tax + "%: " + this.price + "€]";
    }
}