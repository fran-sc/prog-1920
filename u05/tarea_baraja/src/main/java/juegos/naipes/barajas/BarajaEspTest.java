package juegos.naipes.barajas;

import java.util.Scanner;

class BarajaEspTest {
    private static void muestraMenu() {
        System.out.println();
        System.out.println("1 - Reiniciar");
        System.out.println("2 - Barajar");
        System.out.println("3 - Dar cartas");
        System.out.println("4 - Mostrar cartas dadas");
        System.out.println("5 - Mostrar cartas mazo");
        System.out.println("6 - Salir");
        System.out.print("\nOpción: ");
    }

    private static void opcReiniciar(BarajaEsp b) {
        b.reinicia();
    }

    private static void opcBarajar(BarajaEsp b) {
        b.baraja();        
    }

    private static void opcDarCartas(BarajaEsp b) {
        CartaEsp[] cartas = null;
        Scanner cin = new Scanner(System.in);

        System.out.print("Cuántas cartas? ");
        cartas = b.daCartas(Integer.parseInt(cin.nextLine()));

        if(cartas!=null)
            for(CartaEsp c: cartas)
                System.out.println(c);
        else 
            System.out.println("No hay suficientes cartas en el mazo");
    }

    private static void opcMostrarCartasDadas(BarajaEsp b) {
        CartaEsp[] cartas = b.cartasEnMesa();
        if(cartas!=null)
            for(CartaEsp c: cartas)
                System.out.println(c);
        else 
            System.out.println("Aún no se dio ninguna carta");        
    }

    private static void opcMostrarCartasMazo(BarajaEsp b) {
        CartaEsp[] cartas = b.cartasEnMazo();
        if(cartas!=null)
            for(CartaEsp c: cartas)
                System.out.println(c);
        else 
            System.out.println("No quedan cartas en el mazo");        
    }

    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        BarajaEsp b = new BarajaEsp();

        main_loop:
        while(true) {
            muestraMenu();
            switch(cin.nextInt()) {
                case 1:
                    opcReiniciar(b);
                    break;
                case 2:
                    opcBarajar(b);
                    break;
                case 3:
                    opcDarCartas(b);
                    break;                
                case 4:
                    opcMostrarCartasDadas(b);
                    break;                                    
                case 5:
                    opcMostrarCartasMazo(b);
                    break;  
                case 6:
                    break main_loop;                                                                
                default:
                    System.out.println("Opción no válida");                                        
            }
            muestraMenu();
        }
    }
}