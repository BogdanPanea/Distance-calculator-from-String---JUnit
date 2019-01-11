package ro.bogdanpanea.calculator;

import org.junit.*;

import static org.junit.Assert.*;

public class DistanceFromStringExpressionTest {

    private DistanceFromStringExpression distanceFromStringExpression;


    @Test
    public void testReturnDistanceInLowestUnit() throws DistanceFromExpressionException {

        String test = "1m+4dm-345cm";
        distanceFromStringExpression = new DistanceFromStringExpression(test);
        distanceFromStringExpression.generateOperandsList();
        assertEquals("-205 cm", distanceFromStringExpression.formatDistanceInLowestUnit());

    }

    @Test
    public void testReturnDistanceInLowestUnit1() throws DistanceFromExpressionException {

        String test = "-1m+4dm-345cm";
        distanceFromStringExpression = new DistanceFromStringExpression(test);
        distanceFromStringExpression.generateOperandsList();
        assertEquals("-405 cm", distanceFromStringExpression.formatDistanceInLowestUnit());

    }

    @Test
    public void testReturnDistanceInCustomUnit2() throws DistanceFromExpressionException {

        String test = "1m+4dm-345cm";
        String newUnit = "dm";
        distanceFromStringExpression = new DistanceFromStringExpression(test);
        distanceFromStringExpression.generateOperandsList();
        assertEquals("-20.5 dm", distanceFromStringExpression.formatDistanceInCustomUnit(newUnit));
    }
}