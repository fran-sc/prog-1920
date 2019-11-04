//: E2.java

class E2 {
    public static void main(String[] args) {
        String cadena = "   esto es un ejemplo de una cadena de ejemplo   ";

        System.out.println("cadena: \"" + cadena + "\"");
        System.out.println("La cadena tiene " + cadena.length() + " caracteres");

        System.out.println("Eliminando espacios...");
        cadena = cadena.trim();
        System.out.println("cadena: \"" + cadena + "\"");
        System.out.println("Ahora tiene " + cadena.length() + " caracteres");

        String cola = cadena.substring(cadena.indexOf("cadena"));
        System.out.println("cola: \"" + cola + "\"");

        System.out.println("Reemplazando 'ejemplo' por 'muestra' en cola...");
        cola = cola.replace("ejemplo", "muestra");
        System.out.println("cola: \"" + cola + "\"");

        String principio = cadena.substring(0, cadena.indexOf("cadena")-1);
        System.out.println("principio: \"" + principio + "\"");
     
        System.out.println("Concatenando...");
        String frase = principio + " " + cola;
        System.out.println("frase: \"" + frase + "\"");        

        System.out.println("Primera letra a mayúsculas...");
        frase = frase.substring(0, 1).toUpperCase() + frase.substring(1);
        System.out.println("frase: \"" + frase + "\"");                
    }
}
/* Output:
cadena: "   esto es un ejemplo de una cadena de ejemplo   "
La cadena tiene 49 caracteres
Eliminando espacios...
cadena: "esto es un ejemplo de una cadena de ejemplo"
Ahora tiene 43 caracteres
cola: "cadena de ejemplo"
Reemplazando 'ejemplo' por 'muestra' en cola...
cola: "cadena de muestra"
principio: "esto es un ejemplo de una"
Concatenando...
frase: "esto es un ejemplo de una cadena de muestra"
Primera letra a mayúsculas...
frase: "Esto es un ejemplo de una cadena de muestra"
*///:~
