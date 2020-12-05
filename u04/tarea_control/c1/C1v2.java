public class C1v2 {
    public static void main(String[] args) {
        for(int i=0; i<100; i++) {
            System.out.printf("%04d  ", i*i);
            if((i+1)%10==0) System.out.println();
        }
    }
}
