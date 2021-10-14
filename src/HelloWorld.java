public class HelloWorld {
    public static void main(String[] args) {
        // treetop
        for (int i = 6; i >= 0; i--) {
            System.out.print(new String(new char[i]).replace("\0", " "));
            System.out.println(new String(new char[-2 * i + 13]).replace("\0", "*"));
        }
        // stem
        for (int i = 0; i < 3; i++) {
            System.out.printf("%8s\n", "***");
        }
    }
}
