package geom;

import java.util.Scanner;
import java.util.Locale;

public class Circulo2DTest {
    private static void imprimeCirculo2D(Circulo2D c) {
        System.out.printf("%-10s%12s%n", "ID:", c.getID());
        System.out.printf("%-10s%12s%n", "Posición:", "(" + c.getX() + ", " + c.getY() + ")");
        System.out.printf("%-10s%12s%n", "Radio:", c.getRadio());
        System.out.printf("%-10s%12s%n", "Color:", c.getColor());
        System.out.printf("%-10s%12s%n", "Relleno:", c.getRelleno());
    }

    public static void main(String[] args) {
        Circulo2D c1, c2, c3;

        // Creamos círculo1
        c1 = new Circulo2D(2.5);
        imprimeCirculo2D(c1);

        // Movemos círculo1 a (4, 6)
        c1.mover(4, 6);

        // Creamos círculo2
        c2 = new Circulo2D(5, 2, 3);

        System.out.println("\nListado de objetos:");
        System.out.println("- " + c1);
        System.out.println("- " + c2);
        System.out.printf(Locale.US, "%nLa distancia entre ellos es: %.2f%n", Circulo2D.getDistancia(c1, c2));

        // Creamos círculo3
        Scanner cin = new Scanner(System.in);
        cin.useLocale(Locale.US);
        System.out.println("\nDatos del nuevo círculo>");
        System.out.print("Coordenada x del centro: ");
        int x = cin.nextInt();
        System.out.print("Coordenada y del centro: ");
        int y = cin.nextInt();
        System.out.print("Radio: ");
        double r = cin.nextDouble();
        cin.nextLine();
        System.out.print("Color: ");
        String color = cin.nextLine();
        
        c3 = new Circulo2D(r, x, y);
        c3.setColor(color);
        c3.setRelleno(true);

        System.out.println();
        imprimeCirculo2D(c3);

        System.out.println("\nListado de objetos:");
        System.out.println("- " + c1);
        System.out.println("- " + c2);
        System.out.println("- " + c3);
    }
}