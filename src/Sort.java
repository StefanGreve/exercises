import java.util.Arrays;
import java.util.Scanner;

public class Sort {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Enter a sequence of whitespace-separated characters to sort: ");
            String[] array = scanner.nextLine().split(" ");
            Arrays.sort(array, (String a, String b) -> (int) a.charAt(0) - (int) b.charAt(0));
            Arrays.stream(array).forEach(s -> System.out.printf("%s ", s));
        }
    }
}
