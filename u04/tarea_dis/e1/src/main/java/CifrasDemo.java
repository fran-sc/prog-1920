import java.util.Scanner;
class CifrasDemo {
    public static void main(String[] args) {
        final String FIN = "FIN";

        Scanner cin = new Scanner(System.in);

        String texto = "";
        
        // Obtenemos el texto de entrada
        System.out.println("Empieza a escribir (\"FIN\" para terminar):");
        while(true) {
            texto += cin.nextLine();
            if(texto.contains(FIN)) {
                // Eliminamos FIN de la entrada
                texto = texto.substring(0, texto.indexOf(FIN));
                break;
            }
        }        

        // Obtiene las cifras
        int cifras = Cifras.getCifras(texto);
        System.out.println((cifras>0)?"El número total de cifras es: " + cifras:"No hay cifras en el texto");
    }
}