public class Sprinter {
    public static double f(int t) {
        return 9.5 * t;
    }

    public static double g(int t) {
        return 7 * t + 250;
    }

    /*
     * Hypothesis:
     *
     * x(t) = v(t) * t + x0
     *
     * x1(t) = 9.5m/s * t
     * x2(t) = 7m/s * t + 250m
     *
     * x1(t) = x2(t) --> (9.5m/s - 7m/s) * t = 250m --> t = 100s
     *
     * x1(t=100s) = x2(t=100s) = 950m --> Player A wins since v1(t) > v2(t)
     *
     */

    public static void main(String[] args) {
        int t = 0;
        double a = 0;
        double b = 0;

        while (true) {
            if (a >= 1000 || b >= 1000)
                break;
            a = f(t);
            b = g(t);
            System.out.printf("(t=%3ds | a=%7.2fm | b=%7.2fm)%n", t, a, b);
            t++;
        }
    }
}
