package c4.tree;

import java.util.Random;

public class TBoard {
    private static final double REW_N4 = 1E6;
    private static final double REW_N3 = 1;
    private static final double REW_N4_OP = -1E4;
    private static final double REW_N3_OP = -1E2;

    private int[][] board;

    public TBoard(int[][] b) {
        board = new int[b.length][];
        for (int i = 0; i < board.length; i++) board[i] = b[i].clone();
    }

    public int[][] getBoard() {
        return this.board;
    }

    @Override
    public String toString() {
        String s = "";
        for (int[] row : this.board) {
            for (int val : row) s += val;
            s += '\n';
        }
        return s;
    }

    // Get position value
    public double getHeuristic(int id) {
        int n3 = countWindows(3, id);
        int n4 = countWindows(4, id);
        int n3_op = countWindows(3, id % 2 + 1);
        int n4_op = countWindows(4, id % 2 + 1);
        double delta = (new Random()).nextDouble() / 1E2;

        return n4 * REW_N4 + n3 * REW_N3 + n4_op * REW_N3_OP + n3_op * REW_N3_OP + delta;
    }

    public int countWindows(int num, int id) {
        int nwin = 0;

        // check horizontal
        for (int i = 0; i < board.length; i++)
            for (int j = 0, np, nb; j <= board[0].length - 4; j++) {
                np = 0;
                nb = 0;
                for (int k = 0; k < 4; k++) {
                    if (board[i][j + k] == id)
                        ++np;
                    else if (board[i][j + k] == 0)
                        ++nb;
                }
                if (np == num && nb == (4 - num))
                    ++nwin;
            }

        // check vertical
        for (int i = 0; i <= board.length - 4; i++)
            for (int j = 0, np, nb; j < board[0].length; j++) {
                np = 0;
                nb = 0;
                for (int k = 0; k < 4; k++) {
                    if (board[i + k][j] == id)
                        ++np;
                    else if (board[i + k][j] == 0)
                        ++nb;
                }
                if (np == num && nb == (4 - num))
                    ++nwin;
            }

        // check diagonales decrecientes
        for (int i = 0; i <= board.length - 4; i++)
            for (int j = 0, np, nb; j <= board[0].length - 4; j++) {
                np = 0;
                nb = 0;
                for (int k = 0; k < 4; k++) {
                    if (board[i + k][j + k] == id)
                        ++np;
                    else if (board[i + k][j + k] == 0)
                        ++nb;
                }
                if (np == num && nb == (4 - num))
                    ++nwin;
            }

        // check diagonales crecientes
        for (int i = 3; i < board.length; i++)
            for (int j = 0, np, nb; j <= board[0].length - 4; j++) {
                np = 0;
                nb = 0;
                for (int k = 0; k < 4; k++) {
                    if (board[i - k][j + k] == id)
                        ++np;
                    else if (board[i - k][j + k] == 0)
                        ++nb;
                }
                if (np == num && nb == (4 - num))
                    ++nwin;
            }

        return nwin;
    }
}
