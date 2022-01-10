
import java.util.Scanner;
import java.util.stream.IntStream;
import java.util.Collections;

public class HelloWorld {
    public static String repeat(String string, int k) {
        return String.join("", Collections.nCopies(k, string));
    }

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Size: ");
            int size = scanner.nextInt();

            //@formatter:off
            IntStream.range(0, size).forEach(i -> System.out.printf("%s%n", (i == 0 || i == size - 1) ? repeat("* ", size) : String.join("", new String[]{"*", repeat(" ", 2 * size - 3), "*"})));
            //@formatter:on
        }
    }
}
