package c4;

import java.util.Random;
import java.util.Set;
import java.util.TreeMap;
import java.util.Arrays;

/**
 * Crea un agente de tipo Smart.
 * */
public class SmartBotPlayer extends Player {
    private static final int REW_WIN = (int) 1E6;

    public SmartBotPlayer(int id, String name) {
        super(id, name);
    }

    @Override
    public int nextMove(Board board) {
        int[][] b = board.getBoardArray();

        TreeMap<Integer, Integer> scores = new TreeMap<>();

        // Calcula las puntuaciones de cada movimiento
        for (int col = 0; col < b[0].length; col++)
            if (b[0][col] == 0)
                scores.put(col, getScore(col, b));

        // Devuelve la columna con la puntuación máxima
        Set<Integer> keys = scores.keySet();
        int col = 0;
        int best = scores.get(col);
        for (Integer k : keys) {
            if (scores.get(k) > best) {
                col = k;
                best = scores.get(k);
            }
        }

        return col;
    }

    private int getScore(int col, int[][] board) {
        int score = 0, npos;

        int[][] test_board = makeMove(id, col, board);

        // Chequea posiciones de victoria
        npos = checkWindow(id, 4, test_board);
        score += REW_WIN * npos;

        return score;
    }

    private int[][] makeMove(int id, int col, int[][] board) {
        int nrows = board.length;
        int ncols = board[0].length;

        // Copia del tablero
        int[][] test_board = new int[nrows][];
        for (int i = 0; i < nrows; i++) test_board[i] = Arrays.copyOf(board[i], ncols);

        int row = 0;
        while (row < nrows && test_board[row][col] == 0) ++row;

        // Posiciona la pieza;
        test_board[--row][col] = id;

        return test_board;
    }

    private int checkWindow(int id, int num_pieces, int[][] board) {
        int npos = 0;
        int num_free = 4 - num_pieces;
        int c_free, c_piece;
        int nrows = board.length;
        int ncols = board[0].length;

        // Check vertical
        for (int r = 0; r < 3; r++)
            for (int c = 0; c < ncols; c++) {
                c_free = 0;
                c_piece = 0;
                for (int k = 0; k < 4; k++) {
                    int val = board[r + k][c];
                    if (val == id)
                        ++c_piece;
                    else if (val == 0)
                        ++c_free;
                }
                if (c_piece == num_pieces && c_free == num_free)
                    ++npos;
            }

        // Check horizontal
        for (int c = 0; c < 4; c++)
            for (int r = nrows - 1; r >= 0; r--) {
                c_free = 0;
                c_piece = 0;
                for (int k = 0; k < 4; k++) {
                    int val = board[r][c + k];
                    if (val == id)
                        ++c_piece;
                    else if (val == 0)
                        ++c_free;
                }
                if (c_piece == num_pieces && c_free == num_free)
                    ++npos;
            }

        // Check diagonales decrecientes
        for (int r = 0; r < 3; r++)
            for (int c = 0; c < 4; c++) {
                c_free = 0;
                c_piece = 0;
                for (int k = 0; k < 4; k++) {
                    int val = board[r + k][c + k];
                    if (val == id)
                        ++c_piece;
                    else if (val == 0)
                        ++c_free;
                }
                if (c_piece == num_pieces && c_free == num_free)
                    ++npos;
            }

        // Check diagonales crecientes
        for (int r = nrows - 1; r > 2; r--)
            for (int c = 0; c < 4; c++) {
                c_free = 0;
                c_piece = 0;
                for (int k = 0; k < 4; k++) {
                    int val = board[r - k][c + k];
                    if (val == id)
                        ++c_piece;
                    else if (val == 0)
                        ++c_free;
                }
                if (c_piece == num_pieces && c_free == num_free)
                    ++npos;
            }

        return npos;
    }
}
