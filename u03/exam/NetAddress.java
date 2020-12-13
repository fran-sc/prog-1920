public class NetAddress {
    private int b1;
    private int b2;
    private int b3;
    private int b4;

    public NetAddress(int b1, int b2, int b3, int b4) {
        this.b1 = b1;
        this.b2 = b2;
        this.b3 = b3;
        this.b4 = b4;
    }

    public NetAddress(String ip) {
        int p1 = ip.indexOf('.');
        int p2 = ip.indexOf('.',p1+1);
        int p3 = ip.indexOf('.',p2+1);
        this.b1 = Integer.parseInt(ip.substring(0,p1));
        this.b2 = Integer.parseInt(ip.substring(p1+1, p2));
        this.b3 = Integer.parseInt(ip.substring(p2+1, p3));
        this.b4 = Integer.parseInt(ip.substring(p3+1));
    }

    public int getB1() { return this.b1; }
    public int getB2() { return this.b2; }
    public int getB3() { return this.b3; }
    public int getB4() { return this.b4; }

    public String getNetwork(String mask) {
        NetAddress m = new NetAddress(mask);
        return  (this.b1&m.b1) + "." +
                (this.b2&m.b2) + "." +
                (this.b3&m.b3) + "." +
                (this.b4&m.b4); 
    }

    public static boolean sameNetwork(String ip1, String ip2, String mask) {
        return((new NetAddress(ip1)).getNetwork(mask).equals((new NetAddress(ip2)).getNetwork(mask)));
    }

    public static char getNetworkClass(String ip) {
        int n = new NetAddress(ip).getB1();
        char c;
        
        if(n<128) c='A';
        else if(n>=128 && n<192) c='B';
        else if(n>=192 && n<224) c='C';
        else c='D';
        
        return c;
    }

    public String toString() {
        return b1 + "." + b2 + "." + b3 + "." + b4;
    }
}
