package shop;

public class BasketDemo {
    public static void main(String[] args) {
        Product p1 = new Product("R001", "Producto 1", "0.04", "21.25");
        Product p2 = new Product("R002", "Producto 2", "0.10", "32.50");
        Product p3 = new Product("R003", "Producto 3", "0.21", "112.18");

        Basket cesta = new Basket();
        cesta.add(p1, 1);
        cesta.add(p2, 1);
        cesta.add(p3, 2);
        cesta.add(p1, 2);

        System.out.println("CESTA:");
        System.out.println(cesta);

        try {
            cesta.sub(p1, 2);
            cesta.sub(new Product("RF1", "XX", "XX", "XX"), 1);
        } catch (ProductNotInBasketException e) {
            System.out.println(e);
        }

        try {
            cesta.remove(p3);
            cesta.remove(new Product("RF2", "XX", "XX", "XX"));
        } catch (ProductNotInBasketException e) {
            System.out.println(e);
        }

        System.out.println("CESTA:");
        System.out.println(cesta);
    }    
}