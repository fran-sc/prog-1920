class DiamondFlip {
    public static boolean create(int n) {
        if((n%2)==0 || n<1 || n>33)
            return false;

        int m = n/2 +1;
        for(int i=1, sp, j; i<=n; i++) {
            sp = m - Math.abs(m-i) - 1;
            for(j=1; j<=sp; j++) 
                System.out.print(" ");
            for(j=1; j<=n - sp*2; j++) 
                System.out.print("*");
            System.out.println();
        }

        return true;
    }
}