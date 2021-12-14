import java.math.BigDecimal;
import java.math.RoundingMode;

public class Utils {
    public static void sleep(int ms) {
        try {
            Thread.sleep(ms);
        } catch (InterruptedException exception) {
            exception.printStackTrace();
        }
    }

    public static double round(double number, int places) {
        BigDecimal value = BigDecimal.valueOf(number);
        value.setScale(places, RoundingMode.HALF_UP);
        return value.doubleValue();
    }
}
