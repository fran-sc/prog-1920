package c4.tree;

import c4.Board;
import java.util.Random;

public class TNode {
    private static final double REW_N4 = 1E6;
    private static final double REW_N3 = 1;
    private static final double REW_N4_OP = -1E4;
    private static final double REW_N3_OP = -5E2;

    private Board board;
    private TNode parent;
    private TNode[] children;

    public TNode(Board board, TNode parent) {
        this.board = board;
        this.parent = parent;
        children = new TNode[board.getCols()]; // one possible child per column
    }

    public Board getElement() {
        return this.board;
    }
    public TNode getParent() {
        return this.parent;
    }
    public TNode[] getChildren() {
        return this.children;
    }
    public void addChildren(int index, TNode n) {
        n.parent = this;
        this.children[index] = n;
    }
    public boolean isLeaf() {
        for (int i = 0; i < this.children.length; i++)
            if (children[i] != null)
                return false;
        return true;
    }

    @Override
    public String toString() {
        String s = this.board.toString();
        for (int i = 0; i < this.children.length; i++)
            if (children[i] != null)
                s += i + ":\n" + children[i].toString();
        return s;
    }
    
    // Get position value
    public double getHeuristic(int id) {
        int n3 = board.countWindows(4, 3, id);
        int n4 = board.countWindows(4, 4, id);
        int n3_op = board.countWindows(4, 3, id % 2 + 1);
        int n4_op = board.countWindows(4, 4, id % 2 + 1);
        double delta = (new Random()).nextDouble() / 1E3;

        return n4 * REW_N4 + n3 * REW_N3 + n4_op * REW_N3_OP + n3_op * REW_N3_OP + delta;
    }
}
