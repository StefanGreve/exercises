import java.util.Scanner;

public class HelloWorld {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("What's your name? ");
            String name = scanner.nextLine();

            System.out.print("How old are you? ");
            int age = scanner.nextInt();

            System.out.printf("You're %s and %d years old.", name, age);
        }
    }
}
