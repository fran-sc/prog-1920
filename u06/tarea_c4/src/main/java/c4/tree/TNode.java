package c4.tree;

public class TNode {
    private TBoard tb;
    private TNode parent;
    private TNode[] children;

    public TNode(TBoard tb, TNode parent) {
        this.tb = tb;
        this.parent = parent;
        children = new TNode[tb.getBoard()[0].length]; // one possible child per column
    }

    public TBoard getElement() {
        return this.tb;
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
        String s = this.tb.toString();
        for (int i = 0; i < this.children.length; i++)
            if (children[i] != null)
                s += i + ":\n" + children[i].toString();
        return s;
    }
}
