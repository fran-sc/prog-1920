package c4;

import java.util.Arrays;

/**
 * Controlador del juego Conecta 4.
 * */
public class Connect4 {
    public static final char[] MARKS = {'X', 'O'};
    public static final int NCOLS = 7;
    public static final int NROWS = 6;

    private Board board;
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
        this.board = new Board(NROWS, NCOLS);
    }

    public Board getBoard() {
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

    /** Reinicia los contadores y estructuras. */
    public void restart() {
        this.nMoves = 0;
        this.winner = null;
        this.done = false;
        this.board = new Board(NROWS, NCOLS);
    }

    /**
     * Realiza una iteración del juego.
     *
     * @param id 1 ó 2
     * */
    public void runOnce(int id) {
        Player p = this.players[--id];

        // realiza el movimiento que indique jugador
        // (todo: movimiento no válidotodo: movimiento no válido)
        this.board.move(p.getId(), p.nextMove(this.board));
        ++this.nMoves;

        // check si fin partida
        this.done = this.checkWin(p);
        if (this.done)
            this.winner = p;
        else
            // check si fin movimientos
            this.done = this.nMoves == NROWS * NCOLS;
    }

    @Override
    public String toString() {
        int[][] b = board.getBoardArray();

        String out = "";

        for (int[] row : b) {
            out += "\t|";
            for (int cell : row) out += ((cell == 0 ? " " : MARKS[cell - 1]) + "|");
            out += "\n";
        }

        out += "\t";
        for (int i = 0; i < board.getCols(); i++) out += " -";
        out += "\n\t";
        for (int i = 0; i < board.getCols(); i++) out += " " + i;

        return out;
    }

    private boolean checkWin(Player p) {
        return board.countWindows(4, 4, p.getId()) > 0;
    }
}

