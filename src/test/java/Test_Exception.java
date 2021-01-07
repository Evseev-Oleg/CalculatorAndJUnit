import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.EmptyStackException;

public class Test_Exception {
    private Calculator calculator;

    @Before
    public void initTest() {
        calculator = new Calculator();
    }

    @After
    public void afterTest() {

        calculator = null;
    }

    @Test(expected = IllegalArgumentException.class)
    public void testIncorrectOperations() {

        calculator.decide("(2+3)/0");
    }

    @Test(expected = NumberFormatException.class)
    public void testFormatString() {

        calculator.decide("@+8");
    }

    @Test(expected = EmptyStackException.class)
    public void testIncorrectExpression() {
        calculator.decide("5++9");
    }
}
