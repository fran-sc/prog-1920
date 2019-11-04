//: Persona.java

public class Persona {
    String nombre;
    int edad;
    float altura;
  
    // getters
    String getNombre() { return nombre; }
    int getEdad(){ return edad; }  
    float getAltura(){ return altura; }   
    
    // setters
    void setNombre(String nombre){ this.nombre = nombre; }
    void setEdad(int edad){ this.edad = edad; };
    void setAltura(float altura){ this.altura = altura; };    
    
    public Persona( String nombre, int edad, float altura){
        this.nombre = nombre;
        this.edad = edad;
        this.altura = altura;
    }
}
