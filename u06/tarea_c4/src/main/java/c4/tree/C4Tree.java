package c4.tree;

public class C4Tree {
    private TNode root;

    public TNode getRoot() {
        return this.root;
    }

    public C4Tree(int[][] board, int depth, int id) {
        this.root = new TNode(new TBoard(board), null);
        createChildren(this.root, depth, id);
    }

    @Override
    public String toString() {
        return this.root.toString();
    }

    private void createChildren(TNode parent, int depth, int id) {
        // Check if it is a final position
        TBoard tb = parent.getElement();
        if (tb.countWindows(4, id) > 0 || tb.countWindows(4, id % 2 + 1) > 0)
            return;

        // create childs from current position (one per column)
        // parent board
        int[][] pboard = tb.getBoard();

        // iterate over parent columns
        for (int n = 0; n < pboard[0].length; n++) {
            // clone parent
            int[][] cboard = new int[pboard.length][];
            for (int i = 0; i < pboard.length; i++) cboard[i] = pboard[i].clone();

            // add child to parent if a move is possible
            if (cboard[0][n] == 0) {
                // add move in the selected column
                addBoardMove(cboard, n, id);

                // add new child object to parent
                parent.addChildren(n, new TNode(new TBoard(cboard), parent));
            }
        }

        // add children of the next level
        if (--depth > 0) {
            id = id % 2 + 1;
            for (TNode node : parent.getChildren())
                if (node != null)
                    createChildren(node, depth, id);
        }
    }

    private void addBoardMove(int[][] board, int col, int id) {
        int row = 0;
        while (row < board.length && board[row][col] == 0) ++row;
        board[row - 1][col] = id;
    }

    public MinimaxValue minimax(TNode node, int id, int col, int depth, boolean maximizing) {
        // if we reach the bottom of the tree, return the position's heuristic value
        if (depth == 0 || node.isLeaf()) {
            return new MinimaxValue(col, node.getElement().getHeuristic(id));
        }

        MinimaxValue minimax_ret = new MinimaxValue();

        // if maximazing (player move), get the maximum of children position values
        if (maximizing) {
            minimax_ret.value = Integer.MIN_VALUE;
            TNode[] children = node.getChildren();
            for (int i = 0; i < children.length; i++) {
                if (children[i] != null) {
                    MinimaxValue children_ret = minimax(children[i], id, i, depth - 1, false);
                    if (children_ret.value > minimax_ret.value)
                        minimax_ret = new MinimaxValue(i, children_ret.value);
                }
            }
        }
        // if minimizing (player move), get the minimum of children position values
        else {
            minimax_ret.value = Integer.MAX_VALUE;
            TNode[] children = node.getChildren();
            for (int i = 0; i < children.length; i++) {
                if (children[i] != null) {
                    MinimaxValue children_ret = minimax(children[i], id, i, depth - 1, true);
                    if (children_ret.value < minimax_ret.value)
                        minimax_ret = new MinimaxValue(i, children_ret.value);
                }
            }
        }

        return minimax_ret;
    }
}
