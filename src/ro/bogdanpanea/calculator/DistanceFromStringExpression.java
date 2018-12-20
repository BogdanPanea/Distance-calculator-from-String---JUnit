package ro.bogdanpanea.calculator;

import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DistanceFromStringExpression {

    private static Logger LOGGER = Logger.getLogger(Main.class.getName());
    private String expression;
    private List<Operand> operandsList = new ArrayList<>();
    private Operand operand;


    public DistanceFromStringExpression(String expression) throws DistanceFromExpressionException {

        if (!expression.equals("")) {
            this.expression = expression;
        } else {

            throw new DistanceFromExpressionException("Expresia trebuie sa nu fie vida !", "Expresie vida.");
        }
    }

    void generateOperandsList() {


        StringBuilder operand = new StringBuilder();
        int operator = 1;

        switch (expression.charAt(0)) {

            case '-':
                expression = expression.substring(1);
                operator = -1;
                break;
            case '+':
                expression = expression.substring(1);
                break;
        }

        for (int i = 0; i < expression.length(); i++) {

            switch (expression.charAt(i)) {
                case '+':
                    Integer number1 = operator * Integer.parseInt(operand.toString().replaceAll("\\D+", ""));
                    String string1 = operand.toString().replaceAll("[^A-Za-z]+", "");
                    operandsList.add(new Operand(number1, string1, UnitsConstant.valueOf(string1).getUnitConstant()));
                    operator = 1;
                    operand = new StringBuilder();
                    break;
                case '-':
                    Integer number2 = operator * Integer.parseInt(operand.toString().replaceAll("\\D+", ""));
                    String string2 = operand.toString().replaceAll("[^A-Za-z]+", "");
                    operandsList.add(new Operand(number2, string2, UnitsConstant.valueOf(string2).getUnitConstant()));
                    operator = -1;
                    operand = new StringBuilder();
                    break;
                default:
                    operand.append(expression.charAt(i));


            }
        }

        Integer number1 = operator * Integer.parseInt(operand.toString().replaceAll("\\D+", ""));
        String string1 = operand.toString().replaceAll("[^A-Za-z]+", "");
        operandsList.add(new Operand(number1, string1, UnitsConstant.valueOf(string1).getUnitConstant()));
    }

    void listOperands() {
        for (Operand operand : operandsList) {
            LOGGER.info(operand.toString());
        }
    }

    void sortOperandsByUnitConstants() {

        Collections.sort(operandsList, new UnitsCoefficientComparator());
    }

    String formatDistanceInLowestUnit() {

        double curentUnitConstant;
        String unit;

        sortOperandsByUnitConstants();

        curentUnitConstant = operandsList.get(0).getUnitConstant();
        unit = operandsList.get(0).getUnit();
        return returnDistanceInLowestUnit(curentUnitConstant, unit) + " " + unit;

    }

    int returnDistanceInLowestUnit(double curentUnitConstant, String unit) {

        int totalDistance = 0;

        for (Operand operand : operandsList) {
            totalDistance = (int) (totalDistance + operand.getDistance() * (operand.getUnitConstant() / curentUnitConstant));

        }

        return totalDistance;

    }

    String formatDistanceInCustomUnit(String newUnit) throws DistanceFromExpressionException {

        String curentUnit;
        int curentValue;

        if (!checkUnits(newUnit)) {
            throw new DistanceFromExpressionException("Unitate de masura invalida ! Doar mm, cm , dm , m si km sunt persmisi.", "Unitate de masura incorecta");

        }
        String result = formatDistanceInLowestUnit();
        curentUnit = result.replaceAll("[^A-Za-z]+", "");
        curentValue = Integer.parseInt(result.replaceAll("[^\\d-]", ""));

        if (curentUnit.equals(newUnit)) {
            return curentValue + " " + curentUnit;
        } else {

            if ((UnitsConstant.valueOf(curentUnit).getUnitConstant() - UnitsConstant.valueOf(newUnit).getUnitConstant()) > 0) {

                return (int) returnDistanceInCustomUnit(curentValue, curentUnit, newUnit) + " " + newUnit;
            } else {

                return returnDistanceInCustomUnit(curentValue, curentUnit, newUnit) + " " + newUnit;
            }


        }

    }

    double returnDistanceInCustomUnit(int curentValue, String curentUnit, String newUnit) {

        double newUnitValue;

        double factor = UnitsConstant.valueOf(curentUnit).getUnitConstant() / UnitsConstant.valueOf(newUnit).getUnitConstant();
        newUnitValue = factor * (double) curentValue;
        System.out.println(UnitsConstant.valueOf(curentUnit).getUnitConstant() + " " + UnitsConstant.valueOf(newUnit).getUnitConstant() + " " + factor);

        return newUnitValue;
    }

    private boolean checkUnits(String unit) {

        for (UnitsConstant c : UnitsConstant.values()) {

            if (c.name().equals(unit)) {

                return true;
            }
        }

        return false;
    }
}
