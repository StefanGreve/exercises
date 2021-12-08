public class HelloWorld {
    public static double getCubeVolume(double a) {
        return Math.pow(a, 3);
    }

    public static double getCuboidVolume(double a, double b, double c) {
        return a * b * c;
    }

    public static double getPyramidVolume(double a, double h) {
        return Math.pow(a, 2) * h / 3;
    }

    public static double getSphereVolume(double r) {
        return 4 / 3 * Math.pow(r, 3) * Math.PI;
    }

    public static void main(String[] args) {
        System.out.println(getCubeVolume(2));
        System.out.println(getCuboidVolume(2, 2, 2));
        System.out.println(getPyramidVolume(2, 5));
        System.out.println(getSphereVolume(4));
    }
}
