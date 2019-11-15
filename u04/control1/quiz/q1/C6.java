import java.util.Scanner;

public class C6 {
    public static void main(String[] args) {
        double comidaDiaria, kilosPorAnimal, comida;
        int numAnimales;

        Scanner cin = new Scanner(System.in);
        
        comidaDiaria = cin.nextDouble();
        numAnimales = cin.nextInt();        
        kilosPorAnimal = cin.nextDouble();

        comida = numAnimales * kilosPorAnimal;
        if(comidaDiaria >= comida)
            System.out.printf("Excedente = %.1f Kg%n", (comidaDiaria-comida));
        else 
            System.out.printf("Ración = %.2f Kg%n", (comidaDiaria/numAnimales));  
    }
}
