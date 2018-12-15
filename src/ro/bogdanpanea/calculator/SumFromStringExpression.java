package ro.bogdanpanea.calculator;

import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SumFromStringExpression {

    private static Logger LOGGER = Logger.getLogger( Main.class.getName() );
    private String expression;
    private List<Operand> operandsList = new ArrayList<>();
    private Operand operand;


    private static final Map<String, Double> unitsConstant;

    static {

        unitsConstant = new HashMap<>();
        unitsConstant.put( "mm", 0.001 );
        unitsConstant.put( "cm", 0.01 );
        unitsConstant.put( "dm", 0.1 );
        unitsConstant.put( "m", 1.0 );
        unitsConstant.put( "km", 1000.0 );
    }


    public SumFromStringExpression(String expression) {

        try {
            if (!expression.equals( "" )) {
                this.expression = expression;
            } else {

                throw new SumStringFromExpressionException( "Expresia trebuie sa nu fie vida !", "Expresie vida." );
            }
        } catch (SumStringFromExpressionException e) {

            LOGGER.log( Level.SEVERE, e.getMessage() );
        }
    }

    void generateOperandsList() {


        StringBuilder operand = new StringBuilder();
        int operator = 1;

        for (int i = 0; i < expression.length(); i++) {

            switch (expression.charAt( i )) {
                case '+':
                    Integer number1 = operator * Integer.parseInt( operand.toString().replaceAll( "\\D+", "" ) );
                    String string1 = operand.toString().replaceAll( "[^A-Za-z]+", "" );
                    operandsList.add( new Operand( number1, string1, unitsConstant.get( string1 ) ) );
                    operator = 1;
                    operand = new StringBuilder();
                    break;
                case '-':
                    Integer number2 = operator * Integer.parseInt( operand.toString().replaceAll( "\\D+", "" ) );
                    String string2 = operand.toString().replaceAll( "[^A-Za-z]+", "" );
                    operandsList.add( new Operand( number2, string2, unitsConstant.get( string2 ) ) );
                    operator = -1;
                    operand = new StringBuilder();
                    break;
                default:
                    operand.append( expression.charAt( i ) );


            }
        }

        Integer number1 = operator * Integer.parseInt( operand.toString().replaceAll( "\\D+", "" ) );
        String string1 = operand.toString().replaceAll( "[^A-Za-z]+", "" );
        operandsList.add( new Operand( number1, string1, unitsConstant.get( string1 ) ) );
    }

    void listOperands() {
        for (Operand operand : operandsList) {
            LOGGER.info( operand.toString() );
        }
    }

    void sortListOperandsByUnit() {

        Collections.sort( operandsList, new UnitsConstantComparator() );
    }

    String returnDistanceInLowestUnit() {

        double totalDistance = 0;

        sortListOperandsByUnit();

        Double curentUnitConstan = operandsList.get( 0 ).getUnitConstant();
        String unit = operandsList.get( 0 ).getUnit();

        for (Operand operand : operandsList) {
            totalDistance = totalDistance + (double) operand.getDistance() * (operand.getUnitConstant() / curentUnitConstan);

        }

        return (int) totalDistance + " " + unit;
    }

    String returnDistanceInCustomUnit(String unit) {

        String curentUnit;
        int curentValue;
        double newUnitValue;

        try {

            if (checkUnits( unit )) {
                String result = returnDistanceInLowestUnit();
                curentUnit = result.replaceAll( "[^A-Za-z]+", "" );
                curentValue = Integer.parseInt( result.replaceAll( "[^\\d-]", "" ) );

                if (curentUnit.equals( unit )) {
                    return curentValue + " " + curentUnit;
                } else {
                    double factor = unitsConstant.get( curentUnit ) / unitsConstant.get( unit );
                    newUnitValue = factor * (double) curentValue;
                    System.out.println(unitsConstant.get( curentUnit ) + " "  +  unitsConstant.get( unit)  + " " + factor );
                }
                return newUnitValue + " " + unit;
            } else {

                throw new SumStringFromExpressionException( "Unitate de masura invalida ! Doar mm, cm , dm , m si km sunt persmisi.", "Unitate de masura incorecta" );
            }
        } catch (SumStringFromExpressionException e) {

            LOGGER.log( Level.SEVERE, e.getMessage() );
            return null;
        }
    }

    private static boolean checkUnits(String unit) {
        return unitsConstant.containsKey( unit );
    }
}
