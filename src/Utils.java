import java.util.Arrays;
import java.util.HashMap;
import java.util.stream.IntStream;

public class Utils {
    public static <T, U> HashMap<T, U> zip(T[] keys, U[] values) {
        HashMap<T, U> result = new HashMap<T, U>();
        IntStream.range(0, keys.length).forEach(i -> result.put(keys[i], values[i]));
        return result;
    }
}
