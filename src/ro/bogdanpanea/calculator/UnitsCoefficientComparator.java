package ro.bogdanpanea.calculator;

import java.util.Comparator;

public class UnitsCoefficientComparator implements Comparator<Operand> {

    @Override
    public int compare(Operand operand1, Operand operand2) {
        return operand1.getUnitConstant().compareTo( operand2.getUnitConstant() );
    }
}
