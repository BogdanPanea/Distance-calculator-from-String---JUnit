package ro.bogdanpanea.calculator;

import java.util.logging.Logger;

public class Main {

    private static Logger LOGGER = Logger.getLogger(Main.class.getName());

    public static void main(String[] args) {



        String test= "10 cm + 1 m - 10 mm";
        SumFromStringExpression calculator = new SumFromStringExpression( test );
        calculator.generateOperandsList();
        calculator.listOperands();
        LOGGER.info( "--------SortedByUnit---------" );
        calculator.sortListOperandsByUnit();
        calculator.listOperands();
        LOGGER.info( calculator.returnDistanceInLowestUnit());
        LOGGER.info( calculator.returnDistanceInCustomUnit("dm"));
    }
}
