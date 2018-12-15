package ro.bogdanpanea.calculator;

public class Operand {

    private Integer distance;
    private String unit;
    private Double unitConstan;

    public Operand(Integer distance, String unit, double unitConstan) {
        this.distance = distance;
        this.unit = unit;
        this.unitConstan = unitConstan;
    }

    Integer getDistance() {
        return distance;
    }

    String getUnit() {
        return unit;
    }

    Double getUnitConstant() {
        return unitConstan;
    }

    @Override
    public String toString() {
        return "Operand{" +
                "distance=" + distance +
                ", unit='" + unit + '\'' +
                ", unitConstan=" + unitConstan +
                '}';
    }
}
