package ro.bogdanpanea.calculator;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class PerformanceRepository {

    private static Logger LOGGER = Logger.getLogger(Main.class.getName());

    private List<MethodPerformance> methodPerformances = new ArrayList<>();

    public void addMethodPerformanceToList(MethodPerformance p) {
        this.methodPerformances.add(p);
    }

    public List<MethodPerformance> getMethodPerformances() {
        return methodPerformances;
    }

    public long calculateExecutionTime(String expression) throws DistanceFromExpressionException {

        DistanceFromStringExpression calculator = new DistanceFromStringExpression(expression);
        calculator.generateOperandsList();


        long startTime = System.nanoTime();
        calculator.formatDistanceInLowestUnit();
        long endTime = System.nanoTime();

        long duration = (endTime - startTime);

        return duration;
    }

    public long calculateExecutionTime(String expression, String unit) throws DistanceFromExpressionException {

        DistanceFromStringExpression calculator = new DistanceFromStringExpression(expression);
        calculator.generateOperandsList();


        long startTime = System.nanoTime();
        calculator.formatDistanceInCustomUnit(unit);
        long endTime = System.nanoTime();

        long duration = (endTime - startTime);

        return duration;
    }

    public void savePerformance(String test) throws DistanceFromExpressionException {

        long t = calculateExecutionTime(test);
        addMethodPerformanceToList(new MethodPerformance(MethodType.lowestUnit.name(), test, t));

    }

    public void savePerformance(String test, String unit) throws DistanceFromExpressionException {

        long t = calculateExecutionTime(test, unit);
        addMethodPerformanceToList(new MethodPerformance(MethodType.customUnit.name(), test, t));

    }

    @Override
    public String toString() {
        return "PerformanceRepository{" +
                "methodPerformances=" + methodPerformances +
                '}';
    }
}
