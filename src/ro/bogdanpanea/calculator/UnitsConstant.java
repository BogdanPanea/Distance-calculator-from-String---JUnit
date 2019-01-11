package ro.bogdanpanea.calculator;

public enum UnitsConstant {

    mm(0.001), cm(0.01), dm(0.1), m(1), km(1000);

    private double unitConstant;

    UnitsConstant(double unitConstant) {
        this.unitConstant = unitConstant;
    }

    public double getUnitConstant() {
        return unitConstant;
    }
}
