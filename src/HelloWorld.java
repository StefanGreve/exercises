import java.util.Scanner;
import java.util.stream.IntStream;
import java.util.Collections;

public class HelloWorld {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Height: ");
            int height = scanner.nextInt();
            System.out.print("Width: ");
            int width = scanner.nextInt();

            //@formatter:off
            IntStream.range(0, height).forEach(h -> System.out.printf("%" + width * height + "s%n", String.join("", Collections.nCopies(width * (h + 1), "*"))));
            //@formatter:on
        }
    }
}
