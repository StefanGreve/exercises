import java.util.Arrays;
import java.util.stream.IntStream;

public class Primes {
    public static int[] sieveOfEratosthenes(int n) {
        boolean[] primes = new boolean[n];
        Arrays.fill(primes, true);

        for (int i = 2; i < Math.sqrt(n); i++) {
            if (primes[i]) {
                for (int j = (int) Math.pow(i, 2); j < n; j += i) {
                    primes[j] = false;
                }
            }
        }

        return IntStream.range(0, n).filter(i -> primes[i] == true).toArray();
    }

    public static void main(String[] args) {
        Arrays.stream(sieveOfEratosthenes(100)).forEach(p -> System.out.println(p));
    }
}
