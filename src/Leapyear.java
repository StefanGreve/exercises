public class Leapyear {
    public static boolean isLeapyear(int year) {
        return !(year % 4 == 0 && year % 100 == 0) || (year % 400 == 0);
    }

    public static void assertTrue(boolean expression) {
        System.out.println(expression ? "\033[32m[o] Test Passed.\033[0m" : "\033[31m[!] Test Failed.\033[0m");
    }

    public static void assertFalse(boolean expression) {
        assertTrue(!expression);
    }

    public static void main(String[] args) {
        System.out.println("=== Rule 1 === ");
        assertTrue(isLeapyear(1980));
        assertTrue(isLeapyear(1972));
        assertTrue(isLeapyear(1720));
        assertTrue(isLeapyear(1992));
        System.out.println("=== Rule 2 === ");
        assertFalse(isLeapyear(1700));
        assertFalse(isLeapyear(1800));
        assertFalse(isLeapyear(1900));
        assertFalse(isLeapyear(2100));
        System.out.println("=== Rule 3 === ");
        assertTrue(isLeapyear(1600));
        assertTrue(isLeapyear(2000));
        assertTrue(isLeapyear(2400));
        assertTrue(isLeapyear(2800));
    }
}
