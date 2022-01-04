import java.util.ArrayList;

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

    public static double processPayment(Ticket ticket) {
        double amountPaid = 0.0;
        double amountPayable = ticket.getPrice() * ticket.getAmount();

        while (amountPaid < amountPayable) {
            System.out.printf("Amount Due: %.2f\n", (amountPayable - amountPaid));
            System.out.print("Insert another coin: ");
            double coinInserted = Utils.SCANNER.nextDouble();
            amountPaid += coinInserted;
        }

        return amountPaid;
    }

    public static ArrayList<Double> returnChange(Ticket ticket, double amountPaid) {
        int i = 0;
        double balance = amountPaid - (ticket.getPrice() * ticket.getAmount());
        ArrayList<Double> change = new ArrayList<Double>();

        while (balance > 0) {
            while ((int) Math.floor(balance / COINS.get(i)) < 1) {
                i++;
            }

            double coin = COINS.get(i);
            balance -= coin;
            balance = Utils.round(balance, 2);
            change.add(coin);
        }

        return change;
    }

    public static void printNotice() {
        System.out.printf("%n%sDon't forget to take out your ticket and validate it before your departure!%s%n",
                Color.YELLOW, Color.RESETALL);
    }
}
