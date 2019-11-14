//: u04/control1/e1/E16.java
package u04.control1.e1;

import java.util.Scanner;

/**
 * E16. 
 * En una granja se compra diariamente una cantidad de alimento, comidaDiaria, para alimentar a los
 * animales. El número de animales de la granja, todos de la misma especie, es numAnimales y, cada 
 * animal, necesita comer diariamente la cantidad kilosPorAnimal.
 * 
 * El programa solicitará al usuario la entrada de los valores anteriores y, en función de ellos, 
 * determinará según el caso:
 * 
 * - el excedente o kilos de comida sobrante
 * - la ración por animal, en caso de que no haya comida suficiente
 */
class E16 {
    public static void main(String[] args) {
        double comidaDiaria, kilosPorAnimal, comida;
        int numAnimales;

        Scanner sc = new Scanner(System.in);
        
        System.out.print("Introduce cantidad de alimento (kg): ");
        comidaDiaria = sc.nextDouble();

        System.out.print("Introduce número de animales: ");
        numAnimales = sc.nextInt();        

        System.out.print("Introduce cantidad de alimento por animal (kg): ");
        kilosPorAnimal = sc.nextDouble();

        comida = numAnimales * kilosPorAnimal;
        if(comidaDiaria >= comida)
            System.out.println("El excedente es de " + (comidaDiaria-comida) + " Kg");
        else {
            System.out.print("Comida insuficiente. ");
            System.out.printf("La ración por animal será de %.2f kg%n", comidaDiaria/numAnimales);  
        }
    }
}