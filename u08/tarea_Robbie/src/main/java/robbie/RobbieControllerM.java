package robbie;

import java.util.Scanner;

public class RobbieControllerM {
    private static final int MAX_UNDO_COMM = 10;
    private static final int OP_EXIT = 0;
    private static final int OP_LOC = 1;
    private static final int OP_PROG = 2;
    private static final int OP_UNDO = 3;
    private static final int OP_REDO = 4;

    private static final String COM_MOV = "MOV";
    private static final String COM_ROT = "ROT";
    private static final String COM_PRF = "PRF";
    private static final String COM_EXE = "EXE";

    private Robbie robot;
    private CommNav[] commList;
    private int nextComm;

    public RobbieControllerM() { 
        this.robot = new Robbie(); 
        this.commList = new CommNav[MAX_UNDO_COMM];
    }

    public static void main(String[] args) {
        RobbieControllerM control = new RobbieControllerM();

        while(true) {
            switch(menu()) {
                case OP_EXIT:
                    System.exit(0);
                case OP_LOC:
                    System.out.println("La posición actual de Robbie es: " + control.robot);
                    break;
                case OP_PROG:
                    control.opcProgram();
                    break;
                case OP_UNDO:
                    //control.opcUndoLast();
                    break;
                case OP_REDO:
                    //control.opcReDoLast();
                    break;
            }
        }
    }

    public static int menu() {
        Scanner cin = new Scanner(System.in);

        System.out.println("\n------- Robbie Controller -------\n");
        System.out.println("1. Posición y Orientación actual");
        System.out.println("2. Ejecutar Programa");
        System.out.println("3. Deshacer último comando");
        System.out.println("4. Rehacer último comando");
        System.out.println("0. Terminar");

        while(true) {
            System.out.print("\nOpción > ");
            while(!cin.hasNext());
            if(cin.hasNextInt()) {
                int op = cin.nextInt();
                if(op>=OP_EXIT && op<=OP_REDO) return op;
            }
            cin.nextLine();
        }
    }

    private void opcProgram() {
        IComm[] commands = new IComm[MAX_UNDO_COMM];
        this.nextComm = 0;

        Scanner cin = new Scanner(System.in);
        String cmd = "";

        System.out.println("\nIntroduce comandos (EXE para ejecutar):");
        while(this.nextComm<MAX_UNDO_COMM && !cmd.equals(COM_EXE)) {
            
        }
    }
}