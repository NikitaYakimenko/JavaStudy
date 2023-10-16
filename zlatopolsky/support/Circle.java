package zlatopolsky.support;

public class Circle {
    private double internalR;
    private double externalR;

    public Circle(double internalR, double externalR) {
        this.internalR = internalR;
        this.externalR = externalR;
    }

    public double getInternalR() {
        return internalR;
    }

    public double getExternalR() {
        return externalR;
    }

    public double getRingS(double internalR, double externalR) {
        double internalS = Math.PI * Math.pow(internalR, 2);
        double externalS = Math.PI * Math.pow(externalR, 2);

        return externalS - internalS;
    }

}
