import java.util.stream.IntStream;

public class MultiplicationMatrix {
    public static int getDigitSum(int number) {
        int crossTotal = 0;
        while (number > 0) {
            int digit = number % 10;
            crossTotal += digit;
            number /= 10;
        }
        return crossTotal;
    }

    public static boolean filter(int number) {
        return (number != 0 && number % 4 == 0 || number % 10 == 4 || getDigitSum(number) == 4);
    }

    public static void main(String[] args) {
        // @formatter:off
        IntStream.range(0, 100).forEach(i -> System.out.printf("%3s%s", filter(i) ? "*" : Integer.toString(i), i % 10 == 9 ? "\n" : ""));
        // @formatter:on
    }
}
