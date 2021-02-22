package c4;

import java.util.Scanner;

public class ConsoleApp {
    private static final char[] MARKS = {'X', 'O'};
    private static final int TYPE_HUMAN = 1;
    private static final int TYPE_RANDOM = 2;
    private static final int TYPE_LEFT = 3;

    private static void showHeader(int sys) {
        ConsoleUtil.cls(sys);

        System.out.println();
        System.out.println("\t***************");
        System.out.println("\t*  CONECTA-4  *");
        System.out.println("\t***************");
        System.out.println();
    }

    /** Crea un nuevo jugador. */
    private static Player createPlayer(int id, Scanner cin) {
        System.out.print("\t\nTipo [1: Humano | 2: RandomBot | 3: LeftBot]: ");
        int type = Integer.parseInt(cin.nextLine());

        switch (type) {
            case TYPE_HUMAN:
                System.out.print("\t\nNombre: ");
                String name = cin.nextLine();
                return new ConsoleHumanPlayer(id, name, cin);

            case TYPE_RANDOM:
                return new RandomBotPlayer(id, "Random Bot");

            case TYPE_LEFT:
                return new LeftBotPlayer(id, "Left Bot");
        }

        return null;
    }

    // Crea un nuevo juego.
    private static Connect4 createGame(Scanner cin) {
        System.out.println("Bienvenido al juego de Conecta-4!!");

        // Crea el jugador 1
        System.out.println("\nJUGADOR 1:");
        Player p1 = createPlayer(1, cin);

        // Crea el jugador 2
        System.out.println("\nJUGADOR 2:");
        Player p2 = createPlayer(2, cin);

        // Crea el juego
        return new Connect4(p1, p2);
    }

    // Muestra el estado actual del tablero.
    private static void showBoard(Connect4 c4) {
        int[][] board = c4.getBoard();

        for (int[] row : board) {
            System.out.print("\t|");
            for (int cell : row) System.out.print((cell == 0 ? " " : MARKS[cell - 1]) + "|");
            System.out.println();
        }

        System.out.print("\t");
        for (int i = 0; i < board[0].length; i++) System.out.print(" -");
        System.out.print("\n\t");
        for (int i = 0; i < board[0].length; i++) System.out.print(" " + i);

        System.out.println();
    }

    public static void main(String args[]) {
        // ---------------------------------------------------------------------
        // INICIALIZACION
        // ---------------------------------------------------------------------
        int sys = ConsoleUtil.getSystem();

        showHeader(sys);

        Scanner cin = new Scanner(System.in);

        // Crea el juego
        Connect4 c4 = createGame(cin);

        // ---------------------------------------------------------------------
        // BUCLE PRINCIPAL
        // ---------------------------------------------------------------------
        int round = 1, playerId = 2;
        while (!c4.isDone()) {
            // Muestra tablero
            showHeader(sys);
            showBoard(c4);

            // muestra turno
            System.out.println("\nTurno: " + round);

            // Cambia el jugador
            playerId = (playerId == 2) ? 1 : 2;
            System.out.println(
                "\nMueve: " + c4.getPlayer(playerId).getName() + " (" + MARKS[playerId - 1] + ")");

            // Juega
            c4.runOnce(playerId);

            // Actualiza turno
            if (playerId == 2)
                ++round;
        }

        // ---------------------------------------------------------------------
        // FIN DEL JUEGO
        // ---------------------------------------------------------------------
        // Muestra tablero resultado final
        showHeader(sys);
        showBoard(c4);

        // Check ganador ó empate
        Player winner = c4.getWinner();
        if (winner != null) {
            // Un ganador
            System.out.println("\n\t 4 en línea !!");
            System.out.println(
                "\nGanó el jugador " + winner.getId() + " (" + MARKS[winner.getId() - 1] + ")");
            System.out.println("\nEnhorabuena, " + winner.getName() + "!");
        } else
            // Empate
            System.out.println("\n\t   Empate !!");

        System.out.println("\nFin de la partida.\n");
    }
}
