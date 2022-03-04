public class Cargo {
    private String name;

    private double weight;

    private int count;

    public Cargo(String name, double weight, int count) {
        this.name = name;
        this.weight = weight;
        this.count = count;
    }

    public String getName() {
        return this.name;
    }

    public double getWeight() {
        return this.weight;
    }

    public int getCount() {
        return this.count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public double getTotalWeight() {
        return this.weight * this.count;
    }
}
