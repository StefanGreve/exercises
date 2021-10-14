import java.util.ArrayList;

public class HelloWorld {
    public static float fahrenheitToCelsius(int fahrenheit) {
        return (fahrenheit - 32F) * 5 / 9;
    }

    public static void main(String[] args) {
        ArrayList<Integer> temperatures = new ArrayList<Integer>() {
            {
                add(-20);
                add(-10);
                add(0);
                add(20);
                add(30);
            }
        };
        System.out.println("Fahrenheit  |   Celsius");
        System.out.println("------------|----------");

        for (int temp : temperatures) {
            System.out.printf("%-12d|%10.2f\n", temp, fahrenheitToCelsius(temp));
        }

    }
}
