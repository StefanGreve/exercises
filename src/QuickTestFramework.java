public class QuickTestFramework {
    public static void assertTrue(boolean expression) {
        System.out.println(expression ? "\033[32m[o] Test Passed.\033[0m" : "\033[31m[!] Test Failed.\033[0m");
    }

    public static void assertFalse(boolean expression) {
        assertTrue(!expression);
    }

    public static <T> void assertEqual(T expected, T actual) {
        assertTrue(expected.equals(actual));
    }
}
