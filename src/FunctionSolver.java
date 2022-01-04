import java.util.Scanner;

public class FunctionSolver {
    private static final Scanner _SCANNER = new Scanner(System.in);

    public static double f(double x) {
        double y = 0;
        if (x <= 0) {
            y = Math.pow(Math.E, x);
            System.out.println("exponential");
        } else if (0 < x && x <= 3) {
            y = Math.pow(x, 2) + 1;
            System.out.println("quadratic");
        } else {
            y = 2 * x + 4;
            System.out.println("linear");
        }
        return y;
    }

    public static Boolean askYesNo(String question) {
        System.out.printf("%s [y/n] ", question);
        String answer = _SCANNER.next().toLowerCase();
        return (answer.equals("yes") || answer.equals("y"));
    }

    public static void main(String[] args) {
        Boolean repeat = true;

        while (repeat) {
            System.out.print("x: ");
            double y = f(_SCANNER.nextDouble());
            System.out.printf("Result: %.3f%n", y);
            repeat = askYesNo("Wanna crunch the numbers again?");
        }
    }
}
