//: PersonaTest.java
public class PersonaTest {
    public static void main (String args[]) {
        Persona per = new Persona("John Doe", 47, 1.85f);
        
        System.out.println("El nombre es " + per.getNombre());
        System.out.print("Tiene " + per.getEdad() + " años");
        System.out.printf(" y mide %.2f metros\n", per.getAltura());
    }
}
/* Output:
El nombre es John Doe
Tiene 47 años y mide 1,85 metros
*///:~
