public class Weapon {
    private String name;

    private double damage;

    private double accuracy;

    public Weapon(String name, double damage, double accuracy) {
        this.name = name;
        this.damage = damage;
        this.accuracy = accuracy;
    }

    public String getName() {
        return this.name;
    }

    public double getDamage() {
        return this.damage;
    }

    public double getAccuracy() {
        return this.accuracy;
    }
}
