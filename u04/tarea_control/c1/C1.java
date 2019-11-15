public class C1 {
    public static void main(String[] args) {
        for(int i=0, j=0; i<100; i++, j++) {
            if(j==10) {
                j=0;
                System.out.println();
            }
            System.out.printf("%04d  ", i*i);
        }
        System.out.println();
    }
}