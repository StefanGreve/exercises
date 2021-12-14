import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        int ticketCount = 0;

        while (ticketCount <= 0 || ticketCount > 10) {
            System.out.print("Ticket Count: ");
            ticketCount = Utils.SCANNER.nextInt();
        }

        System.out.print("Ticket Price: ");
        double ticketPrice = Utils.SCANNER.nextDouble();

        double amountPaid = TicketMachine.processPayment(ticketPrice, ticketCount);
        TicketMachine.printTicket(ticketCount);
        ArrayList<Double> change = TicketMachine.returnChange(amountPaid, ticketPrice, ticketCount);
        change.forEach((c) -> System.out.printf(c < 1 ? "Change: %4.2f CENT%n" : "Change: %4.0f EURO%n", c));

        TicketMachine.printNotice();
        Utils.SCANNER.close();
    }
}
