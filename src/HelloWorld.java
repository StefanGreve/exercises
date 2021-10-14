public class HelloWorld {
    public static int factorial(int n) {
        return (n == 0 || n == 1) ? 1 : n * factorial(n - 1);
    }

    public static void main(String[] args) {
        String sequence = " 1 * 2 * 3 * 4 * 5 ";
        for (int i = 0; i <= 5; i++) {
            int pos = (i > 0) ? (i * 4 - 1) : 0;
            System.out.printf("%d!%3s=%-20s=%6d\n", i, " ", sequence.substring(0, pos), factorial(i));
        }
    }
}
