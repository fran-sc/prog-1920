package c4.tree;

import c4.Board;

public class C4Tree {
    private TNode root;

    public TNode getRoot() {
        return this.root;
    }

    public C4Tree(Board board, int depth, int id) {
        this.root = new TNode(board, null);
        createChildren(this.root, depth, id);
    }

    @Override
    public String toString() {
        return this.root.toString();
    }

    private void createChildren(TNode parent, int depth, int id) {
        // Check if it is a final position
        Board pboard = parent.getElement();
        if (pboard.countWindows(4, 4, id) > 0 || pboard.countWindows(4, 4, id % 2 + 1) > 0)
            return;

        // create childs from current position (one per column)
        // iterate over parent columns
        for (int n = 0; n < pboard.getCols(); n++) {
            // clone parent
            Board cboard = pboard.clone();

            // add child to parent if a move in the column is possible
            if (cboard.move(id, n))
                parent.addChildren(n, new TNode(cboard, parent));
        }

        // add children of the next level
        if (--depth > 0) {
            id = id % 2 + 1;
            for (TNode node : parent.getChildren())
                if (node != null)
                    createChildren(node, depth, id);
        }
    }

    public MinimaxValue minimax(TNode node, int id, int col, int depth, boolean maximizing) {
        // if we reach the bottom of the tree, return the position's heuristic value
        if (depth == 0 || node.isLeaf()) {
            return new MinimaxValue(col, node.getHeuristic(id));
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
