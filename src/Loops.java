public class Loops {
    public static void a() {
        for (int i = 99; i > 8; i--) {
            System.out.println(i);
        }
    }

    public static void b() {
        for (int i = 1; i <= 20; i++) {
            System.out.println((int) Math.pow(i, 2));
        }
    }

    public static void c() {
        for (int i = 1; i <= 51; i++) {
            System.out.println(2 * i);
        }
    }

    public static void d() {
        for (int i = 2; i <= 32; i = 2 + i) {
            System.out.println((int) Math.pow(i, 2));
        }
    }

    public static void e() {
        for (int i = 2; i <= 15; i++) {
            System.out.println((int) Math.pow(2, i));
        }
    }

    public static void main(String[] args) {
        System.out.println("LOOP A");
        a();
        System.out.println("LOOP B");
        b();
        System.out.println("LOOP C");
        c();
        System.out.println("LOOP D");
        d();
        System.out.println("LOOP E");
        e();
    }
}
