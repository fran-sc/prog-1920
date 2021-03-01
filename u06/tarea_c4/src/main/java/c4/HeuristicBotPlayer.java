package c4;

import c4.tree.*;
import java.util.Random;

/**
 * Crea un agente de tipo Heurístico.
 * */
public class HeuristicBotPlayer extends Player {
    private static int DEFAULT_TREE_DEPTH = 3;
    
    private boolean first_move = true;
    private int depth;

    public HeuristicBotPlayer(int id, String name) {
        this(id, name, DEFAULT_TREE_DEPTH);
    }

    public HeuristicBotPlayer(int id, String name, int depth) {
        super(id, name);
        this.depth = depth;
    }

    /** Busca una columna de forma aleatoria entre las válidas. */
    @Override
    public int nextMove(int[][] board) { 
        if(first_move) {
            // mueve a la columna central
            first_move = false;
            return board[0].length/2;
        }

        // Crea un árbol de jugadas de profundidad TREE_DEPTH a partir de la 
        // posición actual
        C4Tree tree = new C4Tree(board, this.depth, this.id);

        // Usa minimax para determinar el mejor movimiento
        MinimaxValue best = tree.minimax(tree.getRoot(), id, -1, this.depth, true);

        return best.col;
    }
}
