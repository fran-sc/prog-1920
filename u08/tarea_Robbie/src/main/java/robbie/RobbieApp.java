package robbie;

import java.util.Scanner;

public class RobbieApp {
    public static void main(String[] args) {
        RobbieController1 control = new RobbieController1();
        
        Scanner cin = new Scanner(System.in);
        
        String program = "", line = "";
        
        printHeader(control);
        do {
            line = cin.nextLine().trim().toUpperCase();
            if(line.equals("EXEC")) {
                System.out.println("\nEjecutando programa...\n");
                control.executeProgram(program);
                printHeader(control);
                program = "";
            }
            else program += line + "\n";
        } while(!line.equals("ENDS"));
    }

    private static void printHeader(RobbieController1 control) {
        System.out.println("\nLa localización actual de Robbie es: " + control.getRobot());
        System.out.println("\nEnter program >\n");
    }
}