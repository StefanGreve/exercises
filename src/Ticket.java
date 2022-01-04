public class Ticket {
    private String displayName;
    private double price;
    private int amount;
    public static final char currency = '€';

    public Ticket(String displayName, double price, int amount) {
        this.displayName = displayName;
        this.price = price;
        this.amount = amount;
    }

    public String getDisplayName() {
        return this.displayName;
    }

    public double getPrice() {
        return this.price;
    }

    public int getAmount() {
        return this.amount;
    }

    public void print() {
        System.out.printf("\nPrinting %d Ticket%s", this.amount, this.amount > 1 ? "s" : "");
        for (int i = 0; i < 8; i++) {
            System.out.print(" . ");
            Utils.sleep(100);
        }
        System.out.println("\n");
    }

    @Override
    public String toString() {
        return this.displayName + '\t' + "Price: " + this.price + currency + '\t' + "Amount: " + this.amount;
    }
}
