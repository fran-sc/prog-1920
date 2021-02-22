package c4;

import java.util.Arrays;

/**
 * Controlador del juego Conecta 4.
 * */
public class Connect4 {
    public static final int NCOLS = 7;
    public static final int NROWS = 6;

    private int[][] board;
    private boolean done;
    private Player[] players;
    private Player winner;
    private int nMoves;

    public Connect4(Player p1, Player p2) {
        // instancias de los jugadores
        this.players = new Player[2];
        this.players[0] = p1;
        this.players[1] = p2;

        // tablero
        this.board = new int[NROWS][NCOLS];
    }

    public int[][] getBoard() {
        return this.board;
    }

    public boolean isDone() {
        return this.done;
    }

    public Player getPlayer(int id) {
        return this.players[--id];
    }

    public Player getWinner() {
        return this.winner;
    }

    /** Coloca la pieza del jugador en la columna indicada. */
    public void move(Player p, int col) {
        // Busca la fila libre más abajo en la columna
        int row = 0;
        while (row < NROWS && board[row][col] == 0) ++row;

        // Posiciona la pieza;
        board[--row][col] = p.getId();
        ++this.nMoves;
    }

    /** Reinicia los contadores y estructuras. */
    public void restart() {
        this.nMoves = 0;
        this.winner = null;
        this.done = false;
        if (this.board != null)
            Arrays.fill(this.board, 0);
    }

    /**
     * Realiza una iteración del juego.
     *
     * @param id 1 ó 2
     * */
    public void runOnce(int num) {
        Player p = this.players[--num];

        // realiza el movimiento que indique jugador
        this.move(p, p.nextMove(this.board));

        // check si fin partida
        this.done = this.checkWin(p);
        if (this.done)
            this.winner = p;
        else
            // check si fin movimientos
            this.done = this.nMoves == NROWS * NCOLS;
    }

    private boolean checkWin(Player p) {
        int id = p.getId();

        // Check vertical
        for (int r = 0; r < 3; r++)
            for (int c = 0; c < NCOLS; c++) {
                boolean win = true;
                for (int k = 0; k < 4; k++)
                    if (board[r + k][c] != id) {
                        win = false;
                        break;
                    }
                if (win)
                    return true;
            }

        // Check horizontal
        for (int c = 0; c < 4; c++)
            for (int r = NROWS - 1; r >= 0; r--) {
                boolean win = true;
                for (int k = 0; k < 4; k++)
                    if (board[r][c + k] != id) {
                        win = false;
                        break;
                    }
                if (win)
                    return true;
            }

        // Check diagonales decrecientes
        for (int r = 0; r < 3; r++)
            for (int c = 0; c < 4; c++) {
                boolean win = true;
                for (int k = 0; k < 4; k++)
                    if (board[r + k][c + k] != id) {
                        win = false;
                        break;
                    }
                if (win)
                    return true;
            }

        // Check diagonales crecientes
        for (int r = NROWS - 1; r > 2; r--)
            for (int c = 0; c < 4; c++) {
                boolean win = true;
                for (int k = 0; k < 4; k++)
                    if (board[r - k][c + k] != id) {
                        win = false;
                        break;
                    }
                if (win)
                    return true;
            }

        return false;
    }
}

