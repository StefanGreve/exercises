import java.util.stream.IntStream;

public class HelloWorld {
    public static void main(String[] args) {
        IntStream.range(0, 19).filter(x -> x % 2 == 1).forEach(System.out::println);
    }
}
