package c4;

import java.util.Random;

/**
 * Crea un agente de tipo Random.
 * */
public class RandomBotPlayer extends Player {
    public RandomBotPlayer(int id, String name) {
        super(id, name);
    }

    /** Busca una columna de forma aleatoria entre las válidas. */
    @Override
    public int nextMove(Board board) {
        int[][] b = board.getBoardArray();

        // Creamos una lista con los índices de las columnas disponibles
        // (se puede hacer con ArrayList)
        int n_free_cols = 0;
        int n_cols = board.getCols();
        int[] free_col_indices = new int[n_cols];
        for (int i = 0; i < n_cols; i++)
            if (b[0][i] == 0)
                free_col_indices[n_free_cols++] = i;

        // Seleccionamos el índice de la columna al azar
        return free_col_indices[(new Random()).nextInt(n_free_cols)];
    }
}
