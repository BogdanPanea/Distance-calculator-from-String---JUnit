package ro.bogdanpanea.calculator;

public class Operand {

    private Integer distance;
    private String unit;
    private Double unitCoefficient;

    public Operand(Integer distance, String unit, double unitCoefficient) {
        this.distance = distance;
        this.unit = unit;
        this.unitCoefficient = unitCoefficient;
    }

    Integer getDistance() {
        return distance;
    }

    String getUnit() {
        return unit;
    }

    Double getUnitConstant() {
        return unitCoefficient;
    }

    @Override
    public String toString() {
        return "Operand{" +
                "distance=" + distance +
                ", unit='" + unit + '\'' +
                ", unitCoefficient=" + unitCoefficient +
                '}';
    }
}
