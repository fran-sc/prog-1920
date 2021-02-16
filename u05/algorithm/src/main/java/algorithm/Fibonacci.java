package algorithm;

public class Fibonacci {
    public static long fibonacci_1(long n) {
        if (n < 2)
            return n;
        return fibonacci_1(n - 1) + fibonacci_1(n - 2);
    }

    public static long fibonacci_2(long n) {
        if (n < 2)
            return n;

        long a = 0, b = 1, fib = 0;
        for (int i = 1; i < n; i++) {
            fib = a + b;
            a = b;
            b = fib;
        }

        return fib;
    }
}
