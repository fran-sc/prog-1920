//: numeros/DemoNum.java
package numeros;

class DemoNum {
    public static void main(String args[]) {
        Complejo c1, c2;
        
        c1 = new Complejo();
        System.out.println("c1 = " + c1);
        
        c1.cambia_Real(3);
        c1.cambia_Imag(4);
        System.out.println("c1 = " + c1);
        
        c2 = new Complejo(3.5, -2.5);
        System.out.println("La parte real de C2 es: " + 
                                                    c2.consulta_Real());
        System.out.println("La parte imaginaria de C2 es: " + 
                                                    c2.consulta_Imag());
        
        c1.sumar(c2);
        System.out.println("c1 = " + c1);        
    }
}
/* Output:
c1 = 0.0 + 0.0i
c1 = 3.0 + 4.0i
La parte real de C2 es: 3.5
La parte imaginaria de C2 es: -2.5
c1 = 6.5 + 1.5i
*///:~
