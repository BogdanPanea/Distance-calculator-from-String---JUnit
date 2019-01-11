package ro.bogdanpanea.calculator;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Main {

    private static Logger LOGGER = Logger.getLogger(Main.class.getName());

    public static void main(String[] args) {


        String test = "-10 cm + 1 m - 10 mm";
        String unit = "dm";


        try {

            PerformanceRepository performanceRepository = new PerformanceRepository();
            DistanceFromStringExpression calculator = new DistanceFromStringExpression(test);

            performanceRepository.savePerformance(test);
            performanceRepository.savePerformance(test, unit);

            LOGGER.info(performanceRepository.getMethodPerformances().toString());

            calculator.printDistanceInLowestUnit(test);
            LOGGER.info("--------CustomUnit---------");
            calculator.printDistanceInCustomUnit(test, unit);


        } catch (DistanceFromExpressionException e) {

            LOGGER.log(Level.SEVERE, e.getMessage());
        }

    }


}
