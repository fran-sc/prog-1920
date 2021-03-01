package c4;

import java.util.Scanner;

public class ConsoleApp {
    private static final int TYPE_HUMAN = 1;
    private static final int TYPE_RANDOM = 2;
    private static final int TYPE_LEFT = 3;
    private static final int TYPE_HEURISTIC = 4;

    private static void showHeader(int sys) {
        ConsoleUtil.cls(sys);

        System.out.println("\n");
        System.out.println(ConsoleUtil.rainbownize(sys, "\t***************"));
        System.out.println(ConsoleUtil.rainbownize(sys, "\t*  CONECTA-4  *"));
        System.out.println(ConsoleUtil.rainbownize(sys, "\t***************"));
        System.out.println();
    }

    /** Crea un nuevo jugador. */
    private static Player createPlayer(int id, Scanner cin) {
        System.out.print("\t\nTipo [1: Humano | 2: RandomBot | 3: LeftBot | 4: HeuristicBot]: ");
        int type = Integer.parseInt(cin.nextLine());

        switch (type) {
            case TYPE_HUMAN:
                System.out.print("\t\nNombre: ");
                String name = cin.nextLine();
                return new ConsoleHumanPlayer(id, name, cin);

            case TYPE_RANDOM:
                return new RandomBotPlayer(id, "Random Bot " + id);

            case TYPE_LEFT:
                return new LeftBotPlayer(id, "Left Bot " + id);

            case TYPE_HEURISTIC:
                System.out.print("\t\nNivel [1-4]: ");
                int level = Integer.parseInt(cin.nextLine());
                int treeDepth = level * 2 - 1;
                return new HeuristicBotPlayer(id, "Heuristic Bot [N:" + level + "]", treeDepth);
        }

        return null;
    }

    // Crea un nuevo juego.
    private static Connect4 createGame(Scanner cin, int sys) {
        showHeader(sys);

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

    // Muestra el resumen de la partida.
    private static void showStats(Connect4 c4, int sys) {
        showBoard(c4, sys);

        // Check ganador ó empate
        Player winner = c4.getWinner();
        if (winner != null) {
            // Un ganador
            System.out.println("\n\t 4 en línea !!");
            System.out.println(
                "\nGanó el jugador " + winner.getId() + " (" + c4.MARKS[winner.getId() - 1] + ")");
            System.out.println("\nEnhorabuena, " + winner.getName() + "!");
        } else
            // Empate
            System.out.println("\n\t   Empate !!");
        System.out.println("\nFin de la partida.");
    }

    // Muestra el estado actual del tablero.
    private static void showBoard(Connect4 c4, int sys) {
        showHeader(sys);
        System.out.println(c4);
    }

    // Nueva partida?
    private static boolean newGame(Scanner cin) {
        System.out.print("\nOtra [s/n]? ");
        String s = cin.nextLine().trim().toLowerCase();
        return (s.equals("s"));
    }

    // Método principal. Inicio de la aplicación.
    public static void main(String args[]) {
        int sys = ConsoleUtil.getSystem();
        Scanner cin = new Scanner(System.in);

        // BUCLE PRINCIPAL
        do {
            // Crea una nueva partida
            Connect4 c4 = createGame(cin, sys);

            // BUCLE PARTIDA
            int round = 1, playerId = 1;
            while (!c4.isDone()) {
                // Muestra tablero
                showBoard(c4, sys);

                // muestra turno
                System.out.println("\nTurno: " + round);
                System.out.println("\nMueve: " + c4.getPlayer(playerId).getName() + " ("
                    + c4.MARKS[playerId - 1] + ")");

                // Juega
                c4.runOnce(playerId);

                // Actualiza turno
                if (playerId == 2)
                    ++round;

                // Cambia el jugador
                playerId = playerId % 2 + 1;
            }

            // FIN DEL JUEGO
            // Muestra resultado final
            showStats(c4, sys);

            // Nueva partida?
            if (!newGame(cin))
                break;
        } while (true);
    }
}
