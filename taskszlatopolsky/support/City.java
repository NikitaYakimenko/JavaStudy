package taskszlatopolsky.support;

public class City {
    private int citizens;
    private double S;

    public City(int citizens, double S) {
        this.citizens = citizens;
        this.S = S;
    }

    public int getCitizens() {
        return this.citizens;
    }

    public double getS() {
        return this.S;
    }
}