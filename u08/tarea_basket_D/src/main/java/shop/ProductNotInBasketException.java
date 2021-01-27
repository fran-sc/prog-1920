
package shop;

public class ProductNotInBasketException extends Exception {
    private static final String DEFAULT_MSG = "El producto no se encuentra en el carrito";

    public ProductNotInBasketException() { super(DEFAULT_MSG); }

    public ProductNotInBasketException(String msg) { super(msg); }    
}