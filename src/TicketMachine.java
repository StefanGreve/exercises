import java.util.ArrayList;
import java.util.Scanner;

class TicketMachine {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            final ArrayList<Double> acceptedCoins = new ArrayList<Double>() {
                {
                    add(2.0); // 2 euro
                    add(1.0); // 1 euro
                    add(0.5); // 50 cent
                    add(0.2); // 20 cent
                    add(0.1); // 10 cent
                    add(0.05); // 5 cent
                    add(0.02); // 2 cent
                    add(0.01); // 1 cent
                }
            };

            double amountPaid = 0.0;
            System.out.print("Ticket Price: ");
            double amountPayable = scanner.nextDouble();

            // #region insert coins
            while (amountPaid < amountPayable) {
                System.out.printf("Amount Due: %f\n", (amountPayable - amountPaid));
                System.out.print("Insert another coin: ");
                double coinInserted = scanner.nextDouble();
                amountPaid += coinInserted;
            }
            // #endregion

            // #regionFahrscheinausgabe
            System.out.print("\nPrinting Ticket");
            for (int i = 0; i < 8; i++) {
                System.out.print(" . ");
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            // #endregion

            System.out.println("\n\n");

            // #region return change (if any)
            double balance = amountPaid - amountPayable;

            int i = 0;
            while (balance > 0) {

                while ((int) Math.floor(balance / acceptedCoins.get(i)) < 1) {
                    i++;
                }

                double coin = acceptedCoins.get(i);
                balance -= coin;
                balance = Math.floor(balance * 100 + 0.5) / 100;
                System.out.printf("Ejected coin: %.2f\n", coin);
            }
            // #endregion

            System.out.println();
            System.out.println("Don't forget to take out your ticket and validate it before your departure!");
        }
    }
}
