package de.rubenmaurer;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class MathFirstRecoTest {

    private static String[] correctExpressions = { "10 * 2 / 2 + 4\r\n", "10 + (10*5) / 5\r\n" };

    private static String[] wrongExpressions = { "", "10+5", "9", " \r\n" };

    private static Stream<String> wrongInputs() {
        return Stream.of(wrongExpressions);
    }

    private static Stream<String> correctInputs() {
        return Stream.of(correctExpressions);
    }

    @ParameterizedTest
    @MethodSource("correctInputs")
    @DisplayName("Recognition test. No exceptions expected")
    void recognitionTestWithCorrect(String input) {
        System.out.println(MathFirstReco.recognizeExpression(input));
    }

    @ParameterizedTest
    @MethodSource("wrongInputs")
    @DisplayName("Recognition test. Exceptions expected")
    void recognitionTestWithFailures(String input) {
        Assertions.assertThrows(RuntimeException.class, () -> {
            MathFirstReco.recognizeExpression(input);
        });
    }
}