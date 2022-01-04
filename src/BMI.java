import java.util.Scanner;

public class BMI {
    public static double computeBmi(double weight, double height) {
        return weight / Math.pow(height, 2) * 10_000;
    }

    public static String evaluate(char gender, double bmi) {
        // @formatter:off
        return ((gender == 'm' && bmi < 20) || (gender == 'f' && bmi < 19)) ? "underweight"
             : ((gender == 'm' && bmi < 25) || (gender == 'f' && bmi < 24)) ? "normal"
             : "overweight";
        // @formatter:on
    }

    public static void main(String[] args) {
        System.out.println("BASIC USAGE");
        System.out.println("Gender = ['m'|'f'], Weight = [kg], Height = [cm]");

        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Gender: ");
            char gender = scanner.nextLine().charAt(0);
            System.out.print("Weight: ");
            double weight = scanner.nextDouble();
            System.out.print("Height: ");
            double height = scanner.nextDouble();

            double bmi = computeBmi(weight, height);
            String result = evaluate(gender, bmi);
            System.out.printf("You're %s (BMI=%.2f)%n", result, bmi);
        }
    }
}
