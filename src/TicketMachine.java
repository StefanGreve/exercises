import java.util.ArrayList;
import java.util.Scanner;

class TicketMachine {
    public static final ArrayList<Double> COINS = new ArrayList<Double>() {
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

    public static double processPayment(double ticketPrice, int ticketCount) {
        double amountPaid = 0.0;
        double amountPayable = ticketPrice * ticketCount;

        try (Scanner scanner = new Scanner(System.in)) {
            while (amountPaid < amountPayable) {
                System.out.printf("Amount Due: %f\n", (amountPayable - amountPaid));
                System.out.print("Insert another coin: ");
                double coinInserted = scanner.nextDouble();
                amountPaid += coinInserted;
            }
        }

        return amountPaid;
    }

    public static void printTicket(int ticketCount) {
        System.out.printf("\nPrinting %d Ticket%s", ticketCount, ticketCount > 1 ? "s" : "");
        for (int i = 0; i < 8; i++) {
            System.out.print(" . ");
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("\n\n");
    }

    public static ArrayList<Double> returnChange(double amountPaid, double ticketPrice, int ticketCount) {
        int i = 0;
        double balance = amountPaid - (ticketPrice * ticketCount);
        ArrayList<Double> change = new ArrayList<Double>();

        while (balance > 0) {
            while ((int) Math.floor(balance / COINS.get(i)) < 1) {
                i++;
            }

            double coin = COINS.get(i);
            balance -= coin;
            balance = Math.floor(balance * 100 + 0.5) / 100;
            change.add(coin);
        }

        return change;
    }

    public static void printNotice() {
        System.out.printf("%n%sDon't forget to take out your ticket and validate it before your departure!%s%n",
                Color.YELLOW, Color.RESETALL);
    }
}
