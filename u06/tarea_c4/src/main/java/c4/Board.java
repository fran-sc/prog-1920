package c4;

import java.util.Random;

public class Board {
    private int rows;
    private int cols;
    private int[][] board;

    public Board(int rows, int cols) {
        board = new int[rows][cols];
        this.rows = rows;
        this.cols = cols;
    }

    public Board(int[][] board) {
        this.board = new int[board.length][];
        for (int i = 0; i < board.length; i++) this.board[i] = board[i].clone();
        this.rows = board.length;
        this.cols = board[0].length;
    }

    public int getRows() {
        return this.rows;
    }

    public int getCols() {
        return this.cols;
    }

    public int[][] getBoardArray() {
        return this.board;
    }

    public Board clone() {
        return new Board(this.getBoardArray());
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

    /** Coloca la pieza del jugador en la columna indicada. */
    public boolean move(int id, int col) {
        if (board[0][col] != 0)
            return false; // movimiento no posible

        // Busca la fila libre más abajo en la columna
        int row = 0;
        while (row < this.rows && board[row][col] == 0) ++row;

        // Posiciona la pieza;
        board[--row][col] = id;

        return true;
    }

    /**
     * Calcula el número de ventanas.
     *
     * Busca ventanas en el tablero que contengan el número especificado de
     * fichas del jugador, debiendo estar las restantes vacías.
     *
     * @param win tamaño de la ventana
     * @param num número de celdas del jugador en la ventana
     * @param id identificador del jugador
     * */
    public int countWindows(int win, int num, int id) {
        int nwin = 0;

        // check horizontal
        for (int i = 0; i < this.rows; i++)
            for (int j = 0, np, nb; j <= this.cols - win; j++) {
                np = 0;
                nb = 0;
                for (int k = 0; k < win; k++) {
                    if (board[i][j + k] == id)
                        ++np;
                    else if (board[i][j + k] == 0)
                        ++nb;
                }
                if (np == num && nb == (win - num))
                    ++nwin;
            }

        // check vertical
        for (int i = 0; i <= this.rows - win; i++)
            for (int j = 0, np, nb; j < this.cols; j++) {
                np = 0;
                nb = 0;
                for (int k = 0; k < win; k++) {
                    if (board[i + k][j] == id)
                        ++np;
                    else if (board[i + k][j] == 0)
                        ++nb;
                }
                if (np == num && nb == (win - num))
                    ++nwin;
            }

        // check diagonales decrecientes
        for (int i = 0; i <= this.rows - win; i++)
            for (int j = 0, np, nb; j <= this.cols - win; j++) {
                np = 0;
                nb = 0;
                for (int k = 0; k < win; k++) {
                    if (board[i + k][j + k] == id)
                        ++np;
                    else if (board[i + k][j + k] == 0)
                        ++nb;
                }
                if (np == num && nb == (win - num))
                    ++nwin;
            }

        // check diagonales crecientes
        for (int i = win - 1; i < this.rows; i++)
            for (int j = 0, np, nb; j <= this.cols - win; j++) {
                np = 0;
                nb = 0;
                for (int k = 0; k < win; k++) {
                    if (board[i - k][j + k] == id)
                        ++np;
                    else if (board[i - k][j + k] == 0)
                        ++nb;
                }
                if (np == num && nb == (win - num))
                    ++nwin;
            }

        return nwin;
    }
}
