public class HelloWorld {
    public static void main(String[] args) {
        Account acc = new Account(100, 2);
        acc.depositBalance(20);
        acc.payInterest();
        System.out.println(acc);
    }
}
