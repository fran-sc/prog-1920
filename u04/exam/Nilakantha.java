public class Nilakantha {
    public static double piNilakantha(int n) {
        double pi=3.0, s=1.0;
        
        for(int i=1; i<=n; i++, s*=-1) {
            long i2=2*i;
            pi += s*4/(i2*(i2+1)*(i2+2));
        }
            
        return pi;
    }

    public static void main(String[] args) {
        System.out.println(piNilakantha(-2));
        System.out.println(piNilakantha(0));
        System.out.println(piNilakantha(1));
        System.out.println(piNilakantha(4));
        System.out.println(piNilakantha(1000000));
    }
}
