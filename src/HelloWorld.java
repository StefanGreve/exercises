import java.util.Scanner;
import java.util.ArrayList;

public class HelloWorld {
    private static final Scanner _scanner = new Scanner(System.in);
    public static final double LOWERBOUND = 100.0;

    // @formatter:off
    public static final double EUR_USD = 1.22;    // US
    public static final double EUR_JPY = 126.5;   // Japan
    public static final double EUR_CHF = 1.08;    // Swiss
    public static final double EUR_SEK = 10.10;   // Sweden
    // @formatter:on

    public static final ArrayList<String> CURRENCIES = new ArrayList<String>() {
        {
            add("EUR-USD");
            add("EUR-JPY");
            add("EUR-CHF");
            add("EUR-SEK");
        }
    };

    public static void displayCurrencies() {
        for (int i = 0; i < HelloWorld.CURRENCIES.size(); i++) {
            System.out.printf("%d\t%s%n", i, HelloWorld.CURRENCIES.get(i));
        }
    }

    public static Boolean askYesNo(String question) {
        System.out.printf("%s [y/n] ", question);
        String answer = _scanner.next().toLowerCase(); // NOTE: doesn't catch carriage return character
        return (answer.equals("yes") || answer.equals("y"));
    }

    public static void main(String[] args) {
        Boolean repeat = true;
        displayCurrencies();
        System.out.print("Enter a budget: ");
        double budget = _scanner.nextDouble();

        while (repeat) {
            double conversion = 0;
            System.out.print("Amount to subtract: ");
            double amount = _scanner.nextDouble();

            System.out.print("Select a currency: ");
            int selection = _scanner.nextInt();

            switch (selection) {
                case 0:
                    conversion = amount * EUR_USD;
                    System.out.printf("Converted Amount: %.2f USD%n", conversion);
                    break;
                case 1:
                    conversion = amount * EUR_JPY;
                    System.out.printf("Converted Amount: %.2f JPY%n", conversion);
                    break;
                case 2:
                    conversion = amount * EUR_CHF;
                    System.out.printf("Converted Amount: %.2f CHF%n", conversion);
                    break;
                case 3:
                    conversion = amount * EUR_SEK;
                    System.out.printf("Converted Amount: %.2f SEK%n", conversion);
                    break;
                default:
                    throw new UnsupportedOperationException();
            }

            budget -= amount;
            System.out.printf("Budget Now: %.2f%n", budget);
            repeat = (budget >= LOWERBOUND) ? askYesNo("Do you want to convert more money from your budget?") : false;
        }

        _scanner.close();
    }
}
