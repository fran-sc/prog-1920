class Diamond {
    public static boolean create(int n) {
        if((n%2)==0 || n<1 || n>33)
            return false;

        int m = n/2 +1;
        for(int i=1, sp, j; i<=n; i++) {
            sp = Math.abs(m-i);
            for(j=1; j<=sp; j++) 
                System.out.print(" ");
            for(j=1; j<=(m-sp)*2-1; j++) 
                System.out.print("*");
            System.out.println();
        }

        return true;
    }
}