package ro.bogdanpanea.calculator;

import org.junit.*;

import static org.junit.Assert.*;

public class SumFromStringExpressionTest {

    private  SumFromStringExpression sumFromStringExpression;



    @Test
    public void testReturnDistanceInLowestUnit()  {

        String test = "1m+4dm-345cm";
        sumFromStringExpression = new SumFromStringExpression( test );
        sumFromStringExpression.generateOperandsList();
        assertEquals("-205 cm", sumFromStringExpression.returnDistanceInLowestUnit());

    }

    @Test
    public void testReturnDistanceInCustomUnit() {

        String test = "1m+4dm-345cm";
        sumFromStringExpression = new SumFromStringExpression( test );
        sumFromStringExpression.generateOperandsList();
        assertEquals("-2050 mm", sumFromStringExpression.returnDistanceInCustomUnit( "mm" ));
    }
}