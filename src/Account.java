import java.util.UUID;

public class Account {
    private double balance = 0;
    private double interest = 0;
    private UUID id;

    public Account(double balance, double interest) {
        this.balance = balance;
        this.interest = interest;
        this.id = UUID.randomUUID();
    }

    public void depositBalance(double amount) {
        this.balance += amount;
    }

    public void disburseBalance(double amount) {
        this.balance -= amount;
    }

    public double getBalance() {
        return this.balance;
    }

    public void payInterest() {
        this.balance += (this.balance / 100 * this.interest);
    }

    public String getId() {
        return this.id.toString();
    }

    @Override
    public String toString() {
        return String.format("[%s] Balance: $%.2f\tInterest: %.2f%%", this.id, this.balance,
                this.interest);
    }
}
