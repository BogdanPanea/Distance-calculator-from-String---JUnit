package ro.bogdanpanea.calculator;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PerformanceRepositoryTest {

    @Test
    public void addMethodPerformanceToList() throws DistanceFromExpressionException {

        String test = "-10 cm + 1 m - 10 mm";
        String unit = "dm";
        PerformanceRepository performanceRepository = new PerformanceRepository();

        performanceRepository.savePerformance(test);
        performanceRepository.savePerformance(test, unit);

        assertEquals(2, performanceRepository.getMethodPerformances().size());

    }
}
