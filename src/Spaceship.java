import java.util.ArrayList;
import java.util.Calendar;

public class Spaceship {
    private String captain;

    private int yearsOfService;

    private double powerSupply = 100;

    private double protectiveShield = 100;

    private double lifeSupportShield = 100;

    private double shell = 100;

    private ArrayList<Weapon> weapons;

    private ArrayList<Cargo> cargo;

    public Spaceship(String captain, int firstYearOfService, ArrayList<Weapon> weapons, ArrayList<Cargo> cargo) {

        this.captain = captain;
        this.yearsOfService = Calendar.getInstance().get(Calendar.YEAR) - firstYearOfService;
        this.weapons = weapons;
        this.cargo = cargo;
    }

    public String getCaptain() {
        return this.captain;
    }

    public int getYearsOfService() {
        return this.yearsOfService;
    }

    public double getPowerSupply() {
        return this.powerSupply;
    }

    public void setPowerSupply(double powerSupply) {
        this.powerSupply = powerSupply;
    }

    public double getProtectiveShield() {
        return this.protectiveShield;
    }

    public void setProtectiveShield(double protectiveShield) {
        this.protectiveShield = protectiveShield;
    }

    public double getLifeSupportShield() {
        return this.lifeSupportShield;
    }

    public void setLifeSupportShield(double lifeSupportShield) {
        this.lifeSupportShield = lifeSupportShield;
    }

    public double getShell() {
        return this.shell;
    }

    public void setShell(double shell) {
        this.shell = shell;
    }

    public ArrayList<Cargo> getCargo() {
        return this.cargo;
    }

    public ArrayList<Weapon> getWeapons() {
        return this.weapons;
    }

    public void removeCargo(Cargo cargo) {
        this.cargo.stream()
                .filter(c -> c.getName().equals(cargo.getName()))
                .map(c -> this.cargo.remove(c));
    }

    public void addCargo(Cargo cargo) {
        this.cargo.add(cargo);
    }
}
