import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import java.util.stream.Stream;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.params.provider.Arguments.arguments;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        Test_Exception.class
} )

public class SuiteTestClass {
    @ParameterizedTest
    @MethodSource("testExpression")
    public void testMathematicalCalculations(double expected, String sumString) {
        Calculator calculator = new Calculator();
        assertEquals(expected, calculator.decide(sumString));
    }

    static Stream<Arguments> testExpression() {
        return Stream.of(
                arguments(10,"3+7"),
                arguments(15,"(3+2)*3"),
                arguments(124.5,"32*4+7/(6-2*4)")
        );
    }
}
