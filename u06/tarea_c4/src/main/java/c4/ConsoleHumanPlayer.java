package c4;

import java.util.Scanner;

/**
 * Crea un jugador humano.
 *
 * La entrada de la jugada se hace a través de la entrada estándar.
 * */
public class ConsoleHumanPlayer extends Player {
    Scanner cin;

    public ConsoleHumanPlayer(int id, String name, Scanner cin) {
        super(id, name);
        this.cin = cin;
    }

    /** Pide una columna hasta que sea válida. */
    @Override
    public int nextMove(Board board) {
        int maxCol = board.getCols() - 1;
        int col = -1;
        while (true) {
            System.out.print("\n> Columna [0-" + maxCol + "]: ");
            col = Integer.parseInt(cin.nextLine());
            if (col < 0 || col > maxCol || board.getBoardArray()[0][col] != 0)
                System.out.println("\nColumna no válida");
            else
                break;
        }
        return col;
    }
}
