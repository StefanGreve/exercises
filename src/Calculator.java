import java.util.Scanner;

public class Calculator {
    public static String formatNumber(double num) {
        return (num % 1 == 0) ? String.format("%d", (int) num) : String.format("%.3f", num);
    }

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            double result = 0;
            System.out.print("Enter an operator ['+', '-', '*', '/']: ");
            char op = scanner.next().charAt(0);
            System.out.print("Enter number #1: ");
            double num1 = scanner.nextDouble();
            System.out.print("Enter number #2: ");
            double num2 = scanner.nextDouble();

            switch (op) {
                case '+':
                    result = num1 + num2;
                    break;
                case '-':
                    result = num1 - num2;
                    break;
                case '*':
                    result = num1 * num2;
                    break;
                case '/':
                    result = num1 / num2;
                    break;
            }

            System.out.println(String.format("%s %c %s = %s", formatNumber(num1), op, formatNumber(num2), formatNumber(result)));
        }
    }
}
