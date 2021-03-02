package c4;

import java.util.Random;

/**
 * Crea un agente de tipo Random.
 * */
public class LeftBotPlayer extends Player {
    public LeftBotPlayer(int id, String name) {
        super(id, name);
    }

    /** Busca una columna de forma aleatoria entre las válidas. */
    @Override
    public int nextMove(Board board) {
        int[][] b = board.getBoardArray();
        int col = 0;
        // Busca la primera columna válida desde la izquierda
        for (int i = 0; i < board.getCols(); i++)
            if (b[0][i] == 0) {
                col = i;
                break;
            }
        return col;
    }
}
