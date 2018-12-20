package ro.bogdanpanea.calculator;

import java.util.logging.Logger;

public class Main {

    private static Logger LOGGER = Logger.getLogger(Main.class.getName());

    public static void main(String[] args) {


        String test = "-10 cm + 1 m - 10 mm";
        String unit = "dm";

        printDistanceInLowestUnit(test);
        LOGGER.info( "--------CustomUnit---------" );
        printDistanceInCustomUnit (test, unit);


    }

    static void printDistanceInLowestUnit (String expression) {

        try {

            DistanceFromStringExpression calculator = new DistanceFromStringExpression( expression );
            calculator.generateOperandsList();
            LOGGER.info( calculator.formatDistanceInLowestUnit());

        } catch (DistanceFromExpressionException e) {

            e.printStackTrace();
        }


    }

    static void printDistanceInCustomUnit (String expression, String unit) {

        try {

            DistanceFromStringExpression calculator = new DistanceFromStringExpression( expression );
            calculator.generateOperandsList();
            LOGGER.info( calculator.formatDistanceInCustomUnit(unit));

        } catch (DistanceFromExpressionException e) {

            e.printStackTrace();
        }


    }
}
