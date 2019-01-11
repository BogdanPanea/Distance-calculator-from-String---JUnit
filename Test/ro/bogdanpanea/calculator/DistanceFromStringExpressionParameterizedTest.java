package ro.bogdanpanea.calculator;

import org.junit.*;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class DistanceFromStringExpressionParameterizedTest {


    private String input;
    private String expectedResult;
    private DistanceFromStringExpression distanceFromStringExpression;

    public DistanceFromStringExpressionParameterizedTest(String input, String expectedResult) {
        this.input = input;
        this.expectedResult = expectedResult;
    }

    @Parameterized.Parameters
    public static Collection stringExpresion() {
        return Arrays.asList(new Object[][]{
                {"1m+4dm-345cm", "-205 cm"},
                {"-1m+4dm-345cm", "-405 cm"},
                {"24m+3mm-67cm", "23333 mm"},
                {"5cm-20mm-2cm", "10 mm"},
                {"5m+4dm-1km", "-9946 dm"}
        });
    }

    @Test
    public void testDistanceFromStringExpression() throws DistanceFromExpressionException {
        System.out.println("Expression is : " + input);
        System.out.println("Expected is : " + expectedResult);
        distanceFromStringExpression = new DistanceFromStringExpression(input);
        distanceFromStringExpression.generateOperandsList();
        assertEquals(expectedResult, distanceFromStringExpression.formatDistanceInLowestUnit());
    }
}
