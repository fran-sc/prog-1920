package zork;

public enum Dir { 
    N(0), S(1), E(2), O(3); 
    public int id;
    Direccion(int id) { this.id = id; }
}