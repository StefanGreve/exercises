import java.util.Scanner;
import java.util.HashMap;

public class HelloWorld {
    public static final HashMap<Integer, String> DESTINATIONS = new HashMap<Integer, String>() {
        {
            put(0, "Hamburg");
            put(1, "Wolfsburg");
            put(2, "Hannover");
            put(3, "Braunschweig");
            put(4, "Stendal");
            put(5, "Spandau");
        }
    };

    public static void displayTravelDestinations() {
        HelloWorld.DESTINATIONS.forEach((k, v) -> System.out.printf("%d\t%s%n", k, v));
    }

    public static void main(String[] args) {
        System.out.println("Greetings mortal human beings.");

        try (Scanner scanner = new Scanner(System.in)) {
            int travelTime = 0;
            displayTravelDestinations();
            System.out.print("Select your destination: ");
            int selection = scanner.nextInt();

            travelTime += (DESTINATIONS.get(selection) == "Spandau") ? 2 : 34;

            travelTime += (DESTINATIONS.get(selection) == "Stendal") ? 16 : 6;

            switch (selection) {
                // Wolfsburg
                case 1:
                    travelTime += 29;
                    break;
                // Hannover
                case 2:
                    travelTime += 63;
                    break;
                // Braunschweig
                case 3:
                    travelTime += 50;
                    break;
            }

            System.out.printf("Total travel time: %d%n", travelTime);
        }
    }
}
